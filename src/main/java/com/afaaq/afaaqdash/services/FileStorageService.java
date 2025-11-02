package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.config.FileStorageProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path baseLocation;
    private final String relativeUrlPrefix;

    public FileStorageService(FileStorageProperties properties) {
        this.baseLocation = Paths.get(properties.getLocation()).toAbsolutePath().normalize();
        this.relativeUrlPrefix = properties.getRelativeUrl();
        try {
            Files.createDirectories(baseLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create base storage directory", e);
        }
    }

    /**
     * Store file directly under the base directory without nested folders.
     * Returns the relative URL path that can be stored in DB and returned to client.
     */
    public String store(MultipartFile file, String userId, String category) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        // Validate content-type (optional)
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IOException("Only image files are allowed");
        }

        // Clean and prepare filename
        String original = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = getExtension(original);
        String safeName = sanitize(original);

        // Option 1: Keep original name
        // Path destination = baseLocation.resolve(safeName);

        // Option 2: Add random suffix to avoid overwriting
        String uniqueName = UUID.randomUUID().toString().substring(0, 8) + "_" + safeName;
        Path destination = baseLocation.resolve(safeName).normalize();

        // Ensure safety: file must be inside base directory
        if (!destination.toAbsolutePath().startsWith(baseLocation)) {
            throw new IOException("Cannot store file outside the configured directory.");
        }

        // Save the file
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        // Return relative URL (used in DB or frontend)
        return ensureLeadingSlash(relativeUrlPrefix) + destination.getFileName().toString();
    }

    public boolean deleteByRelativeUrl(String relativeUrl) throws IOException {
        if (relativeUrl == null) return false;
        String prefix = ensureLeadingSlash(relativeUrlPrefix);
        if (!relativeUrl.startsWith(prefix)) {
            return false;
        }
        String relPart = relativeUrl.substring(prefix.length());
        Path target = baseLocation.resolve(relPart).normalize();
        if (!target.toAbsolutePath().startsWith(baseLocation)) {
            return false;
        }
        return Files.deleteIfExists(target);
    }

    private String getExtension(String filename) {
        if (filename == null) return "";
        int idx = filename.lastIndexOf('.');
        return (idx >= 0) ? filename.substring(idx) : "";
    }

    private String sanitize(String input) {
        return input.replaceAll("[^A-Za-z0-9\\-_\\.]", "_");
    }

    private String ensureLeadingSlash(String s) {
        if (s == null || s.isEmpty()) return "/";
        return s.startsWith("/") ? s : "/" + s;
    }
}

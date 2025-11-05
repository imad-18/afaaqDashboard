package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.services.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {

    private final FileStorageService storageService;

    public FileUploadController(FileStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(
            @RequestParam("file") MultipartFile file
            /*@RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "category", required = false) String category*/) {
        try {
            String relativeUrl = storageService.store(file, null, null);
            return ResponseEntity.ok(Map.of(
                    "fileUrl", relativeUrl,
                    "originalName", file.getOriginalFilename()
            ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> deleteFile(@RequestParam("fileUrl") String fileUrl) {
        try {
            boolean deleted = storageService.deleteByRelativeUrl(fileUrl);
            if (deleted) {
                return ResponseEntity.ok(Map.of("message", "File deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "File not found or invalid path"));
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Failed to delete file"));
        }
    }
}

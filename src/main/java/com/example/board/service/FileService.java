package com.example.board.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileService {

    @Value("${spring.multipart.location}")
    private String path;

    public void upload(MultipartFile file) {
        try {
            Files.copy(file.getInputStream()
                    , Paths.get(path).resolve(Objects.requireNonNull(file.getOriginalFilename()))
                    , StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
        }
    }
}

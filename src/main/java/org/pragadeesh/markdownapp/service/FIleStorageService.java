package org.pragadeesh.markdownapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Service
public class FIleStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public void storeFile(MultipartFile file) throws Exception {
        File dir = new File(uploadDir);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        File destinationFile = new File(uploadDir + File.separator + file.getOriginalFilename());
        Files.copy(file.getInputStream(), destinationFile.toPath());
    }
}

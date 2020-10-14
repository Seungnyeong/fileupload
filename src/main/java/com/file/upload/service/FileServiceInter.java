package com.file.upload.service;

import com.file.upload.config.FileUploadProperties;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInter {

    String getRepositoryList();
    String storeFile(MultipartFile file);
}

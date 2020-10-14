package com.file.upload.controller;


import com.file.upload.payload.FileUploadResponse;
import com.file.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileService service;

    @PostMapping("/uploadFile")
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return null;
    }

    @GetMapping("/uploadMultipleFiles")
    @ResponseBody
    public FileUploadResponse uploadMultipleFiles() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("test.png", new FileInputStream(new File("C:\\dev\\repository\\test.png")));
        service.storeFile(multipartFile);
        return new FileUploadResponse(multipartFile.getName(), multipartFile.getContentType(),  multipartFile.getSize());
    }
}

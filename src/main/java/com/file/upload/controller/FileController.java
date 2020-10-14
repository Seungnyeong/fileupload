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
import java.util.ArrayList;
import java.util.List;

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
    public List<FileUploadResponse> uploadMultipleFiles() throws IOException {
        /* Repository 경로 설정 */
        File path = new File("C:\\dev\\repository\\");
        /* Repository 파일목록 읽기*/
        File[] files = path.listFiles();
        /* 파일 리스트 오브젝트*/
        List<FileUploadResponse> transferFileList = new ArrayList<>();
        for(File file : files){
            //Convert File to MultipartFile
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), new FileInputStream(new File(file.getAbsolutePath())));
            // multipartFile save
            service.storeFile(multipartFile);
            // 디렉토리 파일 저장
            transferFileList.add(new FileUploadResponse(multipartFile.getName(), multipartFile.getContentType(),  multipartFile.getSize(), "OK"));
        }
        return transferFileList;
    }
}

package com.example.AWS_S3_bucket_File_Upload.controller;

import com.example.AWS_S3_bucket_File_Upload.service.AmazonClient;
import com.example.AWS_S3_bucket_File_Upload.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class BucketController {

    @Autowired
    AmazonClient amazonClient;
    @PostMapping("/uploadFile")
    public ResponseEntity<StandardResponse>  uploadFile(@RequestPart(value = "file") MultipartFile file) {
        String s = amazonClient.uploadFile(file);
        return new ResponseEntity<>(
                new StandardResponse(200,"save image", s),
                HttpStatus.CREATED
        );
    }

}

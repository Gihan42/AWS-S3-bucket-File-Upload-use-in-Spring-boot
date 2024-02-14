package com.example.AWS_S3_bucket_File_Upload.controller;

import com.amazonaws.auth.policy.Resource;
import com.example.AWS_S3_bucket_File_Upload.service.impl.AmazonClient;
import com.example.AWS_S3_bucket_File_Upload.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

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

    @DeleteMapping(params = {"url"})
    public ResponseEntity<StandardResponse> deleteFile(@RequestParam String url) {
        String s = amazonClient.deleteFileFromS3Bucket(url);
        return new ResponseEntity<>(
                new StandardResponse(200,"delete image", s),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/listObjects")
    public ResponseEntity<StandardResponse> getAllObjects() {
        List<String> strings = amazonClient.listObjectsInBucket();
        return new ResponseEntity<>(
                new StandardResponse(200,"get all image", strings),
                HttpStatus.CREATED
        );
    }
}

package com.example.AWS_S3_bucket_File_Upload.service.impl;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AmazanService {
    File convertMultiPartToFile(MultipartFile file) throws IOException;
    String generateFileName(MultipartFile multiPart);
    void uploadFileTos3bucket(String fileName, File file);
    String uploadFile(MultipartFile multipartFile);
    List<String> listObjectsInBucket();
    String deleteFileFromS3Bucket(String fileUrl);
}

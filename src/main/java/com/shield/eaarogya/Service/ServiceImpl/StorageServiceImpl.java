package com.shield.eaarogya.Service.ServiceImpl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.shield.eaarogya.Service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    public StorageServiceImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile multipartFile) {
        File file = null;
        try {
            file = convertMultiPartFileToFile(multipartFile);

            String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

            s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));

            return "Successfully Uploaded file to AWS S3. File Name = " + fileName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException{
        File file = new File(multipartFile.getOriginalFilename());

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());

        fos.close();

        return file;
    }
}

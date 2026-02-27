package com.heima.minio.test;


import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/27 10:23
 */
public class MinIOTest {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;

        try{
            fileInputStream = new FileInputStream("D:\\list.html");

            MinioClient minioClient = MinioClient.builder()
                    .credentials("minioadmin","minioadmin")
                    .endpoint("http://127.0.0.1:9000").build();

            //上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("list.html")
                    .contentType("text/html")
                    .bucket("bucket")
                    .stream(fileInputStream,fileInputStream.available(),-1)
                    .build();
            minioClient.putObject(putObjectArgs);
            System.out.println("path");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

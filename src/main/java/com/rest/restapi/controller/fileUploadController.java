package com.rest.restapi.controller;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.Servlet;

import com.rest.restapi.helper.fileUploadhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class fileUploadController {
    
    @Autowired
    private fileUploadhelper fuh;
    //handler
    
    @PostMapping("/file-upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
        try {
            if(!file.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpg allowed");
           }
          
           // System.out.println(file.getContentType());
            if(file.isEmpty()){
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
            }
            if(fuh.uploadFile(file))
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
            .path(file.getOriginalFilename()).toUriString());

                 
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        
        return ResponseEntity.ok("some error occured");
    }
}

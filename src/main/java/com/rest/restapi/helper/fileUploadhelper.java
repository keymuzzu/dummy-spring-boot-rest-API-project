package com.rest.restapi.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadhelper  {
   // public final String UPLOAD_DIR = "C:\\Users\\MUZZU\\Documents\\java spring\\restapi\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
    public fileUploadhelper() throws IOException {

    }{

    }
    public boolean uploadFile(MultipartFile file){
        
        boolean f = false;
        try {
        //     InputStream is = file.getInputStream();
        //     byte [] data = new byte[is.available()];
        //     is.read();

        //     FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
        //     fos.write(data);
        //     f = true;
        //    fos.flush();
        //     fos.close();
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }
}

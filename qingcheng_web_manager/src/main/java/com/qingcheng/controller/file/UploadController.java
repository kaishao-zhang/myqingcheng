package com.qingcheng.controller.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author 凯少
 * @create 2019-11-21 14:16
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private OSSClient ossClient;
    @RequestMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("img");
        String filePath = path+ File.separator+file.getOriginalFilename();
        File desFile = new File(filePath);
        if(!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:9101/img/"+file.getOriginalFilename();
    }
    @PostMapping("/oss")
    public String  uploadImg(@RequestParam("file") MultipartFile file,String folder){
       String bucketName = "kbucket1";
       String fileName = folder+"/"+UUID.randomUUID()+file.getOriginalFilename();
        try {
            ossClient.putObject(bucketName,fileName,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "https://"+bucketName+".oss-cn-shanghai.aliyuncs.com"+"/"+fileName;
    }
}

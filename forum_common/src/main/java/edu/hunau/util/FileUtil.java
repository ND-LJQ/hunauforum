package edu.hunau.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件工具类
 *
 * @author ND_LJQ
 * @date 2023/01/03
 */
public class FileUtil {
    public String saveFile(String uploadPath, MultipartFile file){
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //获取原文件名
        String OriginalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
        //重新随机生成名字
        String filename = UUID.randomUUID().toString() +suffixName;
        File localFile = new File(uploadPath+"\\"+filename);
        try {
            //把上传的文件保存至本地
            file.transferTo(localFile);
            /**
             * 这里应该把filename保存到数据库,供前端访问时使用
             */
            System.out.println(filename);
            //上传成功，返回保存的文件名称
            return filename;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("创建失败");
            return "";
        }
    }
}

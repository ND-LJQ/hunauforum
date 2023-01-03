package edu.hunau.util;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static edu.hunau.util.FinalData.IMAGES_SAVE_PATH;


/**
 * 图像工具
 *
 * @author ND_LJQ
 * @date 2022/12/24
 */
public class GetImageUtils {
    public void writeTo(String filename, Part part) throws IOException {
        InputStream inputStream=part.getInputStream();

        System.out.println(filename);
        OutputStream outputStream = new FileOutputStream(IMAGES_SAVE_PATH + filename);

        byte[] buff=new byte[1024];

        int len=-1;

        while((len=inputStream.read(buff))!=-1){
            outputStream.write(buff, 0, len);

        }

        outputStream.close();

        inputStream.close();

    }


    public String getFileName(Part part) {
//String header=part.getHeader("Content-Disposition");

        String header=part.getHeader("Content-Disposition");

        System.out.println(header);

        String filename=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));

        System.out.println(filename);

        return filename;

    }
}
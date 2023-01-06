package edu.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.BackMessage;
import edu.hunau.entity.ForumImage;
import edu.hunau.entity.ForumVideo;
import edu.hunau.mapper.ForumImageMapper;
import edu.hunau.mapper.ForumVideoMapper;
import edu.hunau.util.DateUtil;
import edu.hunau.util.FileUtil;
import edu.hunau.util.NonStaticResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static edu.hunau.util.FinalData.*;

/**
 * 文件控制器
 *
 * @author ND_LJQ
 * @date 2022/12/24
 */
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private ForumVideoMapper forumVideoMapper;

    @Autowired
    private ForumImageMapper forumImageMapper;

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    FileUtil fileUtil = new FileUtil();
    DateUtil dateUtil = new DateUtil();

    @RequestMapping(value = "/uploadimg")
    public @ResponseBody String uploadImg(@RequestParam MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String uploadPath = IMAGES_SAVE_PATH ;
            String result = fileUtil.saveFile(uploadPath,file);
            String absolutePath = uploadPath + "\\" + result;
            ForumImage image = new ForumImage();
            image.setFilename(result);
            image.setCreateTime(dateUtil.getNowSqlDate());
            image.setImgAbsolutePath(absolutePath);
            image.setKey(YitIdHelper.nextId());
            forumImageMapper.insertSelective(image);
            return "";
        }else{
            System.out.println("文件为空");
            return "";
        }
    }

    @PostMapping (value = "/uploadvideo")
    @ResponseBody
    public String uploadVideo(@RequestParam MultipartFile file, HttpServletRequest request){
        BackMessage backMessage = new BackMessage();
        if(!file.isEmpty()){
            String uploadPath = VIDEO_SAVE_PATH ;
            String result = fileUtil.saveFile(uploadPath,file);
            String absolutePath = uploadPath + "\\" + result;
            Long videoId = YitIdHelper.nextId();
            ForumVideo video = new ForumVideo();
            video.setCreateTime(dateUtil.getNowSqlDate());
            video.setVideoAbsolutePath(absolutePath);
            video.setVideoid(videoId);
            video.setVideoTitle(request.getParameter("videoTitle"));
            video.setVideoName(result);
            video.setUserid(Long.valueOf(request.getParameter("userId")));
            forumVideoMapper.insertSelective(video);
            backMessage.setCode(INSERT_SUCCESSFUL);
            backMessage.setMessage("上传成功");
            backMessage.setData(new ForumVideo(videoId));

        }else{
            backMessage.setCode(INSERT_FAILED);
            backMessage.setMessage("参数错误,或上传文件为空");
        }
        return JSON.toJSONString(backMessage);
    }


    @GetMapping(value = {"/getvideo/{videoId}"})
    public void videoPreview(HttpServletRequest request, HttpServletResponse response,@PathVariable String videoId) throws Exception{
        ForumVideo video = forumVideoMapper.selectByPrimaryKey(Long.valueOf(videoId));
        String videoPath = video.getVideoAbsolutePath();
        //保存视频磁盘路径
        Path filePath = Paths.get(videoPath);
        if(Files.exists(filePath)){
            //获取视频的类型，比如是MP4这样
            String mimeType = Files.probeContentType(filePath);
            if (StringUtils.hasText(mimeType)) {
                //判断类型，根据不同的类型文件来处理对应的数据
                response.setContentType(mimeType);
            }
            //转换视频流部分
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    @DeleteMapping(value = {"/deletevideo/{videoId}"})
    public Integer deleteVideo(@PathVariable String videoId) throws Exception{
        ForumVideo video = new ForumVideo();
        video.setVideoid(Long.valueOf(videoId));
        video.setIsDelete(1);
        return this.forumVideoMapper.updateByPrimaryKeySelective(video);
    }

    @GetMapping(value = {"/uservideo/{userId}"})
    public String selectVideoByUserId(@PathVariable String userId){
        return JSON.toJSONString(this.forumVideoMapper.selectByUserId(Long.valueOf(userId)));
    }




}

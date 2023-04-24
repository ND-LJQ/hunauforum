package edu.hunau.controller;


import com.alibaba.fastjson.JSON;
import edu.hunau.entity.ForumArticle;
import edu.hunau.entity.ForumArticleWithBLOBs;
import edu.hunau.service.SearchService;
import edu.hunau.util.DateUtil;
import edu.hunau.util.FileUtil;
import edu.hunau.util.NonStaticResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 搜索控制器
 *
 * @author ND_LJQ
 * @date 2022/12/24
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

//    @Autowired
//    private ForumVideoMapper forumVideoMapper;
//
//    @Autowired
//    private ForumImageMapper forumImageMapper;

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    FileUtil fileUtil = new FileUtil();
    DateUtil dateUtil = new DateUtil();

    @PostMapping(value = "/title")
    @ResponseBody
    public String searchArticleListByTitle(HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));

        System.out.println(keyword);
        System.out.println(pageNum);
        List<ForumArticleWithBLOBs> resultList =  searchService.getArticleListByTitle(keyword,pageNum,pageSize);
        String resultStr = JSON.toJSONString(resultList);
        return resultStr;
    }

//    @RequestMapping(value = "/uploadimg")
//    public @ResponseBody String uploadImg(@RequestParam MultipartFile file, HttpServletRequest request){
//        if(!file.isEmpty()){
//            String uploadPath = IMAGES_SAVE_PATH ;
//            String result = fileUtil.saveFile(uploadPath,file);
//            String absolutePath = uploadPath + "\\" + result;
//            ForumImage image = new ForumImage();
//            image.setFilename(result);
//            image.setCreateTime(dateUtil.getNowSqlDate());
//            image.setImgAbsolutePath(absolutePath);
//            image.setKey(YitIdHelper.nextId());
//            forumImageMapper.insertSelective(image);
//            return "";
//        }else{
//            System.out.println("文件为空");
//            return "";
//        }
//    }
//
//    @PostMapping (value = "/uploadvideo")
//    @ResponseBody
//    public String uploadVideo(@RequestParam MultipartFile file, HttpServletRequest request){
//        BackMessage backMessage = new BackMessage();
//        if(!file.isEmpty()){
//            String uploadPath = VIDEO_SAVE_PATH ;
//            String result = fileUtil.saveFile(uploadPath,file);
//            String absolutePath = uploadPath + "\\" + result;
//            Long videoId = YitIdHelper.nextId();
//            ForumVideo video = new ForumVideo();
//            video.setCreateTime(dateUtil.getNowSqlDate());
//            video.setVideoAbsolutePath(absolutePath);
//            video.setVideoid(videoId);
//            video.setVideoTitle(request.getParameter("videoTitle"));
//            video.setVideoName(result);
//            video.setUserid(Long.valueOf(request.getParameter("userId")));
//            forumVideoMapper.insertSelective(video);
//            backMessage.setCode(INSERT_SUCCESSFUL);
//            backMessage.setMessage("上传成功");
//            backMessage.setData(new ForumVideo(videoId));
//
//        }else{
//            backMessage.setCode(INSERT_FAILED);
//            backMessage.setMessage("参数错误,或上传文件为空");
//        }
//        return JSON.toJSONString(backMessage);
//    }







}

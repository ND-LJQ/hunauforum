package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumVideo implements Serializable {
    private Long videoid;

    private String videoAbsolutePath;

    private String videoName;

    private Date createTime;

    private Long userid;

    private String videoTitle;

    private static final long serialVersionUID = 1L;

    public ForumVideo(){}

    public ForumVideo(Long videoid){
        this.videoid = videoid;
    }

    public Long getVideoid() {
        return videoid;
    }

    public void setVideoid(Long videoid) {
        this.videoid = videoid;
    }

    public String getVideoAbsolutePath() {
        return videoAbsolutePath;
    }

    public void setVideoAbsolutePath(String videoAbsolutePath) {
        this.videoAbsolutePath = videoAbsolutePath == null ? null : videoAbsolutePath.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoid=").append(videoid);
        sb.append(", videoAbsolutePath=").append(videoAbsolutePath);
        sb.append(", videoName=").append(videoName);
        sb.append(", createTime=").append(createTime);
        sb.append(", userid=").append(userid);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
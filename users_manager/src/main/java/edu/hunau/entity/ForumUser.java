package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumUser implements Serializable {
    private Long userId;

    private String username;

    private String email;

    private String avatar;

    private String cover;

    private String password;

    private String createIp;

    private String createLocation;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String lastLoginLocation;

    private Integer followerCount;

    private Integer followeeCount;

    private Integer followingArticleCount;

    private Integer followingQuestionCount;

    private Integer followingTopicCount;

    private Integer articleCount;

    private Integer questionCount;

    private Integer answerCount;

    private Integer notificationUnread;

    private Integer inboxUnread;

    private String headline;

    private String bio;

    private String blog;

    private String company;

    private String location;

    private Date createTime;

    private Date updateTime;

    private Date disableTime;

    private String tel;

    private String qqNumber;

    private String salt;

    private Integer state;
    private static final long serialVersionUID = 1L;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public String getCreateLocation() {
        return createLocation;
    }

    public void setCreateLocation(String createLocation) {
        this.createLocation = createLocation == null ? null : createLocation.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLastLoginLocation() {
        return lastLoginLocation;
    }

    public void setLastLoginLocation(String lastLoginLocation) {
        this.lastLoginLocation = lastLoginLocation == null ? null : lastLoginLocation.trim();
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getFolloweeCount() {
        return followeeCount;
    }

    public void setFolloweeCount(Integer followeeCount) {
        this.followeeCount = followeeCount;
    }

    public Integer getFollowingArticleCount() {
        return followingArticleCount;
    }

    public void setFollowingArticleCount(Integer followingArticleCount) {
        this.followingArticleCount = followingArticleCount;
    }

    public Integer getFollowingQuestionCount() {
        return followingQuestionCount;
    }

    public void setFollowingQuestionCount(Integer followingQuestionCount) {
        this.followingQuestionCount = followingQuestionCount;
    }

    public Integer getFollowingTopicCount() {
        return followingTopicCount;
    }

    public void setFollowingTopicCount(Integer followingTopicCount) {
        this.followingTopicCount = followingTopicCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getNotificationUnread() {
        return notificationUnread;
    }

    public void setNotificationUnread(Integer notificationUnread) {
        this.notificationUnread = notificationUnread;
    }

    public Integer getInboxUnread() {
        return inboxUnread;
    }

    public void setInboxUnread(Integer inboxUnread) {
        this.inboxUnread = inboxUnread;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog == null ? null : blog.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", cover='" + cover + '\'' +
                ", password='" + password + '\'' +
                ", createIp='" + createIp + '\'' +
                ", createLocation='" + createLocation + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginLocation='" + lastLoginLocation + '\'' +
                ", followerCount=" + followerCount +
                ", followeeCount=" + followeeCount +
                ", followingArticleCount=" + followingArticleCount +
                ", followingQuestionCount=" + followingQuestionCount +
                ", followingTopicCount=" + followingTopicCount +
                ", articleCount=" + articleCount +
                ", questionCount=" + questionCount +
                ", answerCount=" + answerCount +
                ", notificationUnread=" + notificationUnread +
                ", inboxUnread=" + inboxUnread +
                ", headline='" + headline + '\'' +
                ", bio='" + bio + '\'' +
                ", blog='" + blog + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", disableTime=" + disableTime +
                ", tel='" + tel + '\'' +
                ", qqNumber='" + qqNumber + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                '}';
    }
}
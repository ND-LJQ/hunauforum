package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 论坛用户
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
public class ForumUser implements Serializable {
    private Integer userId;

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

    private Integer tel;

    private Integer qqNumber;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Integer qqNumber) {
        this.qqNumber = qqNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", cover=").append(cover);
        sb.append(", password=").append(password);
        sb.append(", createIp=").append(createIp);
        sb.append(", createLocation=").append(createLocation);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", lastLoginLocation=").append(lastLoginLocation);
        sb.append(", followerCount=").append(followerCount);
        sb.append(", followeeCount=").append(followeeCount);
        sb.append(", followingArticleCount=").append(followingArticleCount);
        sb.append(", followingQuestionCount=").append(followingQuestionCount);
        sb.append(", followingTopicCount=").append(followingTopicCount);
        sb.append(", articleCount=").append(articleCount);
        sb.append(", questionCount=").append(questionCount);
        sb.append(", answerCount=").append(answerCount);
        sb.append(", notificationUnread=").append(notificationUnread);
        sb.append(", inboxUnread=").append(inboxUnread);
        sb.append(", headline=").append(headline);
        sb.append(", bio=").append(bio);
        sb.append(", blog=").append(blog);
        sb.append(", company=").append(company);
        sb.append(", location=").append(location);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", disableTime=").append(disableTime);
        sb.append(", tel=").append(tel);
        sb.append(", qqNumber=").append(qqNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
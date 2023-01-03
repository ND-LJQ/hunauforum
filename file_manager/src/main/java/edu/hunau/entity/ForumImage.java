package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumImage implements Serializable {
    private Long key;

    private String filename;

    private Date createTime;

    private String itemType;

    private Long itemId;

    private Long userId;

    private String imgAbsolutePath;

    private static final long serialVersionUID = 1L;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgAbsolutePath() {
        return imgAbsolutePath;
    }

    public void setImgAbsolutePath(String imgAbsolutePath) {
        this.imgAbsolutePath = imgAbsolutePath == null ? null : imgAbsolutePath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", key=").append(key);
        sb.append(", filename=").append(filename);
        sb.append(", createTime=").append(createTime);
        sb.append(", itemType=").append(itemType);
        sb.append(", itemId=").append(itemId);
        sb.append(", userId=").append(userId);
        sb.append(", imgAbsolutePath=").append(imgAbsolutePath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
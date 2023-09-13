package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumPermissions implements Serializable {
    private Long permissionsId;

    private Integer permissionsLevel;

    private String permissionsName;

    private String description;

    private Byte state;

    private Byte isDeleted;

    private Long createUser;

    private Long updateUser;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private static final long serialVersionUID = 1L;

    public Long getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
    }

    public Integer getPermissionsLevel() {
        return permissionsLevel;
    }

    public void setPermissionsLevel(Integer permissionsLevel) {
        this.permissionsLevel = permissionsLevel;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName == null ? null : permissionsName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public ForumPermissions(){};

    public ForumPermissions(Long permissionsId, Byte isDeleted) {
        this.permissionsId = permissionsId;
        this.isDeleted = isDeleted;
    }

    public ForumPermissions(Integer level, String name, String desc, Long userId, java.sql.Date nowSqlDate, long permissionsId,Byte state,Byte isDeleted) {
        this.permissionsLevel = level;
        this.permissionsName = name;
        this.description = desc;
        this.createUser = userId;
        this.createTime = nowSqlDate;
        this.permissionsId = permissionsId;
        this.state = state;
        this.isDeleted = isDeleted;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionsId=").append(permissionsId);
        sb.append(", permissionsLevel=").append(permissionsLevel);
        sb.append(", permissionsName=").append(permissionsName);
        sb.append(", description=").append(description);
        sb.append(", state=").append(state);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumUserRole implements Serializable {
    private Long id;

    private Long userId;

    private Integer roleId;

    private Byte isDeleted;

    private Long createUser;

    private Long updateUser;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public ForumUserRole(){}

    public ForumUserRole(Byte deleteIsLogic) {
        this.isDeleted = deleteIsLogic;
    }

    public ForumUserRole(Long id,Long userId, Integer roleId, Long administratorId, Byte deleteNoLogic, java.sql.Date nowSqlDate) {
        this.userId = userId;
        this.roleId = roleId;
        this.createUser = administratorId;
        this.createTime = nowSqlDate;
        this.isDeleted = deleteNoLogic;
        this.id = id;
    }

    public ForumUserRole(Long userId, Integer roleId, Long administratorId) {
        this.userId = userId;
        this.roleId = roleId;
        this.createUser = administratorId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
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
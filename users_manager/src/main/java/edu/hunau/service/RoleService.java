package edu.hunau.service;

import edu.hunau.entity.ForumPermissions;
import edu.hunau.entity.ForumRole;

/**
 * 权限(角色)的增删改查
 * @author ND_LJQ
 * @date 2023/09/12
 */
public interface RoleService {

    /**
     * 通过id查询角色
     * @param id
     * @return {@link ForumRole}
     */
    public ForumRole queryRoleByKey(Integer id);


    /**
     * 更新角色
     * @param role
     * @return int
     */
    public int updateRole(ForumRole role);


    /**
     * 逻辑删除角色
     *
     * @param id id
     * @return {@link Integer}
     */
    public Integer deleteRoleByKey(Integer id);


    /**
     * 增加角色
     * @param forumRole
     * @return {@link Integer}
     */
    public Integer insertRole(ForumRole forumRole);


    /**
     * 增加权限
     * @param forumPermissions
     * @return {@link Integer}
     */
    public Integer insertPermission(ForumPermissions forumPermissions);

    /**
     * 逻辑删除权限
     * @param id
     * @return {@link Integer}
     */
    public Integer deletePermission(Long id);

    /**
     * 更新权限
     * @param forumPermissions
     * @return {@link Integer}
     */
    public Integer updatePermission(ForumPermissions forumPermissions);

    /**
     * 通过id查询权限
     * @param id
     * @return {@link ForumPermissions}
     */
    public ForumPermissions queryPermission(Long id);
}

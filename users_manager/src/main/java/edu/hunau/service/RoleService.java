package edu.hunau.service;

import edu.hunau.entity.ForumPermissions;
import edu.hunau.entity.ForumRole;
import edu.hunau.entity.ForumRolePermissions;
import edu.hunau.entity.ForumUserRole;

import java.util.List;

/**
 * 权限(角色)的增删改查
 * @author ND_LJQ
 * @date 2023/09/12
 */
public interface RoleService {

    /**
     * 通过id查询角色
     *
     * @param id id
     * @return {@link ForumRole}
     */
    public ForumRole queryRoleByKey(Integer id);


    /**
     * 更新角色
     *
     * @param role 角色
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


    /**
     * 插入角色权限
     *
     * @param forumRolePermissions 论坛角色权限
     * @return {@link Integer}
     */
    public Integer insertRolePermissions(ForumRolePermissions forumRolePermissions);

    /**
     * 删除角色权限
     *
     * @param id id
     * @return {@link Integer}
     */
    public Integer deleteRolePermissions(Integer id);


    /**
     * 修改角色权限
     *
     * @param forumRolePermissions 论坛角色权限
     * @return {@link Integer}
     */
    public Integer modifyRolePermissions(ForumRolePermissions forumRolePermissions);


    /**
     * 查询角色权限
     *
     * @param roleId 角色id
     * @return {@link List}<{@link ForumRolePermissions}>
     */
    public List<ForumRolePermissions> queryRolePermissionsByRoleId(Integer roleId);


    /**
     * 插入用户角色
     *
     * @param forumUserRole 论坛用户角色
     * @return {@link Integer}
     */
    public Integer insertUserRole(ForumUserRole forumUserRole);


    /**
     * 更新用户角色
     *
     * @param forumUserRole 论坛用户角色
     * @return {@link Integer}
     */
    public Integer updateUserRoles(ForumUserRole forumUserRole);


    /**
     * 删除用户角色
     *
     * @param userId 用户id
     * @return {@link Integer}
     */
    public Integer deleteUserRole(Long userId);

}

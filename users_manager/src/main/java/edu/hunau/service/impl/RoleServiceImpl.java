package edu.hunau.service.impl;

import edu.hunau.entity.*;
import edu.hunau.mapper.ForumPermissionsMapper;
import edu.hunau.mapper.ForumRoleMapper;
import edu.hunau.mapper.ForumRolePermissionsMapper;
import edu.hunau.mapper.ForumUserRoleMapper;
import edu.hunau.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.hunau.util.FinalData.DELETE_IS_LOGIC;

/**
 * 权限服务实现
 * @author ND_LJQ
 * @date 2023/09/12
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ForumPermissionsMapper forumPermissionsMapper;

    @Autowired
    private ForumRoleMapper forumRoleMapper;

    @Autowired
    private ForumRolePermissionsMapper forumRolePermissionsMapper;

    @Autowired
    private ForumUserRoleMapper forumUserRoleMapper;


    /**
     * 查询角色
     *
     * @param id id
     * @return {@link ForumRole}
     */
    @Override
    public ForumRole queryRoleByKey(Integer id) {
        return forumRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新用户权限
     *
     * @param role 角色
     * @return int
     */
    @Override
    public int updateRole(ForumRole role) {
        return forumRoleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 删除角色
     *
     * @param id id
     * @return {@link Integer}
     */
    @Override
    public Integer deleteRoleByKey(Integer id) {
        return forumRoleMapper.updateByPrimaryKeySelective(new ForumRole(id,DELETE_IS_LOGIC));
    }

    /**
     * 增加角色
     *
     * @param forumRole 论坛角色
     * @return {@link Integer}
     */
    @Override
    public Integer insertRole(ForumRole forumRole) {
        return forumRoleMapper.insertSelective(forumRole);
    }

    /**
     * 增加权限
     *
     * @param forumPermissions 论坛权限
     * @return {@link Integer}
     */
    @Override
    public Integer insertPermission(ForumPermissions forumPermissions) {
        return forumPermissionsMapper.insertSelective(forumPermissions);
    }

    /**
     * 删除权限
     * 逻辑删除权限
     *
     * @param id id
     * @return {@link Integer}
     */
    @Override
    public Integer deletePermission(Long id) {
        return forumPermissionsMapper.updateByPrimaryKeySelective( new ForumPermissions(id,DELETE_IS_LOGIC));
    }

    /**
     * 更新权限
     *
     * @param forumPermissions 论坛权限
     * @return {@link Integer}
     */
    @Override
    public Integer updatePermission(ForumPermissions forumPermissions) {
        return forumPermissionsMapper.insertSelective(forumPermissions);
    }

    /**
     * 通过id查询权限
     *
     * @param id
     * @return {@link ForumPermissions}
     */
    @Override
    public ForumPermissions queryPermission(Long id) {
        return forumPermissionsMapper.selectByPrimaryKey(id);
    }

    /**
     * 插入角色权限
     *
     * @param forumRolePermissions 论坛角色权限
     * @return {@link Integer}
     */
    @Override
    public Integer insertRolePermissions(ForumRolePermissions forumRolePermissions) {
        return forumRolePermissionsMapper.insertSelective(forumRolePermissions);
    }

    /**
     * 删除角色权限
     *
     * @param id id
     * @return {@link Integer}
     */
    @Override
    public Integer deleteRolePermissions(Integer id) {
        return forumRolePermissionsMapper.updateByPrimaryKeySelective(new ForumRolePermissions(id,DELETE_IS_LOGIC));
    }

    /**
     * 修改角色权限
     *
     * @param forumRolePermissions 论坛角色权限
     * @return {@link Integer}
     */
    @Override
    public Integer modifyRolePermissions(ForumRolePermissions forumRolePermissions) {
        return forumRolePermissionsMapper.updateByPrimaryKeySelective(forumRolePermissions);
    }

    /**
     * 查询角色权限
     *
     * @param roleId 角色id
     * @return {@link List}<{@link ForumRolePermissions}>
     */
    @Override
    public List<ForumRolePermissions> queryRolePermissionsByRoleId(Integer roleId) {
        ForumRolePermissionsExample forumRolePermissionsExample = new ForumRolePermissionsExample();
        forumRolePermissionsExample.createCriteria().andRoleIdEqualTo(roleId);
        return forumRolePermissionsMapper.selectByExample(forumRolePermissionsExample);
    }

    /**
     * 插入用户角色
     *
     * @param forumUserRole 论坛用户角色
     * @return {@link Integer}
     */
    @Override
    public Integer insertUserRole(ForumUserRole forumUserRole) {
        return forumUserRoleMapper.insertSelective(forumUserRole);
    }

    /**
     * 更新用户角色
     *
     * @param forumUserRole 论坛用户角色
     * @return {@link Integer}
     */
    @Override
    public Integer updateUserRoles(ForumUserRole forumUserRole) {
        ForumUserRoleExample forumUserRoleExample = new ForumUserRoleExample();
        forumUserRoleExample.createCriteria().andUserIdEqualTo(forumUserRole.getUserId());
        return forumUserRoleMapper.updateByExampleSelective(forumUserRole,forumUserRoleExample);
    }

    /**
     * 删除用户角色
     *
     * @param userId 用户id
     * @return {@link Integer}
     */
    @Override
    public Integer deleteUserRole(Long userId) {
        ForumUserRoleExample forumUserRoleExample = new ForumUserRoleExample();
        forumUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        return forumUserRoleMapper.updateByExampleSelective(new ForumUserRole(DELETE_IS_LOGIC),forumUserRoleExample);
    }


}

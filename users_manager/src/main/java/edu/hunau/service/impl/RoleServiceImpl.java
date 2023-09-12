package edu.hunau.service.impl;

import edu.hunau.entity.ForumPermissions;
import edu.hunau.entity.ForumRole;
import edu.hunau.mapper.ForumPermissionsMapper;
import edu.hunau.mapper.ForumRoleMapper;
import edu.hunau.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public ForumRole queryRoleByKey(Integer id) {
        return forumRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新用户权限
     *
     * @param role
     * @return int
     */
    @Override
    public int updateRole(ForumRole role) {
        return forumRoleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return {@link Boolean}
     */
    @Override
    public Integer deleteRoleByKey(Integer id) {
        return forumRoleMapper.updateByPrimaryKey(new ForumRole(id,DELETE_IS_LOGIC.toString()));
    }

    /**
     * 增加角色
     *
     * @param forumRole
     * @return {@link Integer}
     */
    @Override
    public Integer insertRole(ForumRole forumRole) {
        return forumRoleMapper.insertSelective(forumRole);
    }

    /**
     * 增加权限
     *
     * @param forumPermissions
     * @return {@link Integer}
     */
    @Override
    public Integer insertPermission(ForumPermissions forumPermissions) {
        return forumPermissionsMapper.insertSelective(forumPermissions);
    }

    /**
     * 逻辑删除权限
     *
     * @param id
     * @return {@link Integer}
     */
    @Override
    public Integer deletePermission(Long id) {
        return forumPermissionsMapper.insertSelective( new ForumPermissions(id,DELETE_IS_LOGIC));
    }

    /**
     * 更新权限
     *
     * @param forumPermissions
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


}

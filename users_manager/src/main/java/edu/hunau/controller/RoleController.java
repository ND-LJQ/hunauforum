package edu.hunau.controller;

import com.github.yitter.idgen.YitIdHelper;
import edu.hunau.entity.*;
import edu.hunau.service.RoleService;
import edu.hunau.util.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


import java.security.Permission;
import java.util.Date;

import static edu.hunau.util.FinalData.*;

/**
 * 角色控制器
 *
 * @author ND_LJQ
 * @date 2023/09/12
 */

@RestController
@RequestMapping("/forumpermission")
public class RoleController {

    @Autowired
    RoleService roleService;

    DateUtil dateUtil =new DateUtil();


    /**
     * 角色变更
     *
     * @param request 请求
     * @return {@link BackMessage}
     */
    @PostMapping(value ={"/role/update"})
    public BackMessage roleChange(HttpServletRequest request){
        try{
            ForumRole role = new ForumRole();
            BeanUtils.populate(role, request.getParameterMap());
            roleService.updateRole(role);
            return new BackMessage("修改成功!",UPDATE_SUCCESSFUL);
        }catch (Exception e){
            return new BackMessage("修改失败!请检查参数格式",UPDATE_FAILED);
        }
    }


    /**
     * 角色插入
     *
     * @param name        名称
     * @param grade       等级
     * @param description 描述
     * @param userId      用户id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/role/create"})
    public BackMessage roleInsert(@RequestParam String name,String grade,String description,String userId) throws Exception{
      try{
          roleService.insertRole(new ForumRole(name,grade,description,ENABLED_LOGIC,DELETE_NO_LOGIC,Long.valueOf(userId),dateUtil.getNowSqlDate()));
          return new BackMessage("添加成功!",INSERT_SUCCESSFUL);
      }catch (Exception e){
          return new BackMessage("添加失败!",INSERT_FAILED);
      }
    }


    /**
     * 角色删除
     *
     * @param id id
     * @return {@link BackMessage}
     */
    @GetMapping (value = {"/role/del/{id}"})
    public BackMessage roleDel(@PathVariable("id") Integer id) throws Exception{
        try{
            Integer res = roleService.deleteRoleByKey(id);
            if(res == 1){
                return new BackMessage("删除成功!",DELETE_SUCCESSFUL);
            }else{
                return new BackMessage("删除失败!",DELETE_FAILED);
            }

        }catch (Exception e){
            return new BackMessage("删除失败!请检查参数是否有问题",DELETE_FAILED);
        }
    }


    /**
     * 权限更改
     *
     * @param request 请求
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/permission/update"})
    public BackMessage permissionChange(HttpServletRequest request) throws Exception {
       try{
           ForumPermissions permissions = new ForumPermissions();
           BeanUtils.populate(permissions, request.getParameterMap());
           permissions.setUpdateTime(dateUtil.getNowSqlDate());
           roleService.updatePermission(permissions);
           return new BackMessage("修改成功!",UPDATE_SUCCESSFUL);
       }catch (Exception e){
           return new BackMessage("修改失败!请检查参数格式",UPDATE_FAILED);
       }
    }


    /**
     * 权限插入
     *
     * @param level  数量
     * @param name   名称
     * @param desc   描述
     * @param userId 用户id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/permission/create"})
    public BackMessage permissionInsert(@RequestParam Integer level,@RequestParam String name,@RequestParam(required = false) String desc,@RequestParam String userId)throws Exception{
        try{
            Integer res = roleService.insertPermission(new ForumPermissions(level,name,desc,Long.valueOf(userId),dateUtil.getNowSqlDate(),YitIdHelper.nextId(),ENABLED_LOGIC,DELETE_NO_LOGIC));
            if(res == 1){
                return new BackMessage("添加成功!",INSERT_SUCCESSFUL);
            }else{
                return new BackMessage("添加失败!",INSERT_FAILED);
            }
        }catch (Exception e){
            return new BackMessage("添加失败!请检查参数是否有问题",INSERT_FAILED);
        }
    }

    /**
     * 权限删除
     *
     * @param id id
     * @return {@link BackMessage}
     */
    @GetMapping(value = {"/permission/del/{id}"})
    public BackMessage permissionDel(@PathVariable("id") String id){
        try{
            Integer res = roleService.deletePermission(Long.valueOf(id));
            if(res == 1){
                return new BackMessage("删除成功!",DELETE_SUCCESSFUL);
            }else{
                return new BackMessage("删除失败!",DELETE_FAILED);
            }

        }catch (Exception e){
            return new BackMessage("删除失败!请检查参数是否有问题",DELETE_FAILED);
        }
    }


    /**
     * 授予角色权限
     *
     * @param roleId        角色id
     * @param permissionsId 权限id
     * @param userId        用户id
     * @return {@link BackMessage}
     * @throws Exception 例外
     */
    @PostMapping(value = {"/role/roleable"})
    public BackMessage roleGrantingPermissions(@RequestParam Integer roleId,@RequestParam String permissionsId,@RequestParam String userId) throws Exception{
        try{
            Integer res = roleService.insertRolePermissions(new ForumRolePermissions(roleId,Long.valueOf(permissionsId),Long.valueOf(userId),dateUtil.getNowSqlDate(),DELETE_NO_LOGIC));
            if(res==1){
                return new BackMessage("添加成功!",INSERT_SUCCESSFUL);
            }else {
                return new BackMessage("添加失败!请稍后进行操作", INSERT_FAILED);
            }
        }catch (Exception e){
            return new BackMessage("添加失败!请检查参数是否正确",INSERT_FAILED);
        }
    }


    /**
     * 删除角色权限
     *
     * @param roleabledId 角色权限id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/role/roleabledel"})
    public BackMessage deleteRolePermissions(@RequestParam Integer roleabledId) throws Exception{
        try{
            Integer res = roleService.deleteRolePermissions(roleabledId);
            if (res == 1){
                return new BackMessage("删除成功!",DELETE_SUCCESSFUL);
            }else{
                return new BackMessage("删除失败!请稍后删除",DELETE_SUCCESSFUL);
            }
        }catch(Exception e){
            return new BackMessage("删除失败!请检查参数是否正确",DELETE_FAILED);
        }
    }


    /**
     * 分配用户角色
     *
     * @param userId          用户id
     * @param roleId          角色id
     * @param administratorId 管理员id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/role/userrole"})
    public BackMessage assignUserRoles(@RequestParam String userId,@RequestParam Integer roleId,@RequestParam String administratorId) throws Exception{
        try{
            Integer res = roleService.insertUserRole(new ForumUserRole(YitIdHelper.nextId(),Long.valueOf(userId),roleId,Long.valueOf(administratorId),DELETE_NO_LOGIC,dateUtil.getNowSqlDate()));
            if(res==1){
                return new BackMessage("添加成功!",INSERT_SUCCESSFUL);
            }else {
                return new BackMessage("添加失败!请稍后进行操作", INSERT_FAILED);
            }
        }catch (Exception e){
            return new BackMessage("添加失败!请检查参数是否正确",INSERT_FAILED);
        }
    }

    /**
     * 删除用户角色
     *
     * @param userId 用户id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/role/userroledel"})
    public BackMessage deleteUserRole(@RequestParam String userId){
        try{
            Integer res = roleService.deleteUserRole(Long.valueOf(userId));
            if(res==1){
                return new BackMessage("删除成功!",DELETE_SUCCESSFUL);
            }else {
                return new BackMessage("删除失败!请稍后进行操作", DELETE_FAILED);
            }
        }catch (Exception e){
            return new BackMessage("删除失败!请检查参数是否正确",DELETE_FAILED);
        }
    }


    /**
     * 修改用户角色
     *
     * @param userId          用户id
     * @param roleId          角色id
     * @param administratorId 管理员id
     * @return {@link BackMessage}
     */
    @PostMapping(value = {"/role/userroleupdate"})
    public BackMessage modifyUserRole(@RequestParam String userId, @RequestParam Integer roleId, @RequestParam String administratorId, @RequestParam(required = false) Byte isDeleted) {
        try {
            Date nowDate = dateUtil.getNowSqlDate();
            ForumUserRole forumUserRole = new ForumUserRole(Long.valueOf(userId), roleId, Long.valueOf(administratorId));

            if (isDeleted != null) {
                forumUserRole.setUpdateTime(nowDate);

                if (isDeleted == 0) {
                    Integer res = roleService.updateUserRoles(forumUserRole);
                    if (res == 1) {
                        return new BackMessage("修改成功!", UPDATE_SUCCESSFUL);
                    } else {
                        return new BackMessage("修改失败!请检查参数是否正确", UPDATE_FAILED);
                    }
                } else if (isDeleted == 1) {
                    forumUserRole.setDeleteTime(nowDate);
                    Integer res = roleService.updateUserRoles(forumUserRole);
                    if (res == 1) {
                        return new BackMessage("修改成功!", UPDATE_SUCCESSFUL);
                    } else {
                        return new BackMessage("修改失败!请检查参数是否正确", UPDATE_FAILED);
                    }
                }
            }
        } catch (Exception e) {
            return new BackMessage("修改失败!请检查参数是否正确", UPDATE_FAILED);
        }

        return new BackMessage("修改失败!请检查参数是否正确", UPDATE_FAILED);
    }



}

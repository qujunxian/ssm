package com.itheima.ssm.dao.system;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    /**
     * 查询全部
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Role findById(String id);

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    boolean save(Role role);

    /**
     * 删除角色的权限
     *
     * @param roleId
     * @return
     */
    boolean deletePermission(String roleId);

    /**
     * 添加角色的权限
     *
     * @param roleId
     * @param permissionId
     */
    void savePermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}

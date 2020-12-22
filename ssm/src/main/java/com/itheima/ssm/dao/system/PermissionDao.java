package com.itheima.ssm.dao.system;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionDao {
    /**
     * 查询全部
     *
     * @return
     */
    List<Permission> findAll();

    /**
     * 添加
     *
     * @param permission
     * @return
     */
    boolean save(Permission permission);

}

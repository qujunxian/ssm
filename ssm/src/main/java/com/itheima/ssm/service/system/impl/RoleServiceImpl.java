package com.itheima.ssm.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.system.RoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo<Role> findAll(Integer start, Integer pageSize) {
        PageHelper.startPage(start, pageSize);
        List<Role> all = roleDao.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public boolean save(Role role) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        role.setId(id);
        return roleDao.save(role);
    }

    @Override
    public void addPermissionToRole(String ids, String roleId) {
        //对中间表的操作
        //先删除角色的所有的权限信息
        roleDao.deletePermission(roleId);
        //判断ids是否为null
        if (ids != null) {
            String[] permissionIds = ids.split(",");
            //遍历添加角色的拥有的权限信息
            for (String permissionId : permissionIds) {
                roleDao.savePermission(roleId, permissionId);
            }
        }
    }
}

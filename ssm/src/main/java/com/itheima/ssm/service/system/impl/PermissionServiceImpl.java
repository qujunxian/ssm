package com.itheima.ssm.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.system.PermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.system.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public PageInfo<Permission> findAll(Integer start, Integer pageSize) {
        PageHelper.startPage(start, pageSize);
        List<Permission> all = permissionDao.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public boolean save(Permission permission) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        permission.setId(id);
        return permissionDao.save(permission);
    }
}

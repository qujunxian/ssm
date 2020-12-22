package com.itheima.ssm.controller.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.system.PermissionService;
import com.itheima.ssm.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/role/findAll")
    public ModelAndView findAll(Integer start,Integer pageSize,ModelAndView modelAndView){
        if (start==null)
            start=1;
        if (pageSize==null)
            pageSize=5;
        PageInfo<Role> roleList = roleService.findAll(start,pageSize);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("/pages/role-list.jsp");
        return modelAndView;
    }

    @RequestMapping("/role/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id, ModelAndView modelAndView){
        Role role = roleService.findById(id);
        modelAndView.addObject("role",role);
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("/pages/role-permission-add.jsp");
        return modelAndView;
    }

    @RequestMapping("/role/addPermissionToRole")
    public ModelAndView addPermissionToRole(String ids,String roleId,ModelAndView modelAndView){
        roleService.addPermissionToRole(ids,roleId);
        modelAndView.setViewName("/role/findAll.do");
        return modelAndView;
    }

    @RequestMapping("/role/save")
    public ModelAndView save(Role role,ModelAndView modelAndView){
        roleService.save(role);
        PageInfo<Role> roleList = roleService.findAll(1,5);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("/pages/role-list.jsp");
        return modelAndView;
    }
}

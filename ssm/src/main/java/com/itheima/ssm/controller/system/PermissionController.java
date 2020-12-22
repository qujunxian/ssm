package com.itheima.ssm.controller.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.system.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/permission/findAll")
    public ModelAndView findAll(Integer start,Integer pageSize,ModelAndView modelAndView){
        if (start==null) {
            start=1;
        }
        if (pageSize==null) {
            pageSize=5;
        }
        PageInfo<Permission> permissionList = permissionService.findAll(start,pageSize);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("/pages/permission-list.jsp");
        return modelAndView;
    }

    @RequestMapping("/permission/save")
    public ModelAndView save(Permission permission,ModelAndView modelAndView){
        permissionService.save(permission);
        PageInfo<Permission> permissionList = permissionService.findAll(1,5);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("/pages/permission-list.jsp");
        return modelAndView;
    }
}

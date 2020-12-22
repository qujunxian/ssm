package com.itheima.ssm.controller.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.system.RoleService;
import com.itheima.ssm.service.system.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes(value = {"userInfo"})
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/user/findAll")
    public ModelAndView findAll(Integer start, Integer pageSize, ModelAndView modelAndView) {
        if (start == null) {
            start = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        PageInfo<UserInfo> userList = userInfoService.findAll(start, pageSize);
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("/pages/user-list.jsp");
        return modelAndView;
    }

    @RequestMapping("/user/findById")
    public ModelAndView findById(String id, ModelAndView modelAndView) {
        UserInfo userInfo = userInfoService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("/pages/user-show.jsp");
        return modelAndView;
    }

    //400异常已解决
    @RequestMapping("/user/save")
    public ModelAndView save(UserInfo userInfo) {
        userInfoService.save(userInfo);
        PageInfo<UserInfo> userList = userInfoService.findAll(1, 5);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("/pages/user-list.jsp");
        return modelAndView;
    }

    @RequestMapping("/user/addRoleToUser")
    public ModelAndView addRoleToUser(String ids, String userId, ModelAndView modelAndView) {
        userInfoService.addRoleToUser(ids, userId);
        modelAndView.setViewName("/user/findAll.do");
        return modelAndView;
    }

    @RequestMapping("/user/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id, ModelAndView modelAndView) {
        UserInfo userInfo = userInfoService.findById(id);
        modelAndView.addObject("user", userInfo);
        List<Role> all = roleService.findAll();
        modelAndView.addObject("roleList", all);
        modelAndView.setViewName("/pages/user-role-add.jsp");
        return modelAndView;
    }


    @RequestMapping("/login")
    public ModelAndView login(String username, String password, ModelAndView modelAndView) {
        UserInfo userInfo = userInfoService.login(username, password);
        if (userInfo == null) {
            modelAndView.setViewName("/failer.jsp");
        } else {
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("/pages/main.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session, SessionStatus sessionStatus) {
        session.removeAttribute("userInfo");
        sessionStatus.setComplete();
        modelAndView.setViewName("/login.jsp");
        return modelAndView;
    }
}

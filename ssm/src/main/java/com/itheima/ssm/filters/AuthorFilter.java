package com.itheima.ssm.filters;

import com.itheima.ssm.domain.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*.do")
public class AuthorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("过滤器执行====");
        //得到HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //得到session
        HttpSession session = request.getSession();

        UserInfo user = (UserInfo)session.getAttribute("userInfo");

        //获取url
        String url = request.getRequestURI();

        if (user == null && url.indexOf("login.do") == -1){
            //System.out.println("登录信息不存在，并且访问登录接口以外其他接口，应该进行拦截");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            //System.out.println("登录信息存在，不进行拦截");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //System.out.println("过滤器销毁");
    }
}

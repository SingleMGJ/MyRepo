package cn.xiaoguijun.controller;

import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.domain.SysUser;
import cn.xiaoguijun.service.IUserService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/13
 * @time 15:13
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("findAllUser")
    public String findAllUser(Model model){
        List<SysUser> userList = service.findAllUser();
        model.addAttribute("userList",userList);
        return "user_list";
    }

    @RequestMapping("addUser")
    public String addUser(SysUser user){
        service.addUser(user);
        return "redirect:findAllUser";
    }

    @RequestMapping("findByID")
    public String findByID(Model model,String id){
        SysUser user = service.findByID(id);
        System.out.println(user.getRoleList());
        model.addAttribute("sysUser",user);
        return "user-show";
    }

    @RequestMapping("showName")
    public void showName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String remoteUser = request.getRemoteUser();
        System.out.println(remoteUser);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(remoteUser);
    }

    @RequestMapping("findRoleAvailable")
    public String findRoleAvailable(Model model,String id){
        List<SysRole> roles = service.findRoleAvailable(id);
        model.addAttribute("roles",roles);
        model.addAttribute("userid",id);
        return "user-role-add";
    }

    @RequestMapping("addRole")
    public String addRole(Model model,String userId,String[] ids){
        service.addRole(userId,ids);
        return "redirect:findByID?id="+userId;
    }
}

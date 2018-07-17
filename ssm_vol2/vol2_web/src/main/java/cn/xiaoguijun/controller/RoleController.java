package cn.xiaoguijun.controller;

import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/13
 * @time 17:41
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService service;

    @RequestMapping("findAllRole")
    public String findAllRole(Model model){
        List<SysRole> roleList = service.findAllRole();
        model.addAttribute("roleList",roleList);
        return "role_manage";
    }

    @RequestMapping("addRole")
    public String addRole(SysRole role){
        service.addRole(role);
        return "redirect:findAllRole";
    }
}

package cn.xiaoguijun.service;

import cn.xiaoguijun.domain.SysRole;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/13
 * @time 17:39
 */
public interface IRoleService {

    List<SysRole> findAllRole();

    void addRole(SysRole role);
}

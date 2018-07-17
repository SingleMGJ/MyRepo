package cn.xiaoguijun.service;

import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 21:24
 */
public interface IUserService extends UserDetailsService {

    List<SysUser> findAllUser();

    void addUser(SysUser user);

    SysUser findByID(String id);

    List<SysRole> findRoleAvailable(String id);

    void addRole(String userId,String[] ids);
}

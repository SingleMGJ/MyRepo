package cn.xiaoguijun.service.impl;

import cn.xiaoguijun.dao.IUserDao;
import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.domain.SysUser;
import cn.xiaoguijun.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 21:25
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = dao.findByName(username);
        if (user == null) {
            return null;
        }
        List<SysRole> roleList = user.getRoleList();
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (SysRole role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            System.out.println(role.getRoleName()+"   "+role.getRoleDesc());
        }
        return new User(username,user.getPassword(),authorities);
    }

    @Override
    public List<SysUser> findAllUser() {
        return dao.findAllUser();
    }

    @Override
    public void addUser(SysUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.addUser(user);
    }

    @Override
    public SysUser findByID(String id) {
        return dao.findByID(id);
    }

    @Override
    public List<SysRole> findRoleAvailable(String id) {
        return dao.findRoleAvailable(id);
    }

    @Override
    public void addRole( String userId,String[] ids) {
        for (String id : ids) {
            dao.addRole(userId,id);
        }
    }
}

package cn.xiaoguijun.dao;

import cn.xiaoguijun.domain.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/13
 * @time 17:37
 */
public interface IRoleDao {

    @Select("select * from role")
    List<SysRole> findAllRole();

    @Insert("insert into role (rolename,roledesc) values (#{roleName},#{roleDesc})")
    void addRole(SysRole role);

    @Select("select * from role sr, users_role sur " +
            "where sr.id=sur.roleid and sur.userid=#{id}")
    List<SysRole> findByUID(String id);
}

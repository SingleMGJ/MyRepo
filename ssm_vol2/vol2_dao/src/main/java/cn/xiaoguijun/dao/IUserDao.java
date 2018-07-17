package cn.xiaoguijun.dao;

import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 21:39
 */
public interface IUserDao {

    /**
    * @Author: GuiJun Xiao
    * @Description: 用户数据库查询接口
    * @Date: 16:25 2018/7/15
    * @param:  * @param null
    * @return:
    */
    @Select("select * from SYS_USER where username = #{username}")
    @Results({
            @Result(property = "roleList",column = "id",javaType = List.class,
            many = @Many(select = "cn.xiaoguijun.dao.IRoleDao.findByUID"))
    })
    SysUser findByName(String username);

    @Select("select * from SYS_USER")
    List<SysUser> findAllUser();

    @Insert("insert into SYS_USER (username,email,password,phoneNum,status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void addUser(SysUser user);

    @Select("select * from SYS_USER where id = #{id}")
    @Results({
            @Result(property = "roleList",column = "id",javaType = List.class,
            many = @Many(select = "cn.xiaoguijun.dao.IRoleDao.findByUID"))
    })
    SysUser findByID(String id);

    @Select("select * from role where id not in (select sr.id from role sr,users_role sur where sr.id=sur.roleid and sur.userid=#{id})")
    List<SysRole> findRoleAvailable(String id);

    @Insert("insert into users_role (userid,roleid) values(#{id,jdbcType=VARCHAR},#{roleid,jdbcType=VARCHAR}) ")
    void addRole(@Param("id")String id,@Param("roleid")String roleid);
//    void addRole(@Param("userid")String userid,@Param("roleid")String roleid);
}

package cn.xiaoguijun.domain;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 21:25
 */
public class SysUser {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private List<SysRole> roleList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getStatusStr() {
        return status==1 ? "开启" : "关闭" ;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}

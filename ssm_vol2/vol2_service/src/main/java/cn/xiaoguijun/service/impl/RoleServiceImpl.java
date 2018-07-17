package cn.xiaoguijun.service.impl;

import cn.xiaoguijun.dao.IRoleDao;
import cn.xiaoguijun.domain.SysRole;
import cn.xiaoguijun.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/13
 * @time 17:39
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao dao;

    @Override
    public List<SysRole> findAllRole() {
        return dao.findAllRole();
    }

    @Override
    public void addRole(SysRole role) {
        dao.addRole(role);
    }
}

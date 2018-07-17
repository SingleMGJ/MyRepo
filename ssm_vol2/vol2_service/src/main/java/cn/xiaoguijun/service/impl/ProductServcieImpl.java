package cn.xiaoguijun.service.impl;

import cn.xiaoguijun.dao.IProductDao;
import cn.xiaoguijun.domain.Product;
import cn.xiaoguijun.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 19:03
 */
@Service
@Transactional
public class ProductServcieImpl implements IProductService {

    @Autowired
    private IProductDao dao;


    @Override
    public void deleteBatch(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            dao.delete(id);
        }
    }

    @Override
    public void updateProduct(Product product) {
        dao.updateProduct(product);
    }

    @Override
    public Product findByID(String id) {
        return dao.findByID(id);
    }

    @Override
    public List<Product> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void addProduct(Product product) {
        dao.addProduct(product);
    }
}

package cn.xiaoguijun.service;

import cn.xiaoguijun.domain.Product;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/7
 * @time 20:21
 */
public interface IProductService {

    void deleteBatch(String ids);

    void updateProduct(Product product);

    Product findByID(String id);

    List<Product> findAll() throws Exception;

    void addProduct(Product product);
}

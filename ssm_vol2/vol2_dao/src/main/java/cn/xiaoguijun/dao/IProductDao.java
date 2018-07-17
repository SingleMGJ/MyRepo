package cn.xiaoguijun.dao;

import cn.xiaoguijun.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 *
 * @author GuiJun Xiao
 * @date 2018/7/7
 * @time 19:46
 */
public interface IProductDao {

    @Delete("delete from product where id = #{id}")
    void delete(String id);

    @Update("update product set productNum=#{productNum}," +
            "productName=#{productName}," +
            "cityName=#{cityName}," +
            "departureTime=#{departureTime}," +
            "productPrice=#{productPrice}," +
            "productDesc=#{productDesc}," +
            "productStatus=#{productStatus} " +
            "where id=#{id}")
    void updateProduct(Product product);

    @Select("select * from product where id = #{id}")
    Product findByID(String id);

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);
}

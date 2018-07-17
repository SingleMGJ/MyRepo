package cn.xiaoguijun;

import cn.xiaoguijun.dao.IProductDao;
import cn.xiaoguijun.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 18:58
 */
public class DaoTest {

    @Test
    public void findAllTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_dao.xml");
        IProductDao bean = context.getBean(IProductDao.class);
        List<Product> productList = bean.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

package cn.xiaoguijun.controller;

import cn.xiaoguijun.domain.Product;
import cn.xiaoguijun.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The Mighty GUIJUN XIAO
 * A MasterPiece
 *
 * @author GuiJun Xiao
 * @date 2018/7/12
 * @time 21:12
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService service;

    @RequestMapping("productDisplay")
    public String productDisplay(Model model, String id){
        Product product = service.findByID(id);
        model.addAttribute("product",product);
        return "product-show";
    }

    @RequestMapping("deleteBatch")
    public String deleteBatch(String ids){
        service.deleteBatch(ids);
        return "redirect:findAllProduct";
    }

    @RequestMapping("updateProduct")
    public String updateProduct(Model model,Product product){
        service.updateProduct(product);
        return "redirect:findAllProduct";
    }

    @RequestMapping("findByID")
    public String findByID(Model model,String id){
        Product product = service.findByID(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new PropertiesEditor(){
            @Override
            public void setAsText(@Nullable String text){
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(text);
                    setValue(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @RequestMapping("addProduct")
    public String addProduct(Product product){
        service.addProduct(product);
        return "redirect:findAllProduct";
    }

    @RequestMapping("findAllProduct")
    public ModelAndView findAllProduct() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = service.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
}

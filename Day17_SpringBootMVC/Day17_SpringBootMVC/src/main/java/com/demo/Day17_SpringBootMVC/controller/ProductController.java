package com.demo.Day17_SpringBootMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Day17_SpringBootMVC.beans.Product;
import com.demo.Day17_SpringBootMVC.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService pservice;

    @GetMapping("/getproducts")
    public ModelAndView getAllProducts() {
        List<Product> plist = pservice.getAllProd();
        return new ModelAndView("showproduct", "plist", plist);
    }

    @GetMapping("/addproduct")
    public String showAddProductForm(Model m) {
        m.addAttribute("product", new Product());
        return "insertProduct";
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@ModelAttribute Product product) {
        pservice.addnewProduct(product);
        return "redirect:/product/getproducts";  
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product prod) {
        pservice.updateProduct(prod);
        return "redirect:/product/getproducts"; 
    }

    @GetMapping("/editproduct/{pid}")
    public ModelAndView editProduct(@PathVariable int pid) {
        Product p = pservice.getById(pid);
        if (p != null) {
            return new ModelAndView("editproduct", "prod", p);
        } else {
            return new ModelAndView("redirect:/product/getproducts");  
        }
    }

    @GetMapping("/deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		pservice.deleteProduct(pid);
		return new ModelAndView("redirect:/product/getproducts");
	}
}

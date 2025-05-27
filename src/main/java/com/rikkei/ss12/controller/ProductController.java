package com.rikkei.ss12.controller;

import com.rikkei.ss12.dto.ProductDTO;
import com.rikkei.ss12.model.Product;
import com.rikkei.ss12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "listb2";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "addProduct";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setImage(productDTO.getImage());
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setImage(product.getImage());

        model.addAttribute("productDTO", productDTO);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setImage(productDTO.getImage());
        productService.update(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}

package com.example.demoproduct.controller;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.service.ICategoryService;
import com.example.demoproduct.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ViewController {
    private final IProductService iProductService;
    private final ICategoryService iCategoryService;

    public ViewController(IProductService iProductService, ICategoryService iCategoryService) {
        this.iProductService = iProductService;
        this.iCategoryService = iCategoryService;
    }

    @GetMapping
    public ModelAndView getProducts(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "3") int size,
                                    @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("totalPage", iProductService.getTotalPages(size));
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("products", iProductService.findAll(page, size));
        modelAndView.addObject("categories", iCategoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("product") Product product,
                             RedirectAttributes redirect) {

        iProductService.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("updateProduct");
        Product product = iProductService.findById(id);
        modelAndView.addObject("product", product);
        List<Category> categories = iCategoryService.findAll();
        categories = categories.stream().filter(category -> category.getId() != product.getCategory().getId()).collect(Collectors.toList());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("product") Product product,
                                RedirectAttributes redirect) {
        iProductService.update(product);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id,
                                RedirectAttributes redirect) {
        iProductService.removeById(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/";
    }
}

package vn.iotstar.baitapwebcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.iotstar.baitapwebcurd.service.impl.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/home";
    }
}

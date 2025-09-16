package vn.iotstar.baitapwebcurd.controller;
import vn.iotstar.baitapwebcurd.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vn.iotstar.baitapwebcurd.service.impl.CategoryService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/home")
    public String home(HttpSession session,ModelMap model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRoleid() != 1) {
            return "redirect:/auth/login";
        }
        model.addAttribute("categories", categoryService.findByUser(user));
        return "web/user-home";
    }
}

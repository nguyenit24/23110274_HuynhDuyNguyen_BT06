package vn.iotstar.baitapwebcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.baitapwebcurd.entity.User;
import vn.iotstar.baitapwebcurd.service.IUserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String passWord, ModelMap model) {
        User user = userService.findByUserNameAndPassWord(userName, passWord);
        if (user != null) {
            // Simple role-based redirect
            if (user.getRoleid() == 3) return "redirect:/admin/home";
            if (user.getRoleid() == 2) return "redirect:/manager/home";
            return "redirect:/user/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, ModelMap model) {
        if (userService.findByUserName(user.getUserName()) != null) {
            model.addAttribute("error", "Username already exists");
            return "auth/register";
        }
        user.setRoleid(1);
        userService.save(user);
        model.addAttribute("message", "Registration successful. Please login.");
        return "auth/login";
    }
}

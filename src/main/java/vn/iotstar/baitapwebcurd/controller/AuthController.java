package vn.iotstar.baitapwebcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
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
    public String login(@RequestParam String userName, @RequestParam String passWord, ModelMap model,
                        HttpSession session) {
        User user = userService.findByUserNameAndPassWord(userName, passWord);
        if (user != null) {
            System.out.println(user+ "===================");
            session.setAttribute("user", user);
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

    @GetMapping("/forgetpass")
    public String forgetPassForm() {
        return "auth/forgetpass";
    }

    @PostMapping("/forgetpass")
    public String forgetPass(@RequestParam String email, @RequestParam String newpass, ModelMap model) {
        User user = userService.findByEmail(email);
        if (user != null) {
            user.setPassWord(newpass);
            userService.save(user);
            model.addAttribute("message", "Password reset successful. Please login.");
        } else {
            model.addAttribute("error", "Email not found");
        }
        return "auth/login";
    }
}

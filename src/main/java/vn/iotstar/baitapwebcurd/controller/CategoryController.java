package vn.iotstar.baitapwebcurd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.User;
import vn.iotstar.baitapwebcurd.entity.Video;
import vn.iotstar.baitapwebcurd.service.impl.CategoryService;
import vn.iotstar.baitapwebcurd.service.impl.VideoService;

import java.util.List;
@Controller
@RequestMapping({"/admin/categories"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    VideoService videoService;

    @GetMapping("/add")
    public String add() {
        return "/admin/categories/add";
    }
    @RequestMapping("")
    public String list(ModelMap model, @RequestParam(value = "keyword", required = false) String keyword) {
//        User user = (User) model.get("user");
//        if (user == null) {
//            return "redirect:/auth/login";
////        }
//        List<Category> list = categoryService.findByUser(user);
        List<Category> list = categoryService.findAll();
        if (keyword != null) {
            list = categoryService.findByCategoryNameContaining(keyword);
        }
        model.addAttribute("categories", list);
        model.addAttribute("keyword", keyword);
        return "admin/categories/list";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrEdit(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping("/edit/{categoryId}")
    public ModelAndView edit(ModelMap model, @PathVariable("categoryId") int categoryId) {
        Category category = categoryService.findById(categoryId).get();
        model.addAttribute("category", category);
        return new ModelAndView("/admin/categories/edit", model);
    }

    @GetMapping("delete/{categoryId}")
    public ModelAndView delete(ModelMap model, @PathVariable("categoryId") int categoryId) {
        categoryService.deleteById(categoryId);
        model.addAttribute("message", "Category is deleted!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @GetMapping("/videos/{categoryId}")
    public String viewVideosByCategory(@PathVariable("categoryId") int categoryId,
            @RequestParam(value = "keyword", required = false) String keyword
            , ModelMap model) {
        Category category = categoryService.findById(categoryId).orElse(null);
        if (category != null) {
            if (keyword != null && !keyword.isEmpty()) {
                model.addAttribute("videos", videoService.findByTitleContainingAndCategory(keyword, category));
            } else {
                model.addAttribute("videos", category.getVideos());
            }
            model.addAttribute("category", category);
            model.addAttribute("keyword", keyword);
            return "/admin/videos/video-list";
        } else {
            model.addAttribute("errorMessage", "Category not found");
            return "redirect:/admin/categories";
        }
    }

    @GetMapping("view/{categoryId}")
    public String viewCategory(@PathVariable("categoryId") int categoryId, ModelMap model) {
        List<Video> videos = videoService.findByCategoryId(categoryId);
        model.addAttribute("videos", videos);
        return "/admin/videos/video-list";
    }

    @PostMapping("/search")
    public String searchCategories(@RequestParam("keyword") String keyword) {
        return "redirect:/admin/categories?keyword=" + keyword;
    }

}

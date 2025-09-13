package vn.iotstar.baitapwebcurd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.service.impl.CategoryService;
import java.util.List;
@Controller
@RequestMapping("admin/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/add")
    public String add() {
        return "/admin/categories/add";
    }
    @RequestMapping("")
    public String list(ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
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
}

package vn.iotstar.baitapwebcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.Video;
import vn.iotstar.baitapwebcurd.repository.CategoryRepository;
import vn.iotstar.baitapwebcurd.service.IVideoService;
import vn.iotstar.baitapwebcurd.service.impl.FileUploadService;

@Controller
@RequestMapping({"/admin/videos", "/manager/videos", "/user/videos"})
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public String list(Model model,@RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("videos", videoService.findAll());
        model.addAttribute("keyword", keyword);
        if (keyword != null) {
            model.addAttribute("videos", videoService.findByTitleContaining(keyword));
        }
        return "/admin/videos/video-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryRepository.findAll());
        return "/admin/videos/video-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Video video,
                       @RequestParam("file") MultipartFile file,
                       @RequestParam("categoryId") int categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            video.setCategory(category);

            if (!file.isEmpty()) {
                String fileName = fileUploadService.uploadMp4File(file);
                video.setVideopath(fileName);
            } else {
                if (video.getId() != 0) {
                    Video oldVideo = videoService.findById(video.getId()).orElse(null);
                    if (oldVideo != null) {
                        video.setVideopath(oldVideo.getVideopath());
                    }
                }
            }

            videoService.save(video);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/videos";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("video", videoService.findById(id).orElse(new Video()));
        model.addAttribute("categories", categoryRepository.findAll());
        return "/admin/videos/video-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos";
    }
}

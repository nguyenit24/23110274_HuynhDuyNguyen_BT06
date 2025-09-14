package vn.iotstar.baitapwebcurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.iotstar.baitapwebcurd.entity.Video;
import vn.iotstar.baitapwebcurd.service.IVideoService;
import vn.iotstar.baitapwebcurd.service.impl.FileUploadService;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("videos", videoService.findAll());
        return "/admin/videos/video-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("video", new Video());
        return "/admin/videos/video-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Video video,
                       @RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileUploadService.uploadMp4File(file);
            videoService.save(video);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/videos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("video", videoService.findById(id).orElse(new Video()));
        return "/admin/videos/video-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos";
    }
}

package vn.iotstar.baitapwebcurd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iotstar.baitapwebcurd.entity.Video;
import vn.iotstar.baitapwebcurd.repository.VideoRepository;
import vn.iotstar.baitapwebcurd.service.IVideoService;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    VideoRepository videoRepository;

    @Override
    public Page<Video> findAll(Pageable pageable) {
        return videoRepository.findAll(pageable);
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public <S extends Video> S save(S entity) {
        return videoRepository.save(entity);
    }

    @Override
    public Optional<Video> findById(Integer integer) {
        return videoRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        videoRepository.deleteById(integer);
    }
}

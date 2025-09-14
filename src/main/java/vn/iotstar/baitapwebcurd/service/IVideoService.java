package vn.iotstar.baitapwebcurd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.Video;

import java.util.List;
import java.util.Optional;

public interface IVideoService {

    Page<Video> findAll(Pageable pageable);

    List<Video> findAll();

    <S extends Video> S save(S entity);

    Optional<Video> findById(Integer integer);

    void deleteById(Integer integer);
}

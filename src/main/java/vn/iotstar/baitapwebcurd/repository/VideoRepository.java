package vn.iotstar.baitapwebcurd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.Video;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}

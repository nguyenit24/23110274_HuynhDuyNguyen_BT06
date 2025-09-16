package vn.iotstar.baitapwebcurd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitapwebcurd.entity.Video;


@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}

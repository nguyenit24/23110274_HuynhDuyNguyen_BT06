package vn.iotstar.baitapwebcurd.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.Video;


@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByCategoryId(int categoryId);
    List<Video> findByTitleContaining(String title);
    List<Video> findByTitleContainingAndCategoryId(String title, int categoryId);
    List<Video> findByTitleContainingAndCategory(String title, Category category);
}

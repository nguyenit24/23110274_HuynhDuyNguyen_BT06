package vn.iotstar.baitapwebcurd.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iotstar.baitapwebcurd.entity.Category;
import java.util.List;
import java.util.Optional;
public interface ICategoryService {
    List<Category> findByCategoryNameContaining(String categoryName);
    Page<Category> findByCategoryNameContaining(String categoryName, Pageable pageable);
    <S extends Category> S save(S entity);
    Optional<Category> findById(Integer integer);
    void deleteById(Integer integer);
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
}

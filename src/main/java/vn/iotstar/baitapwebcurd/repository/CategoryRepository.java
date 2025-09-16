package vn.iotstar.baitapwebcurd.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.entity.User;
import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findByCategoryNameContaining(String categoryName, Pageable pageable);
    List<Category> findByCategoryNameContaining(String categoryName);
    List<Category> findByUser(User user);
}

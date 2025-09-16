package vn.iotstar.baitapwebcurd.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iotstar.baitapwebcurd.entity.Category;
import vn.iotstar.baitapwebcurd.repository.CategoryRepository;
import vn.iotstar.baitapwebcurd.service.ICategoryService;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    public List<Category> findByUser(vn.iotstar.baitapwebcurd.entity.User user) {
        return categoryRepository.findByUser(user);
    }
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findByCategoryNameContaining(String categoryName) {
        return categoryRepository.findByCategoryNameContaining(categoryName);
    }
    @Override
    public Page<Category> findByCategoryNameContaining(String categoryName, Pageable pageable) {
        return categoryRepository.findByCategoryNameContaining(categoryName, pageable);
    }
    @Override
    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }
    @Override
    public Optional<Category> findById(Integer integer) {
        return categoryRepository.findById(integer);
    }
    @Override
    public void deleteById(Integer integer) {
        categoryRepository.deleteById(integer);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}

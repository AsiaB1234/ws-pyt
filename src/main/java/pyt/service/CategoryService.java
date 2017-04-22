package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.repository.CategoryRepository;

@Service
public class CategoryService extends
        AbstractService<Category, CategoryRepository> {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

}

package pyt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.service.CategoryService;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractController<Category, CategoryService> {

    Logger log = Logger.getLogger(this.getClass());

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

}

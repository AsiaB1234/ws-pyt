package pyt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractController<Category, CategoryService> {

    @Autowired
    private CategoryService categoryService;

}

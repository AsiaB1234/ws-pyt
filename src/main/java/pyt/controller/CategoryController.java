package pyt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController extends AbstractController<Category, CategoryService> {

}

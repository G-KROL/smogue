package com.wawcode.smogue.application.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wawcode.smogue.domain.api.item.CategoryListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryListService categoryListService;

    @Autowired
    public CategoryController(CategoryListService categoryListService) {
        this.categoryListService = categoryListService;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getCategories() {
        return categoryListService.getCategories();
    }
}

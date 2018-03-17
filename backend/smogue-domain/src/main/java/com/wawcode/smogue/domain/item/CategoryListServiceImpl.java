package com.wawcode.smogue.domain.item;

import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.CategoryListService;
import com.wawcode.smogue.domain.persistence.item.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryListServiceImpl implements CategoryListService {

    @Override
    public List<String> getCategories() {
        List<Category> values = Arrays.asList(Category.values());
        return values
                .stream()
                .map(Category::getValue)
                .collect(Collectors.toList());
    }
}

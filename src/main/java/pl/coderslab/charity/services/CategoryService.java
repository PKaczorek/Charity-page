package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


}

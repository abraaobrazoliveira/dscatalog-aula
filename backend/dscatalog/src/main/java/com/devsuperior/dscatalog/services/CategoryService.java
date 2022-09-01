package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();
        return new CategoryDTO().getDtoList(list);
    }

    @Transactional
    public CategoryDTO save(Category category) {
        return new CategoryDTO(repository.save(category));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) throws EntityNotFoundException {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Não possui a categoria requisitada"));
        return new CategoryDTO(entity);
    }
}

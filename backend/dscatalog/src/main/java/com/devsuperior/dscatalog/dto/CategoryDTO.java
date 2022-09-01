package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDTO implements Serializable {

    private static final long serialVerionUID = 1L;
    private Long id;
    private String name;

    private List<CategoryDTO> dtoList;

    public CategoryDTO() {
    }

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDtoList(List<Category> categoryList) {
       this.dtoList = categoryList.stream().map(c -> new CategoryDTO(c)).collect(Collectors.toList());
    }
    public List<CategoryDTO> getDtoList(List<Category> categoryList) {
        this.setDtoList(categoryList);
        return dtoList;
    }
}

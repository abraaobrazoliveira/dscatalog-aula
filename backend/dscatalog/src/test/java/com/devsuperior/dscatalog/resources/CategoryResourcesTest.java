package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryResourcesTest {

    CategoryResources categoryResources;

    @Autowired
    ApplicationContext context;

    @Before
    public void before() {
        categoryResources = Mockito.mock(CategoryResources.class);
    }

    @Test
    public void shouldReturnAllCategoriesAndSuccessStatus() {

        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(new CategoryDTO(new Category(1L, "Books")));
        categories.add(new CategoryDTO(new Category(2L, "Electronics")));
        Mockito.when(categoryResources.findAll()).thenReturn(ResponseEntity.ok(categories));

        ResponseEntity response = categoryResources.findAll();

        Assertions.assertTrue(response.getStatusCode() == HttpStatus.OK);
        Assertions.assertTrue(response.getBody() != null);

        List<Category> getResult = (ArrayList<Category>) response.getBody();

        Assertions.assertEquals("Books", getResult.get(0).getName());


    }


}

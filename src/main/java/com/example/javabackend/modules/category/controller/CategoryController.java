package com.example.javabackend.modules.category.controller;

import com.example.javabackend.entity.Category;
import com.example.javabackend.modules.category.DTO.CategoryDTO;
import com.example.javabackend.modules.category.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Get method
    //Get List Category
    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    //Get method
    //Get By ID Category
    @GetMapping("/find/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    //Post method
    //Create Category
    @PostMapping("/add")
    public Category addCategory(@RequestParam MultipartFile image, String categoryName) throws IOException {
        return this.categoryService.addCategory(image,categoryName);
    }

    //Put method
    //Edit ID Category
    @PutMapping("/edit/{id}")
    public Category updateCategory(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file, @ModelAttribute CategoryDTO categoryDTO) throws IOException {
        return this.categoryService.updateCategory(id,file,categoryDTO);
    }

    // Delete Method
    // Delete Category
    @DeleteMapping("/{categoryId}")
    public Map<String, Object> deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    // Delete Category Web
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategoryWeb(@PathVariable("id") Long id) throws IOException{
        categoryService.deleteCategory(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/qldanhmuc");
        mav.addObject("result", "success");
        return mav;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

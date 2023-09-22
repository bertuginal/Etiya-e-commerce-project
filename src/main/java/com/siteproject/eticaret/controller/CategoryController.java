package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.category.CreateCategoryDto;
import com.siteproject.eticaret.dtos.request.category.DeleteCategoryDto;
import com.siteproject.eticaret.dtos.request.category.UpdateCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetAllCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetCategoryByIdDto;
import com.siteproject.eticaret.dtos.response.product.GetProductByIdDto;
import com.siteproject.eticaret.services.category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addcategory")
    public Result addCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto) {
        return this.categoryService.addCategory(createCategoryDto);
    }

    @PutMapping("/deletecategory")
    public Result deleteCategory(@Valid @RequestBody DeleteCategoryDto deleteCategoryDto) {
        return this.categoryService.deleteCategory(deleteCategoryDto);
    }

    @PutMapping("/updatecategory")
    public Result updateCategory(@Valid @RequestBody UpdateCategoryDto updateCategoryDto) {
        return this.categoryService.updateCategory(updateCategoryDto);
    }

    @GetMapping("/getcategorybyid")
    public Result<GetCategoryByIdDto> getCategoryByIdDto(@RequestBody GetCategoryByIdDto getCategoryByIdDto) {
        return this.categoryService.getCategoryById(getCategoryByIdDto);

    }

    @GetMapping("/getallcategories")
    public Result<List<GetAllCategoryDto>> getAllCategories(){ return this.categoryService.getAllCategory(); }
}

package com.siteproject.eticaret.services.category;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.category.CreateCategoryDto;
import com.siteproject.eticaret.dtos.request.category.DeleteCategoryDto;
import com.siteproject.eticaret.dtos.request.category.UpdateCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetAllCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetCategoryByIdDto;
import com.siteproject.eticaret.dtos.response.product.GetAllProductsDto;
import com.siteproject.eticaret.dtos.response.product.GetProductByIdDto;
import com.siteproject.eticaret.entities.Category;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result addCategory(CreateCategoryDto createCategoryDto) {
        checkCategoryName(createCategoryDto.getCategoryName());
        Category categoryToAdd = Category.builder()
                .categoryName(createCategoryDto.getCategoryName())
                .isActive(true)
                .createdDate(new Date())
                .build();
        categoryRepository.save(categoryToAdd);
        return new Result(true, "Category has been successfully added!");
    }

    @Override
    public Result deleteCategory(DeleteCategoryDto deleteCategoryDto) {
        Category category = categoryRepository.findById(deleteCategoryDto.getCategoryId()).orElseThrow();
            category.setIsActive(false);
            category.setUpdatedDate(new Date());
            categoryRepository.save(category);
        return new Result(true, "Category has been successfully deleted!");
    }

    @Override
    public Result updateCategory(UpdateCategoryDto updateCategoryDto) {
        Category category = categoryRepository.findById(updateCategoryDto.getCategoryId()).orElseThrow();
        category.setIsActive(false);
        categoryRepository.save(category);

        Category categoryToUpdate = Category.builder()
                .categoryName(updateCategoryDto.getCategoryName() == null ? category.getCategoryName() : updateCategoryDto.getCategoryName())
                .isActive(true)
                .updatedDate(new Date())
                .createdDate(category.getCreatedDate())
                .build();
        categoryRepository.save(categoryToUpdate);
        return new Result(true, "Category has been successfully updated!");

    }

    @Override
    public Result<GetCategoryByIdDto> getCategoryById(GetCategoryByIdDto getCategoryByIdDto) {
        Category categoryId = categoryRepository.findById(getCategoryByIdDto.getCategoryId()).orElseThrow();
        GetCategoryByIdDto response = modelMapperService.forResponse().map(categoryId, GetCategoryByIdDto.class);
        return new Result<GetCategoryByIdDto>(true, response);
    }

    @Override
    public Result<List<GetAllCategoryDto>> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        List<GetAllCategoryDto> response = categoryList.stream().map(category -> modelMapperService.forResponse().map(category, GetAllCategoryDto.class)).collect(Collectors.toList());
        return new Result<List<GetAllCategoryDto>>(true, "All categories were showed!", response);
    }

    private void checkCategoryName(String categoryName) {
        boolean ifExists = this.categoryRepository.existsByCategoryName(categoryName);
        if(ifExists){
            throw new BusinessException("Category name already created!");
        }



        }
    }

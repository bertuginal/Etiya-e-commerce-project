package com.siteproject.eticaret.services.category;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.category.CreateCategoryDto;
import com.siteproject.eticaret.dtos.request.category.DeleteCategoryDto;
import com.siteproject.eticaret.dtos.request.category.UpdateCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetAllCategoryDto;
import com.siteproject.eticaret.dtos.response.category.GetCategoryByIdDto;

import java.util.List;

public interface CategoryService {
    Result addCategory(CreateCategoryDto createCategoryDto);
    Result deleteCategory(DeleteCategoryDto deleteCategoryDto);
    Result updateCategory(UpdateCategoryDto updateCategoryDto);
    Result<GetCategoryByIdDto> getCategoryById(GetCategoryByIdDto getCategoryByIdDto);
    Result<List<GetAllCategoryDto>> getAllCategory();
}

package com.siteproject.eticaret.services.product;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.product.CreateProductDto;
import com.siteproject.eticaret.dtos.request.product.DeleteProductDto;
import com.siteproject.eticaret.dtos.request.product.UpdateProductDto;
import com.siteproject.eticaret.dtos.response.product.GetAllProductsDto;
import com.siteproject.eticaret.dtos.response.product.GetProductByIdDto;
import com.siteproject.eticaret.entities.Product;

import java.util.List;

public interface ProductService {
    Result addProduct(CreateProductDto createProductDto);
    Result deleteProduct(DeleteProductDto deleteProductDto);
    Result updateProduct(UpdateProductDto updateProductDto);
    Result<GetProductByIdDto> getProductById(GetProductByIdDto getProductByIdDto);
    Result<List<GetAllProductsDto>> getAllProducts();
    Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled();
    Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled2();
}

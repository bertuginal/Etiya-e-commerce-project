package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.product.CreateProductDto;
import com.siteproject.eticaret.dtos.request.product.DeleteProductDto;
import com.siteproject.eticaret.dtos.request.product.UpdateProductDto;
import com.siteproject.eticaret.dtos.response.product.GetAllProductsDto;

import com.siteproject.eticaret.dtos.response.product.GetProductByIdDto;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.services.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //API olduğunu belirtmek için
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Result addProduct(@Valid @RequestBody CreateProductDto createProductDto) { //RequestBody JSON kullanmak içindir. Tüm ortamlarda (mobil, desktop gibi) çalışması için kullanılır.
        //PathVariable parametre değerlerini URL değerinde verir
        return this.productService.addProduct(createProductDto);
    }

    @PutMapping("/deleteproduct")
    public Result deleteProduct(@Valid @RequestBody DeleteProductDto deleteProductDto) {
        return this.productService.deleteProduct(deleteProductDto);
    }

    @PutMapping("/updateproduct")
    public Result updateProduct(@Valid @RequestBody UpdateProductDto updateProductDto){
        return this.productService.updateProduct(updateProductDto);
    }

    @GetMapping("/getproductbyid")
    public Result<GetProductByIdDto> getProductById(@RequestBody GetProductByIdDto getProductByIdDto) {
        return this.productService.getProductById(getProductByIdDto);
    }

    @GetMapping("/getallproducts")
    public Result<List<GetAllProductsDto>> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/getallproductswithcategorydisabled")
    public Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled() {
        return this.productService.getAllProductsWithCategoryDisabled();
    }

    @GetMapping("/getallproductswithcategorydisabled2")
    public Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled2() {
        return this.productService.getAllProductsWithCategoryDisabled2();
    }

}

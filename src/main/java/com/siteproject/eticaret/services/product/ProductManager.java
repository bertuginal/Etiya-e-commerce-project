package com.siteproject.eticaret.services.product;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.category.CreateCategoryDto;
import com.siteproject.eticaret.dtos.request.product.CreateProductDto;
import com.siteproject.eticaret.dtos.request.product.DeleteProductDto;
import com.siteproject.eticaret.dtos.request.product.UpdateProductDto;
import com.siteproject.eticaret.dtos.response.product.GetAllProductsDto;

import com.siteproject.eticaret.dtos.response.product.GetProductByIdDto;
import com.siteproject.eticaret.entities.CartProduct;
import com.siteproject.eticaret.entities.Category;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.entities.Supplier;
import com.siteproject.eticaret.repositories.CategoryRepository;
import com.siteproject.eticaret.repositories.ProductRepository;
import com.siteproject.eticaret.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result addProduct(CreateProductDto createProductDto) {
        Category category = categoryRepository.findById(createProductDto.getCategoryId()).orElseThrow();
        Supplier supplier = supplierRepository.findById(createProductDto.getSupplierId()).orElseThrow();
        Product productToAdd = Product.builder()
                .productName(createProductDto.getProductName())
                .unitPrice(createProductDto.getUnitPrice())
                .unitsInStock(createProductDto.getUnitsInStock())
                .unitDescription(createProductDto.getUnitDescription())
                .category(category)
                .supplier(supplier)
                .isActive(true)
                .createdDate(new Date())
                .build();
        productRepository.save(productToAdd);
        return new Result(true,"Product has been successfully added!");

    }

    @Override
    public Result deleteProduct(DeleteProductDto deleteProductDto) {
        Product product = productRepository.findById(deleteProductDto.getProductId()).orElseThrow();
        checkIfProductActive(product);
        product.setIsActive(false);
        product.setUpdatedDate(new Date());
        productRepository.save(product);
        return new Result(true, "Product has been successfully deleted!");
        }


    @Override
    public Result updateProduct(UpdateProductDto updateProductDto) {
        Product product = productRepository.findById(updateProductDto.getProductId()).orElseThrow();
        product.setIsActive(false);
        productRepository.save(product);

        Product productToUpdate = Product.builder()
                .productName(updateProductDto.getProductName() == null ? product.getProductName() : updateProductDto.getProductName())
                .unitPrice(updateProductDto.getUnitPrice() == null ? product.getUnitPrice() : updateProductDto.getUnitPrice())
                .unitsInStock(updateProductDto.getUnitsInStock() == null ? product.getUnitsInStock() : updateProductDto.getUnitsInStock())
                .unitDescription(updateProductDto.getUnitDescription() == null ? product.getUnitDescription() : updateProductDto.getUnitDescription())
                .category(updateProductDto.getCategoryId() == null ? product.getCategory() : categoryRepository.findById(updateProductDto.getCategoryId()).orElseThrow())
                .isActive(true)
                .updatedDate(new Date())
                .createdDate(product.getCreatedDate())
                .build();

        productRepository.save(productToUpdate);
        return  new Result(true, "Product has been successfully updated!");

    }

    @Override
    public Result<GetProductByIdDto> getProductById(GetProductByIdDto getProductByIdDto) {
        Product productId = productRepository.findById(getProductByIdDto.getProductId()).orElseThrow();
        GetProductByIdDto response = modelMapperService.forResponse().map(productId, GetProductByIdDto.class);
        return new Result<GetProductByIdDto>(true, response);
    }

    @Override
    public Result<List<GetAllProductsDto>> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<GetAllProductsDto> response = productList.stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsDto.class)).collect(Collectors.toList()); //Foreach ile aynı
        //stream() = foreach, map()= gönderilmek istenen yere map işlemi, collect işlemi = toplanılan verilerin listelenmesi
        /*List<GetAllProductsDto> response = new ArrayList<>();
        for (Product product : productList) {
            GetAllProductsDto getAllProductsDto = new GetAllProductsDto();
            getAllProductsDto.setProductName(product.getProductName());
            getAllProductsDto.setUnitPrice(product.getUnitPrice());
            getAllProductsDto.setUnitsInStock(product.getUnitsInStock());
            response.add(getAllProductsDto);

        }*/
        return new Result<List<GetAllProductsDto>>(true, "All products were showed!", response);
    }

    @Override
    public Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled() {
        List<GetAllProductsDto> response = this.productRepository.getAllProductsWithCategoryDisabled();
        return new Result<List<GetAllProductsDto>>(true, response);
    }

    @Override
    public Result<List<GetAllProductsDto>> getAllProductsWithCategoryDisabled2() {
        System.out.println("metota girdi");
        List<Product> productList = this.productRepository.getAllProductsWithCategoryDisabled2();
        System.out.println("product list" + productList);
        List<GetAllProductsDto> response = productList.stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsDto.class)).collect(Collectors.toList());
        return new Result<List<GetAllProductsDto>>(true, response);
    }

    private void checkIfProductActive(Product product) {
        if (product.getIsActive() == false){
            throw new BusinessException("Product already disabled!");
        }
    }

}

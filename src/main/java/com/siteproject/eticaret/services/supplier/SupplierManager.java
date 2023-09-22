package com.siteproject.eticaret.services.supplier;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.supplier.CreateSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.DeleteSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.UpdateSupplierDto;
import com.siteproject.eticaret.dtos.response.supplier.GetAllSuppliersDto;
import com.siteproject.eticaret.dtos.response.supplier.GetSupplierByIdDto;
import com.siteproject.eticaret.entities.Customer;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.entities.Supplier;
import com.siteproject.eticaret.repositories.ProductRepository;
import com.siteproject.eticaret.repositories.SupplierRepository;
import com.siteproject.eticaret.repositories.UserRepository;
import com.siteproject.eticaret.services.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {

    private ModelMapperService modelMapperService;
    private SupplierRepository supplierRepository;
    private ProductRepository productRepository;


    @Override
    public Result addSupplier(CreateSupplierDto createSupplierDto) {
        Supplier supplier = this.modelMapperService.forRequest().map(createSupplierDto, Supplier.class);
        checkByUserEmail(supplier.getUserEmail());
        supplier.setIsActive(true);
        supplier.setCreatedDate(new Date());
        supplierRepository.save(supplier);
        return new Result(true, "Supplier has been successfully added!");
    }

    @Override
    public Result deleteSupplier(DeleteSupplierDto deleteSupplierDto) {
        Supplier supplier = supplierRepository.findById(deleteSupplierDto.getSupplierId()).orElseThrow();
        checkIfSupplierActive(supplier);
        List<Product> productList = productRepository.findBySupplierId(deleteSupplierDto.getSupplierId());
        checkIfSuppliersProductActive(productList);
        supplier.setIsActive(false);
        supplier.setCreatedDate(supplier.getCreatedDate());
        supplier.setUpdatedDate(new Date());
        supplierRepository.save(supplier);
        return new Result(true, "Supplier has been successfully deleted!");
    }

    @Override
    public Result updateSupplier(UpdateSupplierDto updateSupplierDto) {
        Supplier supplier = this.supplierRepository.findById(updateSupplierDto.getSupplierId()).orElseThrow();
        supplier.setIsActive(false);
        supplierRepository.save(supplier);

        Supplier supplierToUpdate = this.modelMapperService.forRequest().map(updateSupplierDto, Supplier.class);
        supplierToUpdate.setIsActive(true);
        supplierToUpdate.setCreatedDate(supplier.getCreatedDate());
        supplierToUpdate.setUpdatedDate(new Date());
        supplierRepository.save(supplierToUpdate);
        return new Result(true, "Supplier has been successfully updated!");
    }

    @Override
    public Result<GetSupplierByIdDto> getSupplierById(GetSupplierByIdDto getSupplierByIdDto) {
        Supplier supplierId = supplierRepository.findById(getSupplierByIdDto.getSupplierId()).orElseThrow();
        GetSupplierByIdDto response = modelMapperService.forResponse().map(supplierId, GetSupplierByIdDto.class);
        return new Result<GetSupplierByIdDto>(true, response);
    }

    @Override
    public Result<List<GetAllSuppliersDto>> getAllSuppliers() {
        List<Supplier> supplierList = supplierRepository.findAll();
        List<GetAllSuppliersDto> response = supplierList.stream().map(supplier -> modelMapperService.forResponse().map(supplier, GetAllSuppliersDto.class)).collect(Collectors.toList());
        return new Result<List<GetAllSuppliersDto>>(true, response);
    }

    private void checkIfSupplierActive(Supplier supplier) {
        if (supplier.getIsActive() == false) {
            throw new BusinessException("Supplier already disabled!");
        }
    }
    private void checkIfSuppliersProductActive(List<Product> productList){
        for (Product product : productList) {
            if (product.getIsActive() == true) {
                throw new BusinessException("Satışta gözüken ürününüz bulunmaktadır!");
            }
        }
    }

    private void checkByUserEmail(String userEmail) {
        boolean ifExists = this.supplierRepository.existsByUserEmail(userEmail);
        if(ifExists){
            throw new BusinessException("Supplier email already created!");
        }
    }
}
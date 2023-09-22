package com.siteproject.eticaret.services.supplier;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.supplier.CreateSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.DeleteSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.UpdateSupplierDto;
import com.siteproject.eticaret.dtos.response.supplier.GetAllSuppliersDto;
import com.siteproject.eticaret.dtos.response.supplier.GetSupplierByIdDto;

import java.util.List;

public interface SupplierService {

    Result addSupplier(CreateSupplierDto createSupplierDto);
    Result deleteSupplier(DeleteSupplierDto deleteSupplierDto);
    Result updateSupplier(UpdateSupplierDto updateSupplierDto);
    Result<GetSupplierByIdDto> getSupplierById(GetSupplierByIdDto getSupplierByIdDto);
    Result<List<GetAllSuppliersDto>> getAllSuppliers();
}

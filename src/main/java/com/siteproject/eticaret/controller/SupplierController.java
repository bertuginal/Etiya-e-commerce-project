package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.supplier.CreateSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.DeleteSupplierDto;
import com.siteproject.eticaret.dtos.request.supplier.UpdateSupplierDto;
import com.siteproject.eticaret.dtos.response.supplier.GetAllSuppliersDto;
import com.siteproject.eticaret.dtos.response.supplier.GetSupplierByIdDto;
import com.siteproject.eticaret.services.supplier.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addsupplier")
    public Result addSupplier(@Valid @RequestBody CreateSupplierDto createSupplierDto) {
        return this.supplierService.addSupplier(createSupplierDto);
    }

    @PutMapping("/deletesupplier")
    public Result deleteSupplier(@Valid @RequestBody DeleteSupplierDto deleteSupplierDto) {
        return this.supplierService.deleteSupplier(deleteSupplierDto);
    }

    @PutMapping("/updatesupplier")
    public Result updateSupplier(@Valid @RequestBody UpdateSupplierDto updateSupplierDto) {
        return this.supplierService.updateSupplier(updateSupplierDto);
    }

    @GetMapping("/getsupplierbyid")
    public Result<GetSupplierByIdDto> getSupplierByIdDto(@RequestBody GetSupplierByIdDto getSupplierByIdDto) {
        return this.supplierService.getSupplierById(getSupplierByIdDto);
    }

    @GetMapping("/getallsuppliers")
    public Result<List<GetAllSuppliersDto>> getAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }
}

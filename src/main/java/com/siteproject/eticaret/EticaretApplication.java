package com.siteproject.eticaret;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@SpringBootApplication
@RestControllerAdvice // ExceptionHandling devreye girmesi için
public class EticaretApplication {

    public static void main(String[] args) {
        SpringApplication.run(EticaretApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @ExceptionHandler //Exception ne olduğunu
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // Hangi durumda handler edilecek
    public Result<Object> handleBusinessException(BusinessException businessException) {
        Result<Object> errorResult = new Result<Object>(false, businessException.getMessage());
        return errorResult;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result<Object> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> validationsError = new HashMap<String, String>(); //key-value
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationsError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        Result<Object> errorResult = new Result<Object>(false, "Validation Error!", validationsError);
        return errorResult;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        Result<Object> errorResult = new Result<Object>(false, "No Such Element Exception!", noSuchElementException.getMessage());
        return errorResult;
    }


}



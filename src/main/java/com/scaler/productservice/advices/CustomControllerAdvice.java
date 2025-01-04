package com.scaler.productservice.advices;

import com.scaler.productservice.dtos.ErrorDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> NPEHandler() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("NPE");
        ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.valueOf(401));
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> PNFEHandler() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Product not found please try again");
        ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.valueOf(404));
        return response;
    }
}

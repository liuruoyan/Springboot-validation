package com.cc.validation.web.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    // 模型验证错误
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> validException2(HttpServletRequest request, Exception ex) {
        log.error(request.getRequestURI()+"?"+request.getQueryString(), ex);
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
        List<ObjectError> errors =c.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();

        for (ObjectError error : errors) {
            errorMsg.append(error.getDefaultMessage()).append(";");
        }
        return ResponseEntity.badRequest().body(errorMsg.toString());
    }


    // 单个数据验证错误
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> validException1(HttpServletRequest request, Exception ex) {
        log.error(request.getRequestURI()+"?"+request.getQueryString(), ex);
        log.debug("is it MethodArgumentNotValidException ? : " + (ex instanceof MethodArgumentNotValidException));
        System.out.println("is it MethodArgumentNotValidException ? : " + (ex instanceof MethodArgumentNotValidException));

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> defaultException(HttpServletRequest request, Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}

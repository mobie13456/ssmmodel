package com.zaizai.controller;


import com.zaizai.exception.BusinessException;
import com.zaizai.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {


    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        System.out.println(e+"不许跑");
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        System.out.println(e+"不许跑");
        return new Result(e.getCode(),null,e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        System.out.println(e+"不许跑");
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"网络超时，请重试");
    }
}

package com.dbw.exception;

import com.aliyun.oss.ServiceException;
import com.dbw.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public Result ex(Exception e){
        e.printStackTrace();//打印堆栈中的异常信息
        return Result.error("出错啦，请联系管理员~");
    }

//    @ExceptionHandler()
//    public Result handleDuplicateKeyException(DuplicateKeyException e){
//        log.error("程序错误",e);
//        String message = e.getMessage();
//        int i=message.indexOf("Duplicate entry");
//        String errMsg=message.substring(i);
//        String[] arr = errMsg.split(" ");
//        return Result.error(arr[2]+"已存在");
//    }
}

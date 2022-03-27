package iu.maue.ffm.framework.handler;

import iu.maue.ffm.framework.exception.ExceptionEnum;
import iu.maue.ffm.framework.exception.BizException;
import iu.maue.ffm.framework.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public ErrorResponse bizExceptionHandler(BizException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTrace(e.getStackTrace());
        return errorResponse;
    }

    @ExceptionHandler(value = Exception.class)
    public ErrorResponse exceptionHandler(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionEnum.INNER_ERROR.getCode());
        errorResponse.setMessage(ExceptionEnum.INNER_ERROR.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse accessDeniedHandler(AccessDeniedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionEnum.FORBIDDEN.getCode());
        errorResponse.setMessage(ExceptionEnum.FORBIDDEN.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(ExceptionEnum.BAD_REQUEST.getCode());
            errorResponse.setMessage(error.getDefaultMessage());
            errorResponses.add(errorResponse);
        });
        return errorResponses;
    }
}

package iu.maue.ffm.exception;

/**
 * 业务层面异常
 */
public class BizException extends RuntimeException {

    private final Integer code;

    public BizException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}

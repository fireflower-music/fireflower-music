package iu.maue.ffm.exception;

public enum ExceptionEnum {
    INNER_ERROR(500, "IN-SYSTEM ERRORS"),
    UNAUTHORIZED(401, "NOT LOGGED IN"),
    BAD_REQUEST(400, "REQUEST ERROR"),
    FORBIDDEN(403, "NO PERMISSION TO OPERATE"),
    NOT_FOUND(404, "NOT FOUND"),
    USER_NAME_EXISTS(40001001, "USERNAME IS EXISTS"),
    USER_NOT_FOUND(40401001, "USER IS NOT EXISTS"),
    ;

    private final Integer code;

    private final String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

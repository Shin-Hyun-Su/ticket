package com.ticket.api.enums;

public enum ResEnum {
    
    SUCCESS("0000", "성공"),
    INVALID("0001", "INVALID"),
    FAIL("9999", "네트워크 장애 또는 오류가 발생하였습니다."),
    
    EXIST_ID("1000", "이미 이용중인 ID입니다."),
    WRONG_PW("2000", "미가입 ID이거나 비밀번호가 일치하지 않습니다."),
    ;
    
    private String code;
    private String message;
    
    private ResEnum(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
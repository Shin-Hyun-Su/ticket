package com.ticket.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ticket.api.enums.ResEnum;

public class ResDto {
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    private final String code;
    private final String message;
    @JsonInclude(Include.NON_NULL)
    private final Object result;
    
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public Object getResult() {
        return result;
    }
    
    public ResDto(final String code, final String message, final Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
    
    public static ResDto result(final ResEnum res) {
        return new ResDto(res.getCode(), res.getMessage(), null);
    }
    
    public static ResDto success() {
    	return new ResDto(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMessage(), null);
    }
    
    public static ResDto fail() {
        return new ResDto(ResEnum.FAIL.getCode(), ResEnum.FAIL.getMessage(), null);
    }
    
    public static ResDto invalid(final String key) {
        return new ResDto(ResEnum.INVALID.getCode(), ResEnum.INVALID.getMessage() + " - " + key, null);
    }
}

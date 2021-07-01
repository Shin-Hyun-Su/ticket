package com.ticket.api.controller.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.api.domain.ResDto;

@RestController
@RequestMapping("error")
public class ApiErrorController implements ErrorController {
    
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 공통 error
     */
    @RequestMapping("")
    public ResDto error(HttpServletRequest request, HttpServletResponse response) {
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
        	Integer statusCode = Integer.valueOf(status.toString());
        	if (statusCode != 999 && statusCode != HttpStatus.NOT_FOUND.value()) {
                logger.error("{}", response.getStatus());
            }
        }
        
        return ResDto.fail();
    }
}

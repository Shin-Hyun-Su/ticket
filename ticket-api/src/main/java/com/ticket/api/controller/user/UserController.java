package com.ticket.api.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.api.domain.ResDto;
import com.ticket.api.domain.UserDto;
import com.ticket.api.service.user.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    
	private static final int ID_LEN_MAX = 10;
	private static final int PW_LEN_MAX = 20;
	
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final UserService userService;
    
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }
    
    /**
     * 회원 가입
     */
    @PostMapping("join")
    public ResDto join(@RequestBody final UserDto vo) {
    	logger.info("{}", vo);
    	
    	String userId = vo.getUserId();
    	if (StringUtils.isBlank(userId) || userId.length() > ID_LEN_MAX) {
    		return ResDto.invalid("userId");
    	}
    	
    	String userPw = vo.getUserPw();
    	if (StringUtils.isBlank(userPw) || userPw.length() > PW_LEN_MAX) {
    		return ResDto.invalid("userPw");
    	}
    	
    	return userService.join(vo);
    }
    
    /**
     * 비밀번호 변경
     */
    @PostMapping("password/change")
    public ResDto changePassword(@RequestBody final UserDto vo) {
    	logger.info("{}", vo);
    	
    	String userId = vo.getUserId();
    	if (StringUtils.isBlank(userId) || userId.length() > ID_LEN_MAX) {
    		return ResDto.invalid("userId");
    	}
    	
    	String userPw = vo.getUserPw();
    	if (StringUtils.isBlank(userPw) || userPw.length() > PW_LEN_MAX) {
    		return ResDto.invalid("userPw");
    	}
    	
    	String newUserPw = vo.getNewUserPw();
    	if (StringUtils.isBlank(newUserPw) || newUserPw.length() > PW_LEN_MAX) {
    		return ResDto.invalid("newUserPw");
    	}
    	
    	return userService.changePassword(vo);
    }
    
    /**
     * 회원 삭제
     */
    @PostMapping("out")
    public ResDto out(@RequestBody final UserDto vo) {
    	logger.info("{}", vo);
    	
    	String userId = vo.getUserId();
    	if (StringUtils.isBlank(userId) || userId.length() > ID_LEN_MAX) {
    		return ResDto.invalid("userId");
    	}
    	
    	String userPw = vo.getUserPw();
    	if (StringUtils.isBlank(userPw) || userPw.length() > PW_LEN_MAX) {
    		return ResDto.invalid("userPw");
    	}
    	
    	return userService.out(vo);
    }
}
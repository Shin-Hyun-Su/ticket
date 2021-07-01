package com.ticket.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.api.domain.ResDto;
import com.ticket.api.domain.UserDto;
import com.ticket.api.enums.ResEnum;
import com.ticket.api.mapper.user.UserMapper;

@Service
public class UserService {
    
    private final UserMapper userMapper;
    
    @Autowired
    public UserService(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * 회원 가입
     */
    public ResDto join(UserDto dto) {
        
    	int cnt = userMapper.getUserIdCnt(dto);
    	if (cnt > 0) {
    		// 기가입 ID
    		return ResDto.result(ResEnum.EXIST_ID);
    	}
    	
		int res = userMapper.insUser(dto);
		if (res > 0) {
			return ResDto.success();
		}
    	
        return ResDto.fail();
    }
    
    /**
     * 비밀번호 변경
     */
    public ResDto changePassword(UserDto dto) {
    	
    	int cnt = userMapper.getUserIdCnt(dto);
    	if (cnt == 0) {
    		// 미가입 ID
    		return ResDto.result(ResEnum.WRONG_PW);
    	}
    	
		int res = userMapper.updUserPw(dto);
		if (res > 0) {
			return ResDto.success();
		}
		
		// 비밀번호 불일치
		return ResDto.result(ResEnum.WRONG_PW);
    }
    
    /**
     * 회원 삭제
     */
    public ResDto out(UserDto dto) {
    	
    	int cnt = userMapper.getUserIdCnt(dto);
    	if (cnt == 0) {
    		// 미가입 ID
    		return ResDto.result(ResEnum.WRONG_PW);
    	}
    	
		int res = userMapper.delUser(dto);
		if (res > 0) {
			return ResDto.success();
		}
		
		// 비밀번호 불일치
		return ResDto.result(ResEnum.WRONG_PW);
    }
}
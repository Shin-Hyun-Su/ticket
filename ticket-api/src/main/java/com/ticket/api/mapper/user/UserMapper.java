package com.ticket.api.mapper.user;

import com.ticket.api.domain.UserDto;

public interface UserMapper {
    
    /**
     * ID 개수 조회
     */
    public int getUserIdCnt(final UserDto dto);
    
    /**
     * 회원 등록
     */
    public int insUser(final UserDto dto);
    
    /**
     * 비밀번호 수정
     */
    public int updUserPw(final UserDto dto);
    
    /**
     * 회원 삭제
     */
    public int delUser(final UserDto dto);
}
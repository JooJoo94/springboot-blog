package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RespCode;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		
		System.out.println(dto);
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			System.out.println(result);
			if (result == 1) {
				return RespCode.아이디중복;
			} else {

				return userRepository.save(dto);
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}

	}
}

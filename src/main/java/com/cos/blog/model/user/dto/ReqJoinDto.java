package com.cos.blog.model.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqJoinDto {
	
	@Size(min=7, max=15, message="유저네임 길이가 잘못되었습니다")
	@NotBlank(message="유저네임을 입력하세요")
	private String username;
	
	@Size(min=7, max=15, message="패스워드 길이가 잘못되었습니다")
	@NotBlank(message="패스워드를 입력하세요")
	private String password;
	
	@Size(min=5, max=30, message="이메일 길이가 잘못되었습니다")
	@Email(message="이메일 양식이 틀렸습니다")
	@NotBlank(message="을 입력하세요")
	private String email;
	

	
	

	
}

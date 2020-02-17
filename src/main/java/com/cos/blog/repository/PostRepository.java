package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.post.Post;
import com.cos.blog.model.post.dto.ReqUpdateDto;
import com.cos.blog.model.post.dto.ReqWriteDto;
import com.cos.blog.model.post.dto.RespListDto;

public interface PostRepository {
	
	List<RespListDto> findAll();
	int save(ReqWriteDto dto);
	Post findById(int id);
	int delete(int id);
	int update(ReqUpdateDto	dto);

}

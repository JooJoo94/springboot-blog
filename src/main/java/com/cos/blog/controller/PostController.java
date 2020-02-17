package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.model.RespCM;
import com.cos.blog.model.post.dto.ReqUpdateDto;
import com.cos.blog.model.post.dto.ReqWriteDto;
import com.cos.blog.model.user.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.service.PostService;

@Controller
public class PostController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private PostService postService;

	@GetMapping({ "", "/", "/post" })
	public String posts(Model model) {
		model.addAttribute("posts", postService.목록보기());
		return "/post/list";
	}

	@GetMapping("/post/detail/{id}")
	public String post(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.상세보기(id));
		return "/post/detail";
	}

	// 글쓰기 페이지 이동
	@GetMapping("/post/write")
	public String write() {

		return "/post/write";
	}
	
	// 글 쓰기
	@PostMapping("/post/write")
	public ResponseEntity<?> write(@RequestBody ReqWriteDto dto) {
		User user = (User) session.getAttribute("principal");
		dto.setUserId(user.getId());
		
		int result = postService.글쓰기(dto);
		if(result==1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}		
	}	
	
	// 수정하기
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id, Model model) {
		
		model.addAttribute("post", postService.수정하기(id));
		return "/post/update";
	}
	
	// 수정완료
	@PutMapping("/post/update")
	public ResponseEntity<?> update(@RequestBody ReqUpdateDto dto) {
		
		int result = postService.수정완료(dto);
		if(result==1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else if(result == -3) {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);
		}else {		
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}	
	}
	
	// 삭제하기
	@DeleteMapping("/post/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		int result = postService.삭제하기(id);
		if(result==1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else if(result == -3) {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);
		}else {		
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}			
	}
	
	

}

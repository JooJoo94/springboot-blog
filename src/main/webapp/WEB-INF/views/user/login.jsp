<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">유저 네임</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">패스워드</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="login--submit" class="btn btn-primary" style="opacity:0.7">회원가입</button>
</div>

<%@include file="../include/footer.jsp"%>
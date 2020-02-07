<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">
	<form action="/user/profile" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label for="username">유저 네임</label> <input type="text" class="form-control" placeholder="Enter username" name="username" value="${sessionScope.principal.username}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="password">패스워드</label> <input type="password" class="form-control" placeholder="Enter password" name="password" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email" class="form-control" placeholder="Enter Email" name="email" value="${sessionScope.principal.email}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="profile">프로필 사진</label> <input type="file" class="form-control" name="profile" value="${sessionScope.principal.profile}" />
		</div>
		<button class="btn btn-primary" style="opacity: 0.7">수정</button>
	</form>
</div>

<%@include file="../include/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<c:if test="${user!=null}">
		欢迎您，${user.neckname}<a herf="${pageContext.request.contextPath }/logout">注销</a>
	</c:if>
	<a href="${pageContext.request.contextPath }/register_ui">注册</a>
	<a href="${pageContext.request.contextPath }/login_ui">登录</a>
</body>
</html>
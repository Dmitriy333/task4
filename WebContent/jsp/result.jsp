<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
	Result.jsp page
	<form action="Servlet" method="POST">
		<c:forEach items="${res}" var="item">
			<table border="1">
				<tr>
					<td align="center">${item.name}</td>
				</tr>
				<c:forEach items="${item.clothList}" var="cloth">
					<tr>
						<td width="200" height="100">${cloth.toString()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
		<br />
		<input type="submit" name="startPageButton"
			value="Return to start page" />
	</form>
</body>
</html>
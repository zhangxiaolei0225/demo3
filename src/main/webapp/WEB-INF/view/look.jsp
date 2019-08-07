<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/WdatePicker.js"></script>

</head>
<body>
	<table>
		<tr>
			<td>序号</td>
			<td>${f.id}</td>
		</tr>
		<tr>
			<td>植物名称</td>
			<td>${f.name}</td>
		</tr>
		<tr>
			<td>描述</td>
			<td>${f.dir}</td>
		</tr>
		<tr>
			<td>类别</td>
			<td>${f.tname}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="javascript:history.go(-1)"><input type="button" value="返回"></a></td>
		</tr>
	</table>
</body>
</html>
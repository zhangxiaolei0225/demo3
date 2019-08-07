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
<script type="text/javascript">
function add() {
	
	$.post("add",$("form").serialize(),function(data){
		if(data>0){
			alert("保存成功")
			location.href = "selects";
		}else{
			alert("保存失败")
			location.reload();
		}
	},"json")
}
</script>
<body>
	<form action="">
		植物名称:<input type="text" name = "name">
		描述:<input type="text" name = "dir">
		类别:<select name = "tid">
			<c:forEach items="${list}" var="l">
				<option value="${l.tid}">${l.tname }</option>
			</c:forEach>
		</select>
		<input type="button" value="添加" onclick="add()">
	</form>
</body>
</html>
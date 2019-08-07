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
		function deletebyid(id) {
			$.post("deletebyid",{id:id},function(data){
				if(data>0){
					if(confirm("确认要删除吗？")){
						alert("删除成功");
						location.href = "selects";
					}
				}else{
					alert("删除失败")
				}
			},"json")
		}
		function quan() {
			$(".ck").prop("checked",true);
		}
		
		function deletes() {
			var ids = new Array();
			
			$(".ck:checked").each(function (i) {
				ids[i] = $(this).val();
				
			})
			alert(ids)
			if(ids.length>0){
				if(confirm("确认要删除吗？")){
					$.post("deletes",{ids:ids},function(data){
						if(data>0){
							alert("删除成功")
							location.href = "selects";
						}
					},"json")
				}
			}else{
				alert("删除失败")
			}
			
		}
	</script>
<body>
	<form action="selects" method="post">
		查询内容:<input type="text" name = "name" value="${f.name}">
		<input type="submit" value="搜索">
	</form>
	<a href="toadd"><input type="button" value="添加"></a>
	<input type="button" value="批量删除" onclick="deletes()">
	<table>
		<tr>
			<td><input type="button" value="全选" onclick="quan()"></td>
			<td>序号</td>
			<td>植物名称</td>
			<td>描述</td>
			<td>类别</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info}" var="f" varStatus="i">
			<tr>
				<td><input type="checkbox" value="${f.id}" class = "ck"></td>
				<td>${i.index+1 }</td>
				<td>${f.name }</td>
				<td>${f.dir }</td>
				<td>${f.tname}</td>
				<td>
					<a href="look?id=${f.id}"><input type="button" value="查看"></a>
					<a href="toupdate?id=${f.id}"><input type="button" value="编辑"></a>
					<input type="button" value="删除" onclick="deletebyid(${f.id})">
				</td>
			</tr>
		
		</c:forEach>
		<tr>
			<td colspan="10">${page }</td>
		</tr>
	</table>
</body>
</html>
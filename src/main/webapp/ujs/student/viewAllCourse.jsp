<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理课题信息</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />

<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

body {
	background: url(../img/BG.jpg) repeat;
}

#tea {
	width: 800px;
	margin: auto;
}
</style>
</head>
<body>
</br>
	<div align="center">
		<form action="/CourseSystem/SearchCourseServlet" method="post">
			课程名或者教师名模糊查询查询: <input type="text" name="name"> 
			<input type="submit" value="提交" />
		</form>
		</br>
	</div>

	<div id="tea">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>课程号</th>
					<th>课程题目</th>
					<th>学分</th>
					<th>老师编号</th>
					<th>老师姓名</th>
					<th>课程描述</th>
					<th>申请题目</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${sessionScope.course }">
					<tr>
						<td>${item.cno }</td>
						<td>${item.cname}</td>
						<td>${item.credit}</td>
						<td>${item.tno}</td>
						<td>${item.tname }</td>
						<td>${item.description}</td>
						<td><a href="#"
							onclick="modalupdate('${item.cno }','${item.cname}','${item.tname}')">确认申请</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<!--删除操作的模态框-->
	<form action="/CourseSystem/SelectCourseServlet" method="post">
		<input type="hidden" name="cno" id="cno">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1>提示</h1>
					</div>
					<div class="modal-body">
						确认选择【<span id="tea_name1"></span>】的课题【<span id="sub_name"></span>】？
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default"
							data-dismiss="modal">取消</button>
					</div>
				</div>

			</div>
		</div>
	</form>

</body>
<script type="text/javascript">
	function modalupdate(cno, cname, tname) {
		jQuery("#tea_name1").html(tname);
		jQuery("#sub_name").html(cname);
		jQuery("#cno").val(cno);
		jQuery("#modal_queren").modal();
	}
</script>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
</html>
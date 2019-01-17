<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			body{
				background:url(../img/BG.jpg) repeat;
			}
			#tea{
				width: 800px;
				margin: auto;
			}
			textarea{
			    margin-left:100px;
			    margin-top:30px;
			    height:300px;
			    width:400px;
			}
			.modal-footer{
			   display:flex;
			   flex-direction:row-reverse
			}
		</style>
	</head>
	<body>
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>课程号</th>
						<th>课程名</th>
						<th>学号</th>
						<th>学生</th>
						<th>分数</th>
						<th>选课时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${sessionScope.viewAllStu }">
					<tr>
						<td>${item.cno}</td>
						<td>${item.cname}</td>
						<td>${item.sno}</td>
						<td>${item.sname}</td>
						<td>${item.grade}</td>
						<td>${item.date}</td>
						<td>
						<a href="#" onclick="modalgrade('${item.cno}','${item.sno}')">评分</a> 
		               </form> 
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
	<form action="/CourseSystem/ModifyScoreServlet" method="post">
		<input type="hidden"  name="cno" id="cno" >
		<input type="hidden"  name="sno" id="sno"> 
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>添加分数</h1></div>
					<div class="modal-body" >
						<input type="text" name="grade" class="url" placeholder="输入学生分数">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
					</div>
				</div>
				
			</div>
		</div>
	</form>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
	<script type="text/javascript">
		function modalgrade(cno,sno)
		{
			jQuery("#cno").val(cno);
			jQuery("#sno").val(sno);
			jQuery("#modal_queren").modal();
		}
	</script>
	
</html>
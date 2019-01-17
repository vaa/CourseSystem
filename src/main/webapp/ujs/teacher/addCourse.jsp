<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
			}
			body{
				background-color: #1CAC91;
			}
			#reg{
				width: 400px;
				height: 350px;
				margin: auto;
				padding: 20px;			
				background: #EEF1F6;
				border-radius: 20px;
				box-shadow: 10px 10px 10px gray;
				margin-top: 50px;
				}
		</style>
	</head>
	<body>
	<div id="wrapper">
		<div id="wrappertop"></div>

		<div id="wrappermiddle">

			<h2>添加选修课程</h2>
			<br /><br />
            <form action="/CourseSystem/AddCourseServlet" method="post" >
			<div class="addstu">

				<div class="inputleft"></div>

				<div class="inputmiddle">
					<input type="text" class="url" readonly="readonly"
							value="${sessionScope.login_tea.tno}" name="tea_tno" id ="tea_tno"/>
				</div>

				<div class="inputright"></div>

			</div>
						<div class="addstu">

				<div class="inputleft"></div>

				<div class="inputmiddle">
					<input type="text" name="tea_name" class="url" placeholder="输入课程名称">
				</div>

				<div class="inputright"></div>

			</div>
			<div class="addstu">

				<div class="inputleft"></div>

				<div class="inputmiddle">
					<input type="text" name="tea_credit" class="url" placeholder="输入课程学分">
				</div>

				<div class="inputright"></div>

			</div>
			<div class="addstu">

				<div class="inputleft"></div>

				<div class="inputmiddle">
					<input type="text" name="tea_description" class="url" placeholder="输入课程介绍">
				</div>

				<div class="inputright"></div>

			</div>
		
			<div class="text-center" style="margin-top:10px ;">
				
	        <button type="submit" class="btn btn-success">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-danger">重置</button>
            <br /><br />
			</div>
       
			</form>
		</div>
	</div>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>

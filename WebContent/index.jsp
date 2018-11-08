<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("img").click(function(){
			$("img").attr("src","verify?date=" + new Date());
		});
		
		$("#code input[type='submit']").click(function(){
			alert($("#code input[name='code']").val());
			
			var xhr = new XMLHttpRequest();
			
			var url = "check-code?code='1234'";
			xhr.open('GET', url, true);		
			xhr.send(null);
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200 || xhr.status == 304){
					alert("success");
				}
			};
			
			return false;
			
		});
	});
</script>
</head>
<body>
	
	<form action="" method="post">
		<input type="text" name="email" value="mopixian@163.com"/>
		<input type="submit" value="验证" />
	</form>
	
	<div>
		<form action="check-code" id="code">
			<input type="text" name="code" autocomplete="off"/><img alt="" src="verify"><br>
			<input type="submit" value="submit"/>
		</form>
		
	</div>
	
</body>
</html>
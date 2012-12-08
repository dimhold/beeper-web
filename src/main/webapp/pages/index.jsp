<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="/js/jquery.leanModal.min.js"></script>
<title>Beeper</title>
</head>
<body>
	<div id="layout">
		<%@include file="incl/_statistics.jsp" %>
		<div class="right-corner">
			<a class="btn" href="#signup" name="signup" rel="leanModal" >Register</a>
		</div>
	</div>
	
	<%@include file="incl/_regForm.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
  $('a[rel*=leanModal]').leanModal({ top : 200, closeButton: ".modal_close" });
});
		
	</script>
</body>
</html>
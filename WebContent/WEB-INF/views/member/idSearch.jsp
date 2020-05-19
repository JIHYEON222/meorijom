<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <img src="../../../imgs/backImg1.jpg" id="img1">
    
    <div class="content">
    <h1>아이디 찾기</h1>
	 			<table id="table">
                        <tr>
                             <td class="loginfont">이름</td>
                             <td><input type="text" id="name" name="memberName" ></td>
                             <!--  <td rowspan="2"><button type="submit" id="btn" >로그인</button></td>-->
                        </tr>
                        <tr>
                             <td class="loginfont">전화번호</td>
                             <td><input type="text" id="phone" name="memberPhone"></td>
                         </tr>
                         
                        
                         
                </table>
                		 <button id="btn" >확인</button>
                		 
                		 <div>
                		<input type="text" id="result"> 
                		</div>
                
  </div>
 
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />               
           
	
</body>
<script>
	$(function(){
		$("#btn").click(function(){
			
		
		
		var memberName=$("#name").val();
		var memberPhone=$("#phone").val();
		$.ajax({
			url:"/idSearch",
			type:"get",
			data:{memberName:memberName,memberPhone:memberPhone},
			
			success:function(data){
				$("#result").val(data);
				
			
			}
			
		});
		
		});
			
	});
	
</script>




<style>
.content {
            /*-지우지마세요-*/
            width: 1200px;
            overflow: hidden;
            margin: 0px auto 0 auto;
            height: 500px;
           
        }
        .content>h1{
        	font-size:40px;
        }
        #img1{
           
            width: 100%;
            height: 450px;
        }
        #table{
        	margin:0 auto;
        }
        #btn{
        	margin-left:80px;
            width: 100px;
            height: 50px;
            border-radius: 6px;
            border:1px;
            background-color: red;
            color: white;
            font-size: 20px;
            padding: 10px;
            
        }
</style>
</html>
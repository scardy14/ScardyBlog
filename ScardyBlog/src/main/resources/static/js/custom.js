function updateBlog(postNo) {
	location.href="moveUpdateBlog?postNo="+postNo;
}

function moveWriteBlogForm() {
	if(confirm("글을 작성하시겠습니까?")) {
		location.href = "moveWriteBlogForm";
	}
}
function moveWriteCommunityForm() {
	if(confirm("글을 작성하시겠습니까?")) {
		location.href = "moveWriteCommunityForm";
	}
}

$(document).ready(function() {
			/////////////////////////////////////////////////////////////////////////////
			$("#id").keyup(function() {
		    	   var id = $("#id").val();
		           $.ajax({
		               type: "get",
		               url: "existsById",
		               data: {id: id},
		               success: function(data) {
		            	   if(data) {
		            		   $("#idCheck").text("사용불가능한 아이디입니다");
		            	   } else {
		            		   $("#idCheck").text("사용가능한 아이디입니다");
		            	   }
		            	   
		               },
		               error: function(jqXHR, textStatus, errorThrown) {
		                   console.log(textStatus, errorThrown);
		               }
				});
			});
			/////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////	
			$("#send").click(function() {
	    	   var telephone = $("#tel").val();
	           $.ajax({
	               type: "get",
	               url: "sendMassage",
	               data: {tel: telephone},
	               success: function(data) {
	            	   if(data) {
	            		   alert("인증번호를 발송하였습니다");
	            	   } else {
	            		   alert("인증번호 발송에 실패하였습니다. 다시 시도해주세요. 오류가 계속될 경우 관리자에게 문의하세요")
	            	   }
	               },
	               error: function(jqXHR, textStatus, errorThrown) {
	                   console.log(textStatus, errorThrown);
	               }
	           });
	        });
			/////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////
	        $("#check").click(function() {
	    	   var code = $("#verification").val();
	           $.ajax({
	               type: "get",
	               url: "checkVerificateCode",
	               data: {code: code},
	               success: function(data) {
	            	   if(data) {
	            		   alert("본인인증에 성공하였습니다.");
	            		   telCheck = true;
	            	   } else {
	            		   alert("본인인증에 실패하였습니다. 다시 확인해주세요")
	            		   telCheck = false;
	            	   }
	            	   // 서버에서 전송한 데이터 처리
	               },
	               error: function(jqXHR, textStatus, errorThrown) {
	                   console.log(textStatus, errorThrown);
	               }
	           });
	        });
			/////////////////////////////////////////////////////////////////////////////
		   /////////////////////////////////////////////////////////////////////////////
			$("#nickname").keyup(function() {
		    	   var nickname = $("#nickname").val();
		           $.ajax({
		               type: "get",
		               url: "existsByNickName",
		               data: {nickname: nickname},
		               success: function(data) {
		            	   if(data) {
		            		   $("#nicknamecheck").text("사용불가능한 닉네임입니다");
		            	   } else {
		            		   $("#nicknamecheck").text("사용가능한 닉네임입니다");
		            	   }
		            	   
		               },
		               error: function(jqXHR, textStatus, errorThrown) {
		                   console.log(textStatus, errorThrown);
		               }
				});
			});
			/////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////
			$("#passwordcheck").keyup(function() {
		    	   var pw = $("#password").val();
		    	   var pwcheck = $("#passwordcheck").val();
		    	   var result = false;
		           if(pw==pwcheck) {
		        	   $("#pwcheck").text("비밀번호가 일치합니다");
		        	   result = true;
		           } else {
		        	   $("#pwcheck").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
		        	   result = false;
		           }
		           $.ajax({
		               type: "get",
		               url: "checkPassword",
		               data: {result: result},
				});
			});
			/////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////
			$("#registerForm").submit(function() {
		           $.ajax({
		               type: "get",
		               url: "checkVerification",
		               success: function(data) {
		            	   if(!data) {
		            		   $("#registerForm").preventDefault();
		            		   alert("알 수 없는 오류로 회원가입에 실패하였습니다. 다시시도해주세요. 해당 오류가 계속될 경우 관리자에게 문의하세요");
		            	   } 		            	   
		               },
		               error: function(jqXHR, textStatus, errorThrown) {
		                   console.log(textStatus, errorThrown);
		               }
				});
			});
			/////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////
			$("#writeCategoryBtn").click(function() {
				var category = $("#newCategory").val();
				var header = $("meta[name='_csrf_header']").attr('content');
				var token = $("meta[name='_csrf']").attr('content');
				alert(category);
				 $.ajax({
		               type: "post",
		               url: "writeCategory",
		               data: {category: category},
		               beforeSend: function(xhr){
		                   xhr.setRequestHeader(header, token);
		               },
		               success: function(data) {
		            	   if(data=="success") {
		            		   alert("카테고리 등록");
		            	   } else {
		            		   
		            	   }
		            	   
		               },
		               error: function(jqXHR, textStatus, errorThrown) {
		            	   alert("카테고리 등록실패: "+ textStatus);
		                   console.log(textStatus, errorThrown);
		               }
				});
			})
			/////////////////////////////////////////////////////////////////////////////
		});
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
function moveUpdateAboutForm() {
	if(confirm("블로그 정보를 수정하시겠습니까?")) {
		location.href = "moveUpdateAboutForm";
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
			/////////////////////////////////////////////////////////////////////////////
			var plugins = [
		        "advlist", "autolink", "lists", "link", "image", "charmap", "print", "preview", "anchor",
		        "searchreplace", "visualblocks", "code", "insertdatetime", "media", "table",
		        "paste", "code", "help", "wordcount", "save", "autoresize"
		    ];
		    var edit_toolbar = 'formatselect fontselect fontsizeselect |'
		               + ' forecolor backcolor |'
		               + ' bold italic underline strikethrough |'
		               + ' alignjustify alignleft aligncenter alignright |'
		               + ' bullist numlist |'
		               + ' table tabledelete |'
		               + ' link image';
		
		    tinymce.init({
		    	language: "ko_KR", //한글판으로 변경
		        selector: '#editor',
		        elementpath: false,
		        width: "91%",
		        statusbar: false,
		        //menubar: false,
		        plugins: plugins,
		        content_css: 'style.css',
		        toolbar: edit_toolbar,
		        toolbar_sticky: true, // 스크롤시 툴바 고정 여부
		        location: "folder/sub-folder/new-location.png",
		        //font_foramts: 'custom font name=origin font name, sub1, sub2...; other...;'
		        image_title: true,
		        automatic_uploads: true,
		        file_picker_types: 'image',
		        file_picker_callback: function (cb, value, meta) {
		            var input = document.createElement('input');
		            input.setAttribute('type', 'file');
		            input.setAttribute('accept', 'image/*');
		            input.onchange = function () {
		                var file = this.files[0];
		                var reader = new FileReader();
		                reader.onload = function () {
		                    var id = 'blobid' + (new Date()).getTime();
		                    var blobCache =  tinymce.activeEditor.editorUpload.blobCache;
		                    var base64 = reader.result.split(',')[1];
		                    var blobInfo = blobCache.create(id, file, base64);
		                    document.getElementById('thumbnail').value = blobInfo.base64();
		                    blobCache.add(blobInfo);
		                    cb(blobInfo.blobUri(), { title: file.name });
		                };
		                reader.readAsDataURL(file);
		            };
		            input.click();
		        },
		        /*** image upload ***/
		        
		        content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px; background-color: white;}'
		    });

		    $("#save").on("click", function(){
		        var content = tinymce.activeEditor.getContent();
		        console.log(content);
		    });
		    /////////////////////////////////////////////////////////////////////////////
    
});
		
		
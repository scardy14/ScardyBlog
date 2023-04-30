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
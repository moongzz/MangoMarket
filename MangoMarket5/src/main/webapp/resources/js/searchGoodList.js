/**
 * 
 */
 var searchValue = $("#searchValue").val();
 window.onload = function() {
	goodListOK();
}

 function goodListOK() {
	console.log("검색 값: " + searchValue);
	
	$.ajax({
        url: "searchGoodsOK",
        type: "POST",
        dataType : 'json',
        data: { search: searchValue },
        success: function(resp){
        	if (resp) {
        		var result = '';
            	$.each(resp,function(index,item){
            		result += '<div class="itemBox" onclick="document.location.href = \'showGood?goodsId=' + item["goodsId"] + '\'">';
                   	result += '<div class="imgBox">';
                   	result += "<img src='/uploadImg/" + item['imgUrl'] + "'></div>";
                   	result += "<p class='title'>" + item["title"] + '</p>';
                   	result += "<p class='price'>" + item["price"] + '원</p>';
                   	result += "<p class='address'>" + item["regionName"] + '</p>';
                   	result += "<span><i class='fa-regular fa-heart'></i>" + item['countWishList'] + " ∙ <i class='fa-regular fa-comment'></i> " + item['countChatRoom'] + "</span>";
                   	result += "</div>";
            	})
            	
            	var menuList = "<div class='mainMenu'><ul class='menus'>";
    			menuList += "<li>결과</li></ul></div>";
        		
            	$("#disp").html(result);
            	$("#menuBox").html(menuList);
            } else {
                alert("전송된 값 없음");
            }
        },
        	error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
        	alert("오류 발생.");
        }
  	});
};
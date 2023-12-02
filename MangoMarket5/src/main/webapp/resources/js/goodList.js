/**
 * 
 */
 
var menuValue = $("#menuValue").val();
window.onload = function() {
	goodListOK();
}
function goodListOK() {
	console.log("선택된 메뉴 값: " + menuValue);
	
	$.ajax({
        url: "goodListOK",
        type: "POST",
        dataType : 'json',
        data: { menu: menuValue },
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
        		if(menuValue == 0){
        			menuList += "<li>인기매물</li></ul></div>";
        		}else if(menuValue == 1){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>모바일</li><li data-value='2'>가전제품</li><li data-value='3'>오디오/영상/관련기기</li><li data-value='4'>PC/노트북</li><li data-value='5'>게임/타이틀</li><li data-value='6'>카메라/DSLR</li><li data-value='7'>PC부품/저장장치</li></ul></div>";
        		}else if(menuValue == 2){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>가구</li><li data-value='2'>침구</li><li data-value='3'>수공예/수선</li><li data-value='4'>셀프 인테리어 용품</li><li data-value='5'>인테리어 소품</li><li data-value='6'>꽃/원예</li><li data-value='7'>조명</li></ul></div>";
        		}else if(menuValue == 3){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>베이비의류(0-2세)</li><li data-value='2'>아동의류(3-6세)</li><li data-value='3'>주니어류(7세~)</li><li data-value='4'>이유용품/유아식기</li><li data-value='5'>교육/완구/인형</li><li data-value='6'>유아동용품</li><li data-value='7'>출산/임부용품</li></ul></div>";
        		}else if(menuValue == 4){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>경차</li><li data-value='2'>소형차</li><li data-value='3'>준중형</li><li>중형</li><li data-value='4'>대형</li><li data-value='5'>suv</li><li data-value='6'>트럭</li></ul></div>";
        		}else if(menuValue == 5){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>도서</li><li data-value='2'>문구</li></ul></div>";
        		}else if(menuValue == 6){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>기프티콘/쿠폰</li><li data-value='2'>상품권</li><li data-value='3'>티켓</li></ul></div>";
        		}else if(menuValue == 7){
        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>강아지 용품</li><li data-value='2'>강아지 사료/간식</li><li data-value='3'>기타(강아지)</li><li data-value='4'>고양이 용품</li><li data-value='5'>고양이 사료/간식</li><li data-value='6'>기타(고양이)</li><li data-value='7'>기타(반려동물)</li></ul></div>";
        		}else if(menuValue == 8){
        			menuList += "<li>기타 중고물품</li></ul></div>";
        		}else if(menuValue == 9){
        			menuList += "<li>삽니다</li></ul></div>";
        		}
        		
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

//각 라디오 버튼에 대한 change 이벤트 리스너 추가
document.querySelectorAll('input[type="radio"][name="menu"]').forEach(function(radio) {
    radio.addEventListener('change', function() {
        // 선택된 라디오 버튼의 값을 가져와서 출력
        menuValue = this.value;
        console.log("선택된 메뉴 값: " + menuValue);
        
    	$.ajax({
            url: "goodListOK",
            type: "POST",
            dataType : 'json',
            data: { menu: menuValue },
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
	        		if(menuValue == 0){
	        			menuList += "<li>인기매물</li></ul></div>";
	        		}else if(menuValue == 1){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>모바일</li><li data-value='2'>가전제품</li><li data-value='3'>오디오/영상/관련기기</li><li data-value='4'>PC/노트북</li><li data-value='5'>게임/타이틀</li><li data-value='6'>카메라/DSLR</li><li data-value='7'>PC부품/저장장치</li></ul></div>";
	        		}else if(menuValue == 2){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>가구</li><li data-value='2'>침구</li><li data-value='3'>수공예/수선</li><li data-value='4'>셀프 인테리어 용품</li><li data-value='5'>인테리어 소품</li><li data-value='6'>꽃/원예</li><li data-value='7'>조명</li></ul></div>";
	        		}else if(menuValue == 3){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>베이비의류(0-2세)</li><li data-value='2'>아동의류(3-6세)</li><li data-value='3'>주니어류(7세~)</li><li data-value='4'>이유용품/유아식기</li><li data-value='5'>교육/완구/인형</li><li data-value='6'>유아동용품</li><li data-value='7'>출산/임부용품</li></ul></div>";
	        		}else if(menuValue == 4){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>경차</li><li data-value='2'>소형차</li><li data-value='3'>준중형</li><li>중형</li><li data-value='4'>대형</li><li data-value='5'>suv</li><li data-value='6'>트럭</li></ul></div>";
	        		}else if(menuValue == 5){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>도서</li><li data-value='2'>문구</li></ul></div>";
	        		}else if(menuValue == 6){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>기프티콘/쿠폰</li><li data-value='2'>상품권</li><li data-value='3'>티켓</li></ul></div>";
	        		}else if(menuValue == 7){
	        			menuList += "<li data-value='0'>전체보기</li><li data-value='1'>강아지 용품</li><li data-value='2'>강아지 사료/간식</li><li data-value='3'>기타(강아지)</li><li data-value='4'>고양이 용품</li><li data-value='5'>고양이 사료/간식</li><li data-value='6'>기타(고양이)</li><li data-value='7'>기타(반려동물)</li></ul></div>";
	        		}else if(menuValue == 8){
	        			menuList += "<li>기타 중고물품</li></ul></div>";
	        		}else if(menuValue == 9){
	        			menuList += "<li>삽니다</li></ul></div>";
	        		}
	        		
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
    });
});
//jQuery를 사용하여 li 태그들에 이벤트 리스너 추가
$(document).on("click", ".mainMenu ul.menus li", function(){
	console.log("li 클릭되었습니다.");
	var selectedValue = $(this).data('value');
    console.log("선택된 메뉴2 값: " + selectedValue);
    console.log("선택된 메뉴1 값: " + menuValue);
    
    $.ajax({
        url: "goodListOKFilter",
        type: "POST",
        dataType : 'json',
        data: 
        { 
        	category: menuValue,
        	category2: selectedValue
        },
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
            	$("#disp").html(result);
            } else {
                alert("전송된 값 없음");
            }
        },
        	error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
        	alert("오류 발생.");
        }
  	});
}); 


/**
 * 
 */


    const fileDOM = document.querySelector('#imgFile');
	const fileDOM2 = document.querySelector('#imgFile2');
	const previews = document.querySelectorAll('.image-box');

	previews[0].addEventListener('click', () => {
		fileDOM.click();
		previews[0].src = null;
		
		fileDOM.addEventListener('change', () => {
	 	const imageSrc = URL.createObjectURL(fileDOM.files[0]);
	 	previews[0].src = imageSrc;
	  });
	});
	previews[1].addEventListener('click', () => {
		fileDOM2.click();
		previews[1].src = null;
		
		fileDOM2.addEventListener('change', () => {
	 	const imageSrc2 = URL.createObjectURL(fileDOM2.files[0]);
	 	previews[1].src = imageSrc2;
	  });
	});
	

	document.getElementById("free").addEventListener('click', () => {
		if(document.getElementById( "free" ).checked){
		    document.getElementById( "price" ).value="0";
		}else{
		    document.getElementById( "price" ).value=null;
		}
	});

	
	
		function sample4_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {

	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 참고 항목 변수

	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }

	            document.getElementById('sample4_postcode').value = data.zonecode;
	            document.getElementById("sample4_roadAddress").value = roadAddr;
	            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	            
	            if(roadAddr !== ''){
	                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	            } else {
	                document.getElementById("sample4_extraAddress").value = '';
	            }

	            var guideTextBox = document.getElementById("guide");
	            if(data.autoRoadAddress) {
	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                guideTextBox.style.display = 'block';

	            } else if(data.autoJibunAddress) {
	                var expJibunAddr = data.autoJibunAddress;
	                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                guideTextBox.style.display = 'block';
	            } else {
	                guideTextBox.innerHTML = '';
	                guideTextBox.style.display = 'none';
	            }
	        }
	    }).open();
	}

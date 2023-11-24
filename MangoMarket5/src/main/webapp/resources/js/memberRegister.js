/**
 * 
 */

 function validateForm() {
    var password = document.forms["member"]["pwd"].value;
    var passwordChk = document.forms["member"]["passwordChk"].value;
    if(password != passwordChk){
        alert("비밀번호와 비밀번호확인이 서로 다릅니다.");
        return false;
    }
}
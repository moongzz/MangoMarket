/**
 * 
 */
const modal = document.getElementById("modal")
	
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modal.style.display = "none"
})

var btnModal = document.getElementById( "modifyBtn" );
btnModal.addEventListener("click", e => {
    modal.style.display = "flex"
});


/* 파일업로드 */
const fileDOM = document.querySelector('#imgFile');
const preview = document.querySelector('#userImg');

preview.addEventListener('click', () => {
    fileDOM.click();
    document.querySelector('#uploadUserImg input[type="submit"]').style.display = 'block';
});

fileDOM.addEventListener('change', () => {
    const imageSrc = URL.createObjectURL(fileDOM.files[0]);
    preview.src = imageSrc;
});
/**
 * 
 */

const modal = document.getElementById("modal")
	
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modal.style.display = "none"
})

var btnModal = document.getElementById( 'loginBtn' );
btnModal.addEventListener("click", e => {
    modal.style.display = "flex"
});
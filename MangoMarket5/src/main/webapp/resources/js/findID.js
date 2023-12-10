/**
 * 
 */
 
const userId = document.getElementById('userId').innerText;
const modifiedText = userId.slice(0,1) + userId.slice(1,-1).replace(/./g, '*') + userId.slice(-1);
document.getElementById('userId').innerText = modifiedText;
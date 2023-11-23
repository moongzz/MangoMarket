/**
 * 
 */
 window.onload = function() {
	var menuBtn = document.querySelectorAll('input[name="menu"]');
	for (var i = 0; i < menuBtn.length; i++) {
		menuBtn[i].addEventListener('click', function() {
			var clickNum = this.value;
			
			var form = document.createElement('form');

		    var objs;
			objs = document.createElement('input');
			objs.setAttribute('type', 'hidden');
			objs.setAttribute('name', 'menu');
			objs.setAttribute('value', clickNum);
			form.appendChild(objs);
			form.setAttribute('method', 'post');
			form.setAttribute('action', "goodList");
			document.body.appendChild(form);

			form.submit();
		});
	}
};
/**
 * check username whether exist
 */

$(function() {
	$("#IbtnEnter").click(
			function() {
				$.post("./user/login.do", {
					"account" : $("#account").val(),
					"password" : $("#password").val()
				}, function(data) {
					if (data.resultCode == 0) {
						location.href = "./home.do";
					} else {
						alert(data.errmsg);
					}
				});
			});
});
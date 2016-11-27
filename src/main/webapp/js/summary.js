/* ボタンのデザインを適用する */
$(function() {
	$("img.sticky").each(function() {
		var imgElem = $(this);
		var id = imgElem.attr("id");
		imgElem.on("click", function() {loadTask(id)});
	});
	$("img").draggable({
		snap:true,
		connectToSortable: ".not-asigned,.not-start,.in-work,.finish",
		revert:"invalid",
		appendTo:"body",
		helper:"clone",
		start: function(e, ui) {
			$("#" + e.target.id).off("click", "*");
		},
		stop: function(e, ui) {
			$("#" + e.target.id).on("click", function() {loadTask(id)});
		}
	});
	$(".not-asigned").droppable({
        accept: "img.sticky",
		drop : function(event, ui) {
			var taskId = ui.draggable.attr("id");
			if ($(this).attr("id") != ui.draggable.parent().attr("id")) {
				userId = "";
				console.log(taskId + " -> .not-asigned");
				changeUserAndStatus(taskId, userId, "1");
				$(this).append(ui.draggable);

			}
		}
	});
	$(".not-start").droppable({
        accept: "img.sticky",
		drop : function(event, ui) {
			var taskId = ui.draggable.attr("id");
			if ($(this).attr("id") != ui.draggable.parent().attr("id")) {
				var userId = $(this).parent().attr("id");
				userId = userId.substr(5);
				console.log(taskId + " -> .not-start");
				changeUserAndStatus(taskId, userId, "1");
				$(this).append(ui.draggable);
			}
		}
	});
	$(".in-work").droppable({
        accept: "img.sticky",
		drop : function(event, ui) {
			var taskId = ui.draggable.attr("id");
			if ($(this).attr("id") != ui.draggable.parent().attr("id")) {
				var userId = $(this).parent().attr("id");
				userId = userId.substr(5);
				console.log(taskId + " -> .in-work");
				changeUserAndStatus(taskId, userId, "2");
				$(this).append(ui.draggable);
			}
		}
	});
	$(".finish").droppable({
        accept: "img.sticky",
		drop : function(event, ui) {
			var taskId = ui.draggable.attr("id");
			if ($(this).attr("id") != ui.draggable.parent().attr("id")) {
				var userId = $(this).parent().attr("id");
				userId = userId.substr(5);
				console.log(taskId + " -> .finish");
				changeUserAndStatus(taskId, userId, "3");
				$(this).append(ui.draggable);
			}
		}
	});

	'use strict';
});

function changeUserAndStatus(taskId, userId, status) {
	$.ajax({
		type:"POST",
		async: false,
		url:"tasks/" + taskId + "/change",
		data:{"param":JSON.stringify({"userId":userId, "status":status})},
		dataType:"json",
		success: function(result) {
			$("#result").text(result.message);
			$("#log-character").show(function() {$("#popover-comment").show();});
			setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert(textStatus);
		}
	});
}

function addTask(taskId) {
	$.ajax({
		type:"GET",
		url:"tasks/create",
		dataType:"html",
		success: function(result) {
			$("#task-form").html(result);
			$('.datepicker').datepicker({
			    format: "yyyy/mm/dd",
			    language: "ja"
			});
			$('#staticModal').modal();
		},
		error: function(result) {
			alert(result);
		}
	});
}

function loadTask(taskId) {
	$.ajax({
		type:"GET",
		url:"tasks/" + taskId + "/update",
		dataType:"html",
		success: function(result) {
			$("#task-form").html(result);
			$('.datepicker').datepicker({
			    format: "yyyy/mm/dd",
			    language: "ja"
			});
			$('#staticModal').modal();
		},
		error: function(result) {
			alert(result);
		}
	});
}

function registerTask() {
	$.ajax({
		type:"POST",
		url:$("#input-form").attr("action"),
		date:{"param":JSON.stringify($("#input-form").serializeArray())},
		dataType:"json",
		success: function(result) {
			var url = $("#input-form").attr("action");
			if (url.indexOf("/create") > 0) {
				var stickyColor = "";
				if (result.rankNo == "1") {
					stickyColor = "red";
				} else if (result.rankNo == "2") {
					stickyColor = "orange";
				} else if (result.rankNo == "3") {
					stickyColor = "blue";
				} else if (result.rankNo == "4") {
					stickyColor = "green";
				} else if (result.rankNo == "5") {
					stickyColor = "green";
				}
				$('#staticModal').modal('hide');

				var sticky = $('<img src="../images/sticky-' + stickyColor + '.png" id="' + result.taskId + '" class="sticky" />');
				if (result.userId) {
					$("#not-start-" + result.userId).append(sticky);
				} else {
					$("#not-asigned").append(sticky);
				}
				sticky.on("click", function() {loadTask(result.taskId)});

				$("#result").text("新しいタスクを作成したよ。");
			} else {
				$('#staticModal').modal('hide');
				$("#result").text("タスクの内容を変更したよ。");
			}
			$("#log-character").show(function() {$("#popover-comment").show();});
			setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
		},
		error: function(result) {
			alert("");
		}
	});
}

//function getContext() {
//	var url = window.location.href;
//	var hostname = window.location.hostname;
//	var index = url.indexOf(hostname);
//	url = url.substr(index + hostname.length + 1);
//	alert(url);
//	if (url.indexOf(":") > -1) {
//		url = url.substr(url.indexOf(":"), url.indexOf("/") + 1);
//	}
//	url = url.substr(0, url.indexOf("/"));
//	return url;
//}

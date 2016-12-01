var webSocket = null;

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
				changeUserAndStatus(taskId, userId, "3");
				$(this).append(ui.draggable);
			}
		}
	});

	'use strict';

	// ソケット開始
	openSocket();
});

function changeUserAndStatus(taskId, userId, status) {
	var param = {
			"taskId":taskId,
			"companyId":$("#companyIdSel").val(),
			"projectId":$("#projectIdSel").val(),
			"status":status,
			"userId":userId
		};
	webSocket.send(JSON.stringify({"method":"change","param":JSON.stringify(param)}));

	//	$.ajax({
//		type:"POST",
//		async: false,
//		url:"tasks/" + taskId + "/change",
//		data:{"param":JSON.stringify({"userId":userId, "status":status})},
//		dataType:"json",
//		success: function(result) {
//			$("#result").text(result.message);
//			$("#log-character").show(function() {$("#popover-comment").show();});
//			setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
//		},
//		error: function(jqXHR, textStatus, errorThrown) {
//			alert(textStatus);
//		}
//	});
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
	var param = {
		"taskId":$("#input-form").find("#taskId").val(),
		"companyId":$("#input-form").find("#companyId").val(),
		"projectId":$("#input-form").find("#projectId").val(),
		"title":$("#input-form").find("#title").val(),
		"contents":$("#input-form").find("#contents").val(),
		"startDeadlineDate":$("#input-form").find("#startDeadlineDate").val(),
		"endDeadlineDate":$("#input-form").find("#endDeadlineDate").val(),
		"rankNo":$("#input-form").find("#rankNo").val(),
		"userId":$("#input-form").find("#userId").val()
	};
	var url = $("#input-form").attr("action");
	if (url.indexOf("/create") > 0) {
		webSocket.send(JSON.stringify({"method":"create","param":JSON.stringify(param)}));
	} else {
		webSocket.send(JSON.stringify({"method":"update","param":JSON.stringify(param)}));
	}
}

function openSocket() {
	if (webSocket == null) {
		var url= "ws://" + window.location.hostname + ":" + window.location.port + "/watsuco/task";
		// WebSocket の初期化
		webSocket = new WebSocket(url);
		// イベントハンドラの設定
		webSocket.onopen = function (event) {
			webSocket.send(JSON.stringify({"method":"init", "projectId":$("#projectIdSel").val()}));
		}
		webSocket.onclose = function (event) {
			webSocket = null;
			setTimeout("openSocket()", 3000);
		}
		webSocket.onerror = function (event) {
		    //chat("エラーが発生しました。");
		}
		webSocket.onmessage = onMessage;
	}
}

// メッセージ受信イベント
function onMessage(event) {
	var result = JSON.parse(event.data);
	if (result.method == "update") {
		if (result.rankNo == "1") {
			stickyColor = "red";
		} else if (result.rankNo == "2") {
			stickyColor = "yellow";
		} else if (result.rankNo == "3") {
			stickyColor = "blue";
		} else if (result.rankNo == "4") {
			stickyColor = "green";
		} else if (result.rankNo == "5") {
			stickyColor = "green";
		}

		$("#" + result.taskId).attr("src", "../images/sticky-" + stickyColor + ".png");

		$('#staticModal').modal('hide');
		$("#result").text("タスクの内容を変更したよ。");
		$("#log-character").show(function() {$("#popover-comment").show();});
		setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
	}
	else if (result.method == "create") {
		var stickyColor = "";
		if (result.rankNo == "1") {
			stickyColor = "red";
		} else if (result.rankNo == "2") {
			stickyColor = "yellow";
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
		sticky.draggable({
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

		$("#result").text("新しいタスクを作成したよ。");
		$("#log-character").show(function() {$("#popover-comment").show();});
		setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
	}
	else if (result.method == "changeSelf") {
		$("#result").text(result.message);
		$("#log-character").show(function() {$("#popover-comment").show();});
		setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
	}
	else if (result.method == "change") {
		// タスクの移動
		var sticky = $("#" + result.taskId);
		if (result.userId == "") {
			$("#not-asigned").append(sticky);
		} else {
			if (result.status == "1") {
				$("#not-start-" + result.userId).append(sticky);
			} else if (result.status == "2") {
				$("#in-work-" + result.userId).append(sticky);
			} else if (result.status == "3") {
				$("#finish-" + result.userId).append(sticky);
			}
		}

		// 完了メッセージを表示
		$("#result").text(result.message);
		$("#log-character").show(function() {$("#popover-comment").show();});
		setTimeout(function() {$("#log-character").fadeOut(1500, function() {$("#popover-comment").hide();})}, 3000);
	}
}

// 切断イベント

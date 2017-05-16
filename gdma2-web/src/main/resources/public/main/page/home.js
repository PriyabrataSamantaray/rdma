var tableId;
var columns = new Array();
var tableData;

var loadDatatable = function(){
	showLoading("#loading-spinner-modal");
	$.ajax({
        type: "get",
        url: mapPathVariablesInUrl(restUri.column.column_data, {id: tableId}),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function(data){
    	$("#tableHeaderRow").empty();
		$("<th>Row id</th>").appendTo("#tableHeaderRow");
		columns[0] = {
			name : "Row Id"
		}
		$.each(data, function(i, column) {
			columns[i + 1] = column;
			$("<th>" + column.name + "</th>").appendTo("#tableHeaderRow");
		});
    }).fail(function(e){
    	handleError('#global-alert', e);
    }).complete(function(e){
    	configureDataTable();
    }).always(function(){
    	hideLoading("#loading-spinner-modal");
    	$("#tableRow").show();
    });
	
}


var configureDataTable = function(){
	var columnsData = [];
	for(var i = 0; i < columns.length; i++){
		columnsData[i] = {"data": ""+i};
	}
	
	var config={
			"lengthMenu": [ [10, 25, 50, 100], [10, 25, 50, 100] ],
			"columnDefs": [ { className: "text-center", "targets": [7,8] },
			                { "orderable": false, "targets": 8 } ],
			 "dataSrc": "data",
			 "columns": columnsData
	};

	tableData = $('#table_data').configureDataTable(config, {
		url: mapPathVariablesInUrl(restUri.table.table_data, {id: tableId}),
		complete: function(){
			//hideLoading();
		},
		error: function(message, e){
			console.error("ERROR: " + JSON.stringify(e));
			handleError('#global-alert',e);
		}
	});
	
}

$(document).ready(function(){	
	tableId = sessionStorage.getItem("tableId");
	if(tableId){
		loadDatatable();
	}
    
});
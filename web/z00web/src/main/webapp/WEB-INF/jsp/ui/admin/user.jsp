<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/ui/common/ctx.tag"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <title>Users</title>
  
  <base href="${base}" />

  <%@ include file="/WEB-INF/jsp/ui/common/css.jspf"%>
  <link rel="stylesheet" href="${base}/resource/dist/plugin/datatable/dataTables.bootstrap.css">
  <link rel="stylesheet" type="text/css" media="screen" href="${base}/resource/dist/plugin/trirand/css/ui.jqgrid-bootstrap.css">
  <link rel="stylesheet" type="text/css" media="screen" href="${base}/resource/dist/plugin/trirand/css/ui.jqgrid.css">
  
  <style>
	.ui-jqgrid .ui-jqgrid-view {position: relative;left:0; top: 0; padding: 0; font-size:14px; z-index:100;}
  </style>
	


  <%@ include file="/WEB-INF/jsp/ui/common/script.jspf"%>
  <script src="${base}/resource/dist/plugin/trirand/js/i18n/grid.locale-en.js" type="text/javascript"></script>
  <script src="${base}/resource/dist/plugin/trirand/js/jquery.jqGrid.min.js" type="text/javascript"></script>




  <script class="init">
		//$.jgrid.defaults.width = 800;
		//$.jgrid.defaults.styleUI = 'Bootstrap';

        $(document).ready(function () {
			
            $("#jqGrid").jqGrid({
                url: '${base}/web/data/users',
                mtype: "GET",
				styleUI : 'Bootstrap',
                datatype: "json",
                colModel: [
                    { label: 'ID', name: 'id', key: true, align: 'right' },
                    { label: 'Account', name: 'name'},
                    { label: 'First Name', name: 'firstName' },
                    { label: 'Last Name', name: 'lastName' },
                    { label:'Email', name: 'email' }
                ],
				viewrecords: true,
				autowidth:true,
				hoverrows:false,			
                height: 500,
                rowNum: 20,
                loadonce: true, 
                pager: "#jqGridPager"
            });
        });
              
 
  </script>
  
  
</head>




<body class="hold-transition skin-blue sidebar-mini">

 <div class="wrapper">
	
  <%@ include file="/WEB-INF/jsp/ui/common/header.jspf"%>
  <%@ include file="/WEB-INF/jsp/ui/common/sidebar.jspf"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Users Management
        <small>Manage your user list here</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Users</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
        
			<div style="margin-left:20px;font-size: 14px;">
			    <table id="jqGrid" style="font-size: 14px;"></table>
			    <div id="jqGridPager" style="font-size: 14px;"></div>
			</div>

<div id="content" data-role="content">
    <ul id="hellolist" data-role="listview"> </ul>       
</div><!-- /content -->

<script type="text/javascript">
    $.ajax({
        type: "GET",
        url: "${base}/web/data/users",
        dataType: "json",
        success: function(articles) {
            var html = '<li><h3>One</h3></br> test</li><li><h3>Two</h3></li><li><h3>Three</h3></li>';            
            $('#hellolist').append($(html));
            $('#hellolist').listview('refresh');
        }                            
    });
</script>  
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <%@ include file="/WEB-INF/jsp/ui/common/footer.jspf"%>
  <!--   %@ include file="/WEB-INF/jsp/ui/common/sidebar-control.jspf"% -->

  </div>
</body>
</html>
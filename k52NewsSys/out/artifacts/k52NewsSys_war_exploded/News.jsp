<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/25
  Time: 6:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News管理页面</title>
    <link rel="stylesheet" type="text/css" href="/static/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
</head>

<body>
<h2>DataGrid with Toolbar</h2>
<div style="margin:20px 0;"></div>
<table id="dg" class="easyui-datagrid" style="width:700px;height:290px">
    <thead>
    <tr>
        <th data-options="field:'newsID',width:80">新闻ID</th>
        <th data-options="field:'newsTitle',width:100">新闻标题</th>
        <th data-options="field:'newsContent',width:260">新闻内容</th>
        <th data-options="field:'typeID',width:100" formatter="formatTypeID">类型名称</th>
    </tr>
    </thead>
</table>

<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="insertNewsType()">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editNewsType()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteNewsType()">删除</a>
</div>

<div id="dlg" class="easyui-dialog" title="新闻表管理" data-options="iconCls:'icon-save'"
     style="width:400px;height:200px;padding:10px">
    <div class="ftitle">添加新闻</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>新闻ID：</label>
            <input name="newsID" type="text">
        </div>
        <div class="fitem">
            <label>新闻标题：</label>
            <input name="newsTitle" type="text">
        </div>
        <div class="fitem">
            <label>新闻内容：</label>
            <input name="newsContent" type="text">
        </div>
        <div class="fitem">
            <label>类别ID：</label>
            <input name="typeID" class="easyui-validatebox" required="true">
        </div>

    </form>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNewsType()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</div>


<script type="text/javascript">
    var newsType = "";

    function formatTypeID(val,row){


        for (var i in newsType.rows){
            if (newsType.rows[i].typeID==val){
                // console.log(newsType.rows[i].typeName);
                return newsType.rows[i].typeName;
            }
        }
    }




    function insertNewsType() {
        $('#dlg').dialog('open').dialog('setTitle', '新增新闻');
        $('#fm').form('clear');
        url = './api/v1.0/News';
    }

    //点击编辑按钮
    function editNewsType() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('setTitle', '编辑新闻');
            $('#fm').form('load', row);
            url = './api/v1.0/News';
        }
    }

    //通过ajax进行数据的添加，添加完之后重新请求数据
    function saveNewsType() {
        //需要进行新增的识别和修改的识别：当typeID为空时，进行新增。typeID有值时，进行修改。
        var flag = $("input[name='newsID']").val();
        if (flag == "") {
            $('#fm').form('submit', {
                url: url,
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    //需要注意数据格式
                    if (result.errorMsg) {
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');		// close the dialog
                        $('#dg').datagrid('reload');	// reload the user data
                    }
                }
            });

        } else {

            $.ajax({
                url: url + "?" + $("#fm").serialize(),
                type: "put",
                // data: $("#fm").serializeArray(),
                dataType: "json",
                success: function (result) {

                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the user data
                }
            });

        }


    }


    function deleteNewsType() {
        url = './api/v1.0/News';
        var row = $('#dg').datagrid('getSelected');
        console.log("row："+row);
        if (row) {
            $.messager.confirm('Confirm', '你确定要删除该新闻吗？', function (r) {
                if (r) {
                    $.ajax({
                        url: url + "?newsID=" + row.newsID,
                        type: "delete",
                        // data: $("#fm").serializeArray(),
                        dataType: "json",
                        success: function (result) {
                            $('#dg').datagrid('reload');	// reload the user data
                        }
                    });



                    // $.post('destroy_user.php', {id: row.id}, function (result) {
                    //     if (result.success) {
                    //         $('#dg').datagrid('reload');	// reload the user data
                    //     } else {
                    //         $.messager.show({	// show error message
                    //             title: 'Error',
                    //             msg: result.errorMsg
                    //         });
                    //     }
                    // }, 'json');
                }
            });
        }
    }


    $(function () {

        $.ajax({
            url: "./api/v1.0/NewsType",
            type: "get",
            // data: $("#fm").serializeArray(),
            dataType: "json",
            success: function (result) {
                newsType=result;

            }
        });



        $('#dlg').dialog('close');

        var pager = $('#dg').datagrid({
            title: "新闻表管理",
            rownumbers: true,
            singleSelect: true,
            pagination: true,
            toolbar: "#toolbar",
            pageSize: 5,
            pageList: [5, 10, 20],
            url: './api/v1.0/News',
            method: 'get'
        }).datagrid('getPager');	// get the pager of datagrid


    })
</script>
</body>
</html>

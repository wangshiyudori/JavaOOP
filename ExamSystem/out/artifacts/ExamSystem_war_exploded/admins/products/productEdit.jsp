<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/12
  Time: 11:00 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品编辑页面</title>
</head>
<body>

<form action="product.jsp" method="post">
<textarea name="content" id="editor">

</textarea>

    <input type="submit" value="提交">
</form>

<script src="../../ckeditor5/ckeditor.js"></script>
<script>
    var data;
    ClassicEditor.create(document.querySelector('#editor'), {
            ckfinder: {
                uploadUrl: '/'
            }
        }
    ).then(editor => {
        window.editor = editor;

        var content = "<p>大家好</p>\n" +
            "    <h1>欢迎大家</h1>\n" +
            "    <hr/>\n" +
            "    <div>爱学习勤思考</div>";
        editor.setData(content);

    // data = editor.getData();
    console.log(data);
    } )
    .catch(error => {
        console.log(error);
    } );
</script>


</body>
</html>

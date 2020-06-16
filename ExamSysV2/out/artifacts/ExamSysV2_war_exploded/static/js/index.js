$(function () {

    $("#userName").on("input", function (e) {
/*
jQuery的Ajax方法：
        $.ajax()
        $.get()
        $.post()
        $.getJSON()
            .load()
            */


        // $("#errorMsg").load("./FindUserByName","userName="+e.target.value);



        // $.getJSON("./FindUserByName","userName="+e.target.value,function (result) {
        //     console.log("getJSON"+result);
        //     console.log("getJSON"+result.data);
        // })



        //要在对应的servlet类中重写doPost方法。方法内可继承doGet(req, resp)，则可显示出post请求信息;
        // $.post("./FindUserByName","userName="+e.target.value,function (result) {
        //     console.log(result);
        //     console.log(result.data);
        // },"json")


        // $.get("./FindUserByName","userName="+e.target.value,function (result) {
        //     console.log(result);
        //     console.log(result.data);
        // })











        // 方法二：实现ajax无刷效果
        //获取数据库中的json数据
        // $.ajax({
        //     url: "./FindUserByName",
        //     type: "get",
        //     data: "userName=" + e.target.value,
        //     dataType:"json",
        //     success: function (result) {
        //         console.log(result);
        //         console.log(result.data);


                // result = eval('(' + result + ')');
                // if (result.data == "true") {
                //     $("#errorMsg").html(result.msg).css("color", "red");
                // } else {
                //     $("#errorMsg").html(result.msg).css("color", "red");
                // }

        //
        //     }
        //
        //
        // });


        //方法二：在控制台请求到 与输入信息 相关的json数据
        // $.ajax({
        //     url: "./FindUserByName?userName=" + e.target.value,
        //     success: function (result) {
        //         console.log("abc" + result);
        //     }
        // });


        //方法一：在控制台请求到 与输入信息 相关的json数据
        // XMLHttpRequest 对象用于在后台与服务器交换数据。
        // var xhr =new XMLHttpRequest();
        // xhr.onreadystatechange=function ()
        // {
        //     if (xhr.readyState==4 & xhr.status==200)
        //     {
        //         console.log(xhr.responseText);
        //     }
        // }
        //
        // xhr.open("get","./FindUserByName?userName="+e.target.value,true);
        // xhr.send();


        //方法一：实现ajax无刷效果
        // $.ajax({
        //     url:"./FindUserByName?userName="+e.target.value,
        // }).done(function (result) {
        //     //将json格式的字符串转成字符串对象
        //     result=eval('('+result+')');
        //     console.log(result.data);
        //
        //     if (result.data=="true"){
        //         $("#errorMsg").html(result.msg)
        //     }else {
        //         $("#errorMsg").html(result.msg)
        //     }
        // }).fail(function (result) {
        //     console.log("eeeee");
        // });
        //


    })


});




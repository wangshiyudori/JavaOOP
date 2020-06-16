$(function () {
    $.get("./FindAllUsers",function (result) {
        // console.log(result);
        result.data.forEach(function (item,index) {

           // console.log(index,item);
            //获取到所有json对象并在页面上显示出来
            var $li=$("<li>"+item.userID+"&nbsp;"+item.userName+"------"+item.userPwd+"</li>");
            // var $li=$("<li>"+result.data[0].userID+"&nbsp;"+result.data[0].userName+"------"+result.data[0].userPwd+"</li>");
            // console.log($li);
            $("ul").append($li);

        })

    },"json")
});
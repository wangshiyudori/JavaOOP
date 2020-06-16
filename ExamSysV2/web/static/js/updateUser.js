$(function () {
    $("#updateUser").click(function () {
        var data = $("#form1").serializeArray();
        $.ajax("");
        $.ajax({url:"./UpdateUser",
            type:"POST",
            data:data,
            success:function (result) {
                console.log(result);
            }
        });

    })

});
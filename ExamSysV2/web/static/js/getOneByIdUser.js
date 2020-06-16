$(function () {
    $("#getOneByIdUser").click(function () {

        var getOneID = $("#getOneID").serialize();
        // console.log(delID);

        $.ajax({
            url: "./GetOneByIdUser",
            type: "post",
            data: getOneID,
            success: function (result) {
                console.log(result);
                $("#print").html(result);
                // var resultJson = $.parseJSON(data);
                // var value= resultJson[0].userID+resultJson[0].userName+resultJson[0].userPwd;
                // console.log(value);
            }
        });


    });


});
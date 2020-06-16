$(function () {
    $("#deleteUser").click(function () {

        var delID = $("#delID").serialize();
        // console.log(delID);

        $.ajax({
            url: "./DeleteUser",
            type: "post",
            data: delID,
            success: function (result) {
                console.log(result);
            }
        });


    });



});
// jQuery.noConflict();

$(function () {
    $("#insertUser").click(function () {

        // console.log($("p").html());


        // POST    http://localhost:8080/api/v1/Users  insert
        //  PUT    http://localhost:8080/api/v1/Users  update
        // DELETE  http://localhost:8080/api/v1/Users  ?param userID=?
        //  http://localhost:8080/api/v1/Users  insert
        var data = $("#form1").serializeArray();
        $.ajax("");
        $.ajax({url:"./AddUser",
            type:"POST",
            data:data,
            success:function (result) {
                console.log(result);
            }
        });



    });
});
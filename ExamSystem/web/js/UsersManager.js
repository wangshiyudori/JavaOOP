$(function () {
   $('.btnEdit').click(function () {
       $('#editUser').show();
       $('#btnSubmit').val('修改用户');
       var userID = $(this).parent().parent().find('.cuserID').text();
       var userName = $(this).parent().parent().find('.cuserName').text();
       var userPwd = $(this).parent().parent().find('.cuserPwd').text();
       $('#userID').val(userID);
       $('#userName').val(userName);
       $('#userPwd').val(userPwd);
   }) ;

   $('#btnNew').click(function () {
       $('#editUser').show();
       $('#btnSubmit').val("新增用户");
       $('#userID').val(0);
       $('#userName').val('');
       $('#userPwd').val('');
   });
});
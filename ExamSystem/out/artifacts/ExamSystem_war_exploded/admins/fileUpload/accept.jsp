<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/11
  Time: 10:56 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 1、创建工厂类：DiskFileItemFactory factory=new DiskFileItemFactory();
    DiskFileItemFactory factory = new DiskFileItemFactory();
    // 2、创建解析器：ServletFileUpload upload=new ServletFileUpload(factory);
    ServletFileUpload upload = new ServletFileUpload(factory);
    upload.setHeaderEncoding("UTF-8");
    // 设置缓冲区大小与临时文件目录
    factory.setSizeThreshold(1024 * 1024 * 10);


    File fileDir = new File("/Users/dori/Downloads/tomcat/apache-tomcat-8.5.43/webapps/ExamSystem/images/");
    if (!fileDir.exists())
        fileDir.mkdirs();
    // 设置文件存储仓库
    factory.setRepository(fileDir);
    // 设置单个文件大小限制
    upload.setFileSizeMax(1024 * 1024 * 10);
    // 设置所有文件总和大小限制
    upload.setSizeMax(1024 * 1024 * 100);


    List<FileItem> list = upload.parseRequest(request);


    for (FileItem item : list) {
        //判断是否为表单元素
        if (!item.isFormField() && item.getName() != null && !"".equals(item.getName())) {

//            String formName =


            //判断文件大小 限制上传文件大小
            long size = item.getSize()/1024/1024;
            if (size<5){

                //获取图片的拓展名称 用时间戳的形式识别
                String extType = item.getName().substring(item.getName().lastIndexOf("."));
                //.jpg   .png
                Date date = new Date();
//            date.getYear()+date.getMonth()
//            yyyyMMdddHHmmssms

                String uploadPath = fileDir.getAbsolutePath() + "/" + date.getTime()+extType;

//            String uploadPath = fileDir.getAbsolutePath() + "/" + item.getName();
                System.out.println(uploadPath);
                File file = new File(uploadPath);

                //解决多文件上传
                String fileName = uploadPath;
                //解决单文件上传
                item.write(file);
            }

        }


        //解决混合表单上传 item项要进行字段名的获取：item.getFiledName()
        if (item.isFormField() ) {

            if ("userName".equals(item.getFieldName() )) {
                String userName = item.getString("UTF-8");
                out.print("<h1>" + userName + "</h1>");
            }
            if (item.getFieldName().equals("userPwd")) {
                String pwd = item.getString("utf-8");
                out.print(pwd);
            }


        }

    }


%>

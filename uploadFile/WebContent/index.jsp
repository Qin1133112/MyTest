<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
  </head>
  
  <body>
    <form action="UploadFileServlet2" method="post"  enctype="multipart/form-data">
        文件描述:<input type="text" name="describe"/><br/>
        文件位置<input type="file" name="file"/><br/>
        <input type="submit" value="上传"/>
    </form>
  </body>
</html>
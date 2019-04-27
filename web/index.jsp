<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script type="text/javascript">
    </script>
    <base href="<%=basePath%>">
    <title>短网址生成</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    <!--<![endif]-->
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="css/layouts/marketing.css">
    <!--<![endif]-->
    <link rel="stylesheet" href="css/global.css">
</head>

<body>
<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading" href="">短网址生成</a>
    </div>
</div>
<div class="splash-container">
    <div class="splash">
        <div class="splash-subhead">
            出于网站安全考虑，为避免本站短网址功能不幸成为不法分子犯罪的帮凶，特此关闭短网址创建的功能，并给出以下常见网址用于学习交流测试使用，谢谢合作！
            <table>
                <thead>
                    <tr>
                        <td>实际网址</td>
                        <td>生成的短网址</td>
                    </tr>
                </thead>
                <c:forEach items="${list}" var="u">
                    <tbody>
                        <tr>
                            <td>${u.realUrl}</td>
                            <td><a href="${host }${u.shortUrl}">${host }${u.shortUrl}</a></td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <form class="pure-form pure-form-aligned" action="${pageContext.request.contextPath }/create.do" method="post">
            <fieldset>
                <div class="pure-control-group">
                    <label for="url">请输入URL：</label>
                    <input id="url" type="text" name="url" value="${urlMap.realUrl }"
                           placeholder="URL"><span>${message }</span>
                </div>
                <div class="pure-control-group">
                    <style scoped>
                        .button-error,
                        .button-error {
                            background: rgb(202, 60, 60); /* this is a maroon */
                            font-size: 400%;
                        }
                    </style>
                    <input type="submit" name="submit" value="提交" class="button-error pure-button">
                </div>
            </fieldset>
        </form>
    </div>
</div>


<div class="copyright">
    <p>
        Copyright &copy; 2016.Coselding All rights reserved. 鲁ICP备15036981号-2
    </p>
</div>
</body>
</html>


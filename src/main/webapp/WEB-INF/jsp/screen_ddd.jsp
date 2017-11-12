<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head lang="zh">
    <%@include file="/WEB-INF/jspf/header.jspf"%>
    <script src="http://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
    <script src="${context}/resources/js/myjs.js"></script>

</head>
<body>
<%@include file="/WEB-INF/jspf/nav.jspf"%>

<!--=====************** ABOUT SECTION ***************=====-->
<section id="log" class="about-section section-padding">
    <div class="container">
        <input type="text" id="userId" class="form-control" placeholder="手机号" required data-error="请输入需要查看日志的手机号">

        <button id="conline" class="btn theme-color" onclick="conline();" >开启日志</button>
        <button id="disconline" class="scroll-btn btn extra" onclick="disconnect();" disabled="disabled">关闭日志</button>
        <h3>
            实时日志记录内容
        </h3>
        <div id="console" class="form-control my-console" ></div>
    </div>
</section>
<!--=====*********** END ABOUT SECTION **************=====-->



<%@include file="/WEB-INF/jspf/footer.jspf"%>
<%@include file="/WEB-INF/jspf/footerscript.jspf"%>

</body>
</html>
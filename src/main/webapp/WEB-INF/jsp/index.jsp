<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head lang="zh">
	<%@include file="/WEB-INF/jspf/header.jspf"%>

</head>
<body>
<%@include file="/WEB-INF/jspf/nav.jspf"%>

<!--=====************** ABOUT SECTION ***************=====-->
<section id="xiaohe" class="about-section section-padding">
	<div class="container">
		<div class="row">
			<div class="col-md-4 single-work">
				<h4>扫码下载爱校最新测试包</h4>
				<a href="${context}/resources/images/portfolio/item1.jpg" class="image-popup">
					<img src="${context}/resources/images/portfolio/item1.jpg" alt="">
					<div class="itemHover">
						<div class="work-table">
							<div class="table-cell">
								<div class="hover-content">
									<i class="fa fa-camera"></i>
									<h6>点开看大图</h6>
								</div>
							</div>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-8">
				<div class="about-text wow fadeInRight" data-wow-delay="0.4s">

					<h3>API平台</h3>
					<p>爱校线上编译API：<a href="${context}/apk/aixiao" target="_blank">${context}/apk/aixiao</a></p>
					<p>爱校线上更新API：<a href="${context}/apk/aixiaoUp" target="_blank">${context}/apk/aixiaoUp</a></p>
					<p>杰睿线上编译API(未上线)：<a href="${context}/apk/apkchange/jerry" target="_blank">${context}/apk/apkchange/jerry</a></p>
					<p>佳一线上编译API(未上线)：<a href="${context}/apk/apkchange/jiayi" target="_blank">${context}/apk/apkchange/jiayi</a></p>

					<%--<h3><a href="/apk/aixiao" target="_blank">爱校包下载</a></h3>--%>
					<%--<h3><a href="/apk/apkchange/jerry" target="_blank">杰睿包下载</a></h3>--%>
					<%--<h3><a href="/apk/apkchange/jiayi" target="_blank">佳一包下载</a></h3>--%>
					<%--<h3><a href="" target="_blank">ANDROID 日志平台</a></h3>--%>
					<h4>API功能</h4>
					<p>爱校app线上编译(返回为编译成功或失败，并返回下载apk地址）</p>
					<p>爱校app代码更新(返回为成功或失败，编写好的代码更新到svn后调用）</p>
					<p>杰睿／佳一 接口未上线</p>

				</div>
			</div>
		</div>

	</div>
</section>
<!--=====*********** END ABOUT SECTION **************=====-->



	<%@include file="/WEB-INF/jspf/footer.jspf"%>
<%@include file="/WEB-INF/jspf/footerscript.jspf"%>

</body>
</html>
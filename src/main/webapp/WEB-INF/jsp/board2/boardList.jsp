<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>board1</title>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
</head>
<body>
<!-- <ul id="slide-out" class="side-nav">
    <li><div class="userView">
      <div class="background">
        <img src="images/office.jpg">
      </div>
      <a href="#!user"><img class="circle" src="images/yuna.jpg"></a>
      <a href="#!name"><span class="white-text name">John Doe</span></a>
      <a href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
    </div></li>
    <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
    <li><a href="#!">Second Link</a></li>
    <li><div class="divider"></div></li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a> -->
<!-- <ul class="collapsible" data-collapsible="accordion">
  <li>
    <div class="collapsible-header"><span class="new badge">4</span><i class="material-icons">filter_drama</i>First</div>
    <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
  </li>
  <li>
    <div class="collapsible-header"><span class="badge">1</span><i class="material-icons">place</i>Second</div>
    <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
  </li>
</ul> -->
	<a href="board2Form">글쓰기</a>
<ul class="collapsible popout" data-collapsible="accordion">
	
	<c:forEach var="listview" items="${listview}" varStatus="status">
	<li>
	<div class="collapsible-header"><i class="material-icons">filter_drama</i><c:out value="${pageVO.totRow-((pageVO.page-1)*pageVO.displayRowCount + status.index)}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${listview.brdtitle}"/></div>
    <div class="collapsible-body"><p><c:out value="${listview.brddate}"/> <c:out value="${listview.brdhit}"/></p></div>
    </li>
    </c:forEach>
</ul>					
<%-- 	<table class="bordered highlight centered responsive-table">		
		<thead>
			<tr>
				<th data-field="no">번호</th> 
				<th data-field="subject">제목</th>
				<th data-field="user">등록자</th>
				<th data-field="regdate">등록일</th>
				<th data-field="count">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listview" items="${listview}" varStatus="status">	
				<c:url var="link" value="board2Read">
					<c:param name="brdno" value="${listview.brdno}" />
				</c:url>		
										  				
				<tr>
					<td>
						<c:out value="${pageVO.totRow-((pageVO.page-1)*pageVO.displayRowCount + status.index)}"/>					
					</td>
					<td><a href="${link}"><c:out value="${listview.brdtitle}"/></a></td>
					<td><c:out value="${listview.brdwriter}"/></td>
					<td><c:out value="${listview.brddate}"/></td>
					<td><c:out value="${listview.brdhit}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>  --%>   
	<c:if test="${pageVO.totPage>1}">
	<div class="paging">
	    <c:forEach var="i" begin="${pageVO.pageStart}" end="${pageVO.pageEnd}" step="1">
	        <c:url var="pageLink" value="board2List">
	        <c:param name="page" value="${i}" />
	        </c:url>                        
	            <a href="${pageLink}"><c:out value="${i}"/></a>
	    </c:forEach>
	</div>
	</c:if> 
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<script type="text/javascript"></script>
</body>
</html>

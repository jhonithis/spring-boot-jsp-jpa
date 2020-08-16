<%@ tag pageEncoding="iso-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
		<title><fmt:message key="menu.project"/></title>
		<ct:templateStylesheets/>
	</head>
	<body>
	
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<s:url value="/" />"><fmt:message key="menu.project"/></a>
				</div>
				
				<ul class="nav navbar-nav">
            	
					<li>
						<a href="<s:url value="/pessoa" />" class="btn-lg" title='Pessoa'>
							Pessoa
						</a>
					</li>
					
					<li>
						<a href="<s:url value="/" />" class="btn-lg" title='Projeto'>
							Projeto
						</a>
					</li>
					
				</ul>
            </div>
	    </nav>
		
		<div class="container-fluid">
        	<div class="row">
        	
        		
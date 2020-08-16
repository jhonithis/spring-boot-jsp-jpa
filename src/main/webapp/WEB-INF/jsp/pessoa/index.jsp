<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>

<ct:templateHeader />

<section class="content">
	
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<ol class="breadcrumb" >
			<li class="active"><h4><strong>Pessoa</strong></h4></li>
			<li>		
				<a 
					href="<s:url value="/formPessoa" />" 
					class="btn btn-primary"
					title='<fmt:message key="button.add"/>'>
						<fmt:message key="button.add"/> 
				</a>
			</li>
		</ol>
	</div>
	
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		
	
		<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
			<div class="row">
			
				<c:if test="${empty listPessoa}">
					<br/>	
					<br/>
					<br/>
					<div class="col-lg-12 col-md-12 col-sm-12  col-xs-12">
						<div class="alert alert-info">
							<fmt:message key="table.result.not.found"/>
						</div>
					</div>
					<br/>
					<br/>
					<br/>
				</c:if>
			
				<c:if test="${not empty listPessoa}">
					
					<table 
						class="table table-striped table-bordered table-hover table-condensed small">
						
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Nome</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${listPessoa}" var="item" varStatus="contador">
								<tr>
									<td>${contador.count}</td>
									<td>${item.nome}</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				
				</c:if>
			
			</div>
		
		</div>
		
		
	</div>
		
</section>

<ct:templateFooter/>
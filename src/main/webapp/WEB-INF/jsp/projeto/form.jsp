<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ct" 	tagdir="/WEB-INF/tags" %>

<ct:templateHeader />

<section class="content">
	
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 ">
	
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Projeto</strong>
			</div>
				
			<s:url value="/doFormProjeto" var="acao" />
			<sf:form method="post" modelAttribute="projeto" action="${acao}" >
				
				<div class="panel-body">
				
					<div class="row">
					
							<c:if test="${not empty projeto.id}">
								<sf:hidden path="id" />
							</c:if>
						
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
								<div class="form-group">
									<label for="nome">Nome:</label>
									<sf:input path="nome" class="form-control"/>
								</div>
							</div>
			
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">				
								<div class="form-group">
									<label for="data">Data Início:</label>
									<fmt:formatDate value="${projeto.dataInicio}" var="dateString" pattern="dd/MM/yyyy" />
									<sf:input
										value="${dateString}"
										path="dataInicio" 
										class="form-control"/>
								</div>
							</div>
			
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									<label for="idade">Gerente Responsável:</label>
									<sf:select path="pessoa.id" cssClass="form-control">
										 <sf:options items="${listPessoas}" itemValue="id" itemLabel="nome"/>
						            </sf:select>
								</div>
							</div>
							
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									<label for="data">Previsão de término:</label>
									<fmt:formatDate value="${projeto.dataPrevisaoFim}" var="dateString" pattern="dd/MM/yyyy" />
									<sf:input 
										value="${dateString}"
										path="dataPrevisaoFim" 
										class="form-control date"/>
								</div>
							</div>
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									<label for="data">Data real de término:</label>
									<fmt:formatDate value="${projeto.dataFim}" var="dateString" pattern="dd/MM/yyyy" />
									<sf:input 
										value="${dateString}"
										path="dataFim" 
										class="form-control data"/>
								</div>
							</div>
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									<label for="data">Orçamento total:</label>
									<sf:input path="orcamento" class="form-control"  aria-describedby="emailHelp"/>
								</div>
							</div>
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									 <label for="nome">Descrição:</label>
									<sf:input path="descricao" class="form-control"  aria-describedby="emailHelp"/>
								</div>
							</div>
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									 <label for="idade">Status:</label>
									<sf:select path="status" cssClass="form-control">
						                <sf:option value="${tipoStatus}" label="Selecione o status"/>
						                <sf:options items="${tipoStatus}" />
						            </sf:select>
								</div>
							</div>
							
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">					
								<div class="form-group">
									 <label for="idade">Grau de Risco:</label>
									<sf:select path="risco" cssClass="form-control">
						                <sf:option value="${tipoRisco}" label="Selecione o risco"/>
						                <sf:options items="${tipoRisco}" />
						            </sf:select>
								</div>
							</div>
							
					</div>

				</div>
				
				<div class="panel-footer text-right">
					<a class="btn btn-default" href="<s:url value="/" />" tabindex="-1">
						<fmt:message key="button.cancel"/>
					</a>
	
					<button class="btn btn-success" type="submit">
						<i class="fa fa-check"></i>
						<fmt:message key="button.save"/>
					</button>
				</div>
				
			</sf:form>
					
		</div>
	
	</div>
		
</section>

<ct:templateFooter />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostra Estudios</title>
</head>
<body>

	<h1>Mostra Todos os Estudios</h1>
	
	<a href="http://localhost:8080/estudiomusical/estudio?acao=cadastro"><button>Cadastrar Estudio</button></a>
	<br><br>
	
	<c:if test="${not empty estudios}">
		<table border="1" style="width: 90%">
			<thead>
				<tr style="color:black;background: red">
					<th>ID</th>
					<th>Nome</th>
					<th>Musicas Gravadas</th>
					<th>Taxa de Horas</th>
					<th colspan="5">Ação</th>
				</tr>
			</thead>
			</tbody>
				<c:forEach var="estudio" items="${estudios}">
					<tr>
						<td>${estudio.id}</td>
						<td>${estudio.nome}</td>
						<td>${estudio.musicasGravadas}</td>
						<td>${estudio.taxaHoras}</td>
						<td><a href="estudio?acao=agendarSessao&id=${estudio.id}">AGENDAR SESSÃO</a></td>
						<td><a href="estudio?acao=mixarMusica&id=${estudio.id}">MIXAR MUSICA</a></td>
						<td><a href="estudio?acao=calcularFaturamento&id=${estudio.id}">CALCULAR FATURAMENTO</a></td>
						<td><a href="estudio?acao=altera&id=${estudio.id}">ALTERAR</a></td>
						<td><a href="estudio?acao=exclui&id=${estudio.id}">EXCLUIR</a></td>
					</tr>

			
				</c:forEach>
			</tbody>	
		</table>	
	</c:if>
	<c:if test="${empty estudios}">
		<h1>Nenhum Estudio Cadastrado</h1>		
	</c:if>		
	
	<% String mensagem = request.getParameter("mensagem"); %>
		<c:if test="${not empty param.mensagem}">
  		  <p><%= mensagem %></p>
</c:if>		
</body>
</html>
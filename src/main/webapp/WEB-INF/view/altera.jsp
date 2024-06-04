<%@page import="modelo.Estudio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração Dados Estudio</title>


</head>


<body>

    <h1>Alteração Dados Estudio</h1>

    <form action="estudio" method="post">
        ID: <input type="text" name="txtid" value="${estudio.id }" readonly><br><br>
        Nome: <input type="text" name="txtnome" value="${estudio.nome }" ><br><br>
        Musicas Gravadas: <input type="text" name="txtmusicasGravadas" value="${estudio.musicasGravadas }" ><br><br>
        Taxa de Horas: <input type="text" name="txttaxaHoras" value="${estudio.taxaHoras }" ><br><br>
        <input type="hidden" name="acao" value="altera">
        <input type="submit" value="Alterar">
    </form>





</body>
</html>
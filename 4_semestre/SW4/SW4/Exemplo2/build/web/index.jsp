<%-- 
    Document   : index
    Created on : 18/08/2022, 21:35:35
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.LinkedList"/>
             
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Compras</title>
    </head>
    <body>
        <h1>Lsita de compras</h1>
        <form action="inserir">
            Item a comprar: <input type="text" name="item" size="30"/>
            Quantidade: <input type="number" name="quantidade"/>
            <input type="submit" value="Adicionar"/>
        </form><br/>
        
        <h2>Comprar:</h2>
        <c:forEach items="${lista}" var="produto">
            <span>${produto.descricao} - ${produto.quantidade}</span></br>
        </c:forEach>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 18/08/2022, 21:35:35
    Author     : André Luis Quiosi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.LinkedList"/>
<jsp:useBean id="msgErro" scope="session" class="java.lang.String"/>

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
        <c:if test="${not empty msgErro}">

            <div style="color:red;">
                ${msgErro}
            </div>

        </c:if>

        <h2>Comprar:</h2>
        <c:set var="idx" value="0"/>
        <table>
            <c:forEach items="${lista}" var="produto">

                <tr>
                    <td>${produto.descricao}</td>
                    <td>
                        <form action="alterar" method="POST">
                            <input type="number" name="qtd" value="${produto.quantidade}"/>
                            <input type="hidden" name="posicao" value="${idx}"/>
                            <input type="submit" value="Alterar"/>
                        </form>
                    </td>
                    <td>               
                        <form action="remover" method="POST">
                            <input type="hidden" name="posicao" value="${idx}"/>
                            <input type="submit" value="X"/>
                        </form>
                    </td>
                </tr>

                <c:set var="idx" value="${idx+1}"/>
            </c:forEach>
        </table>
        <c:remove var="msgErro" scope="session"/>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="recursos/css/styleGlobal.css">
        <link rel="stylesheet" href="recursos/css/estilo.css">
    </head>
    <body>
    <h1>
        <c:if test="${seminarios.id == 0}">Nuevo Registro</c:if>
        <c:if test="${seminarios.id != 0}">Editar Registro</c:if>      
    </h1>
    <form action="MainController" method="POST" class="formulario">
            <input type="hidden" name="id" value="${seminarios.id}">
            <label>Titulo:</label>
            <input type="text" name="titulo" placeholder="Titulo del Seminario" value="${seminarios.titulo}">
            <br>
            <label>Expositor:</label>
            <input type="text" name="expositor" placeholder="Nombre del Expositor" value="${seminarios.expositor}">
            <br>
            <label>Fecha: </label>
            <input type="text" name="fecha" placeholder="Feha del Seminario" value="${seminarios.fecha}">
            <br>
            <label>Hora: </label>
            <input type="text" name="hora" placeholder="Hora del Seminario" value="${seminarios.hora}">
            <br>
            <label>Cupo: </label>
            <input type="text" name="cupo" placeholder="Cupos del Seminario" value="${seminarios.cupo}">
            <br>
            <input class="botton" type="submit" value="Enviar">
        </form>
    </body>
</html>

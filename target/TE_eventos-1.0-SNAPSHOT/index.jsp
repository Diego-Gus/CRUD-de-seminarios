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
        <header class="cabezera">
            <div class="cabezera_inf">
                <div class="datos">
                    <p>SEGUNDO PARCIAL TEM-742</p>
                    <p><strong>Nombre: </strong>Diego Gustavo Chambi Quenta</p>
                    <p><strong>Carnet: </strong>12897299 L.P.</p>
                </div>
                <div><h1>Registro de Seminarios</h1></div>
            </div>
            <div class="cabezera_img">
                <img src="recursos/imagenes/sistemalogo.png" alt="">
            </div>
        </header>
        
        <div class="contenido">
            <p class="enlaces"><a href="MainController?accion=nuevo">Nuevo Registro</a></p>
            <table border="0" cellspacing="0">
                <tr>
                    <th>Id</th>
                    <th>TITULO</th>
                    <th>EXPOSITOR</th>
                    <th>FECHA</th>
                    <th>HORA</th>
                    <th>CUPOS</th>
                    <th colspan="2">ACCIONES</th>
                </tr>
                <c:forEach var="item" items="${seminarios}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.expositor}</td>
                        <td>${item.fecha}</td>
                        <td>${item.hora}</td>
                        <td>${item.cupo}</td>
                        <td class="centrado"><a href="MainController?accion=editar&id=${item.id}" class="enlaces">Editar</a></td>
                        <td class="centrado"><a href="MainController?accion=eliminar&id=${item.id}" class="enlaces" onclick="return(confirm('Estas seguro de eliminar el seminario'))">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
    </body>
</html>

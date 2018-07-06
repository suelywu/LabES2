<%@ page import="api.modelo.Pedido" %>
<%@ page import="java.util.List" %><
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Pedido> pedidos = (List<Pedido>) request.getSession().getAttribute("listPedidos");
    String strPedId = "Pedido ";
%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/home.css">
    <script type="text/javascript" src="static/js/home.js"></script>
</head>
<body>
<div class="main-container">
    <div class="tab">
        <button id="aba-orcamentos" class="botao">Orçamentos</button>
        <button id="aba-pedidos" class="botao">Pedidos</button>
    </div>
    <div class="conteudos">

        <div class="conteudo" id="cont-orcamentos">
            <div id="div-orcamentos-main-container">
                <h1 class="page-title">Orçamentos</h1>
                <div id="div-orcamentos">
                    <br>
                    <ul>
                        <li> <a href="#">Orçamento 1</a>
                        </li>
                    </ul>
                    <br>
                </div>
                <button id="btn-registrar-orcamento">Registrar novo orçamento</button>
            </div>
        </div>

        <div class="conteudo" id="cont-pedidos">
            <div id="div-pedidos-main-container">
                <h1 class="page-title">Pedidos</h1>
                <div id="div-pedidos">
                    <br>
                    <ul>
                        <%
                            for (Pedido p : pedidos) {%>
                        <li>
                            <a href="pedido<%="?id="+p.getId()%>"><%=strPedId + p.getId()%></a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                    <br>
                </div>
                <form action="addPedido" method="get">
                    <input type="submit" value="Registrar novo pedido">
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>

<%@ page import="api.modelo.Pedido" %>
<%@ page import="api.modelo.Material" %>
<%@ page import="api.modelo.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    double valorTotal = 0;
    Pedido pedido = (Pedido) request.getAttribute("pedido");
    List<Material> materiais = pedido.getMateriais();
    double materiaisPreco = 0;
    for (Material m : materiais) {
        valorTotal += m.getPreco();
        materiaisPreco += m.getPreco();
    }
    valorTotal += pedido.getMaoDeObra();
    valorTotal -= pedido.getDesconto();
    Cliente cliente = pedido.getCliente();
    System.out.println(pedido);
%>

<html>
<head>
    <title>Pedido</title>
    <link rel="stylesheet" href="static/css/pedido.css">
    <link rel="stylesheet" href="static/css/base.css">
    <script type="text/javascript" src="static/js/pedido.js"></script>
</head>
<body>
<div id="main-content">
    <h1 class="page-title">Pedido <%=pedido.getId()%></h1>
    <div id="pedido-content" >
        <ul>
            <li>
                <label class="col1">Cliente: </label>
                <label><%=cliente.getNome()%></label>
            </li>
            <li>
                <label class="col1">Materiais: R$<%=materiaisPreco%></label>
                <ul>
                    <%
                        for (Material m : materiais) { %>
                    <li>
                        <%=m.getDescricao()%>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </li>
            <li>
                <label class="col1">Mão de Obra: </label>
                <label id="lbl-valor">R$ <%=pedido.getMaoDeObra()%></label>
            </li>
            <li>
                <label class="col1">Desconto: </label>
                <label id="lbl-desconto">R$ <%=pedido.getDesconto()%></label>
            </li>
            <li>
                <label class="col1">Total: </label><label>R$ <%=valorTotal%></label>
            </li>
            <li>
                <label class="col1">Forma Pagamento: <%=pedido.getFormPag().getForma()%></label>

            </li>
            <li>
                <label class="col1">Tipo Pagamento: <%=pedido.getTipoPag().getTipo()%></label>

            </li>
            <li>
                <label class="col1">Parcelas: <%=pedido.getQtdParcelas()%></label>
            </li>
            <li>

                <form action="home" method="post">
                    <input type="hidden" name="form-delete-pedido">
                    <% request.getSession().setAttribute("pedId", pedido.getId());%>
                    <input type="submit" value="Deletar">
                </form>
                <form action="/editarPedido<%="?id="+pedido.getId()%>" method="get">
                    <% session.setAttribute("pedId", pedido.getId());%>
                    <input type="submit" value="Editar">
                </form>
                <button id="btn-imprimir">Imprimir</button>
                <button id="btn-voltar">Voltar</button>
            </li>
        </ul>
    </div>
</div>
</body>
</html>

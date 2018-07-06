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
%>

<html>
<head>
    <title>Editar Pedido</title>
    <link rel="stylesheet" href="static/css/base.css">
</head>
<body>
<h1 class="page-title">Editar Pedido <%=pedido.getId()%></h1>
<form action="/home" method="post">
    <input type="hidden" name="form-edit-pedido">
    <ul>
        <li>
            <label class="col1">Cliente: </label>
            <label class="col2"><input type="text" value="<%=cliente.getNome()%>" name="nome-cliente"></label>
        </li>
        <li>
            <label class="col1">Materiais: R$ <%=materiaisPreco%></label>
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
            <label class="col1">Mão de Obra: R$ </label>
            <label class="col2"><input type="text" value="<%=pedido.getMaoDeObra()%>" name="mao-de-obra"></label>
        </li>
        <li>
            <label class="col1">Desconto: R$ </label>
            <label class="col2"><input type="text" value="<%=pedido.getDesconto()%>" name="desconto"></label>
        </li>
        <li>
            <label class="col1">Total: R$</label>
            <label class="col2"> </label><label id="lbl-total">R$ <%=valorTotal%></label>
        </li>
        <li>
            <label class="col1">Forma Pagamento:
                <select class="col2" id="sel-forma-pagamento" name="select-form-pag">
                    <option value="dinheiro" selected="
                    <%if (pedido.getFormPag().getForma().equalsIgnoreCase("dinheiro")){
                        out.print("selected");
                    }%>">Dinheiro</option>
                    <option value="cartao-de-credito" selected="
                    <%if (pedido.getFormPag().getForma().equalsIgnoreCase("cartao de credito")){
                        out.print("selected");
                    }%>">Cartão de Crédito</option>
                </select>
            </label>
        </li>
        <li>
            <label class="col1">Tipo Pagamento:
                <select class="col2" id="sel-tipo-pagamento" name="select-tipo-pag">
                    <option value="parcelado" selected="
                <%if (pedido.getTipoPag().getTipo().equalsIgnoreCase("parcelado")) {
                    out.print("selected");
                }
                %>">Parcelado</option>
                    <option value="a-vista" selected="
                <%if (pedido.getTipoPag().getTipo().equalsIgnoreCase("a vista")) {
                    out.print("selected");
                }
                %>">À vista</option>
                </select>

            </label>
            <label><span id="span-parcelado"><input type="number" name="qtd-parcelas"
                                                    value="<%=pedido.getQtdParcelas()%>"/>vezes</span></label>

        </li>

    </ul>
    <%
        session.setAttribute("pedido", pedido);
    %>
    <input type="submit" value="Salvar">
</form>
<button id="btn-voltar">Voltar</button>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="api.modelo.Material" %>
<%@ page import="api.modelo.Cliente" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int nextId = (int) request.getAttribute("nextId");

%>
<html>
<head>
    <title>Registrar Pedido</title>
    <script type="text/javascript" src="js/newPedido.js"></script>
</head>
<body>
<div id="main-container">
    <h1> Novo Pedido </h1>
    <form action="home" name="form-registrar-pedido" method="post" id="form-registrar-pedido">
        <input type="hidden" name="form-registrar-pedido">
        <ul>
            <li>
                <label>Cliente: <input type="text" name="nome-cliente"/></label>
            </li>
            <li>
                <label>Materiais: <input type="submit" value="Adicionar"/></label>
            </li>
            <li>
                <label>Mão de Obra: R$ <input type="text" name="mao-de-obra" id="inp-mao-de-obra"></label>
            </li>
            <li>
                <label>Desconto: R$ <input type="text" name="desconto" id="inp-desconto"></label>
            </li>
            <li>
                <label>Total: R$ </label>
                <label id="lbl-valor"></label>
            </li>
            <li>
                <label>Forma Pagamento:
                    <select id="sel-forma-pagamento" name="select-form-pag">
                        <option value="dinheiro">Dinheiro</option>
                        <option value="cartao-de-credito">Cartão de Crédito</option>
                    </select>
                </label>
            </li>
            <li>
                <label>Tipo Pagamento:
                    <select id="sel-tipo-pagamento" name="select-tipo-pag">
                        <option value="parcelado">Parcelado</option>
                        <option value="a-vista">À vista</option>
                    </select>
                    <label><span id="span-parcelado"><input type="number" name="qtd-parcelas"/>vezes</span></label>
                </label>

            </li>
        </ul>
        <input type="submit" value="Registrar">
        <button type="button" id="btn-cancelar">Cancelar</button>

    </form>
</div>
</body>
</html>

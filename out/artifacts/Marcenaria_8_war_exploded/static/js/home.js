window.onload = function(){
    var abaOrcamentos = document.getElementById('aba-orcamentos');
    var abaPedidos = document.getElementById('aba-pedidos');
    var contOrcamentos = document.getElementById('cont-orcamentos');
    var contPedidos = document.getElementById('cont-pedidos');
    var btnRegOrcamento = document.getElementById("btn-registrar-orcamento");
    var btnRegPedido = document.getElementById("btn-registrar-pedido");

    contOrcamentos.classList.add('invisivel');
    contPedidos.classList.add('invisivel');

    abaOrcamentos.onclick = function(){
        serEscolhido(abaOrcamentos);
        naoSerEscolhido(abaPedidos);
        ficarVisivel(contOrcamentos);
        ficarInvisivel(contPedidos);
    };

    abaPedidos.onclick = function(){
        serEscolhido(abaPedidos);
        naoSerEscolhido(abaOrcamentos);
        ficarVisivel(contPedidos);
        ficarInvisivel(contOrcamentos);
    };

    btnRegOrcamento.onclick = function() {
        pathNewOrcamento = "newOrcamento.html";
        window.location.href = pathNewOrcamento;
    };

    btnRegPedido.onclick = function() {
        pathNewPedido = "newPedido.html";
        window.location.href = pathNewPedido;
    };

    var divOrcamentos = document.getElementById('div-orcamentos');
    var orcamento1 = divOrcamentos.getElementsByTagName('li')[0];
    orcamento1.onclick = function() {
        pathOrcamento = "orcamento.html";
        window.location.href = pathOrcamento;
    };

    var divPedidos = document.getElementById('div-pedidos');
    var pedido1 = divPedidos.getElementsByTagName('li')[0];
    pedido1.onclick = function() {
        pathPedido = "pedido.html";
        window.location.href = pathPedido;
    };


};

function ficarVisivel(element) {
    element.classList.remove("invisivel");
    element.classList.add("visivel");
}

function ficarInvisivel(element) {
    element.classList.remove("visivel");
    element.classList.add("invisivel");
}

function serEscolhido(element) {
    element.classList.remove("nao-escolhido");
    element.classList.add("escolhido");
}

function naoSerEscolhido(element) {
    element.classList.remove("escolhido");
    element.classList.add("nao-escolhido");
}
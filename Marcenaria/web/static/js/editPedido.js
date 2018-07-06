window.onload = function() {
    var spanParc = document.getElementById("span-parcelado");
    spanParc.classList.add("invisivel");

    var tipoPagamento = document.getElementById("sel-tipo-pagamento");
    tipoPagamento.onchange = function() {
        if (tipoPagamento.value === "parcelado") {
            ficarVisivel(spanParc);
        } else {
            ficarInvisivel(spanParc);
        }
    };

    var btnVoltar = document.getElementById("btn-voltar");
    var pathRegistrar = "";
    var pathCancelar = "";

    btnVoltar.onclick = function() {
        window.history.back();
    };

    var inputMaoDeObra = document.getElementById("inp-mao-de-obra");
    var inputDesconto = document.getElementById("inp-desconto");
    var lblValor = document.getElementById("lbl-valor");
    inputDesconto.onfocus = function (ev) {
        this.oldValue = this.value;
    }
    inputDesconto.onchange = function (ev) {
        var valorTotal = parseFloat(lblValor.textContent);
        valorTotal -= parseFloat(this.oldValue);
        valorTotal += parseFloat(this.value);
        lblValor.textContent = valorTotal;
        this.oldValue = this.value;
    }
    inputMaoDeObra.onfocus = function (ev) {
        this.oldValue = this.value;
    }
    inputMaoDeObra.onchange = function (ev) {
        var valorTotal = parseFloat(lblValor.textContent);
        valorTotal -= parseFloat(this.oldValue);
        valorTotal += parseFloat(this.value);
        lblValor.textContent = valorTotal;
        this.oldValue = this.value;
    }


};

function ficarVisivel(element) {
    element.classList.remove("invisivel");
    element.classList.add("visivel");
}

function ficarInvisivel(element) {
    element.classList.remove("visivel");
    element.classList.add("invisivel");
}
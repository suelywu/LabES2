window.onload = function() {
    var btnVoltar = document.getElementById('btn-voltar');

    btnVoltar.onclick = function() {
        window.history.back();
    };

    var btnImprimir = document.getElementById('btn-imprimir');
    btnImprimir.onclick = function() {
        window.print();
    };
};
package web.servlet;

import api.modelo.Pedido;
import api.servico.PedidoServico;
import core.servico.PedidoServicoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletPedido")
public class ServletPedido extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        short pedId = (short) Integer.parseInt(request.getParameter("id"));
        PedidoServico pedidoServico = new PedidoServicoImpl();
        Pedido pedido = pedidoServico.findById(pedId);
        request.setAttribute("pedido", pedido);
        request.getRequestDispatcher("/pedido.jsp").forward(request, response);
    }
}

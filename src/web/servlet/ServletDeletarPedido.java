package web.servlet;

import api.servico.PedidoServico;
import core.servico.PedidoServicoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeletarPedido")
public class ServletDeletarPedido extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        short pedId = (short) request.getSession().getAttribute("pedId");
        PedidoServico pServico = new PedidoServicoImpl();
        pServico.deleteById(pedId);
        response.sendRedirect("/home.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

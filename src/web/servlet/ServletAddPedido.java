package web.servlet;

import api.modelo.Cliente;
import api.modelo.Pedido;
import api.servico.ClienteServico;
import api.servico.PedidoServico;
import core.servico.ClienteServicoImpl;
import core.servico.PedidoServicoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAddPedido")
public class ServletAddPedido extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PedidoServico pedidoServico = new PedidoServicoImpl();
        int nextId = pedidoServico.getNextId();
        request.setAttribute("nextId", nextId);
        request.getRequestDispatcher("/addPedido.jsp").forward(request, response);
    }
}

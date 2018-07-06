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

@WebServlet(name = "ServletEditPedido")
public class ServletEditPedido extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("pedId"));

        short pedId = (short) request.getSession().getAttribute("pedId");
        PedidoServico pServico = new PedidoServicoImpl();
        Pedido pedido = pServico.findById((short) pedId);

        request.setAttribute("pedido", pedido);
        request.getRequestDispatcher("/editPedido.jsp").forward(request, response);

    }
}

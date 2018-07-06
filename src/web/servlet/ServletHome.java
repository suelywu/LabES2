package web.servlet;

import api.modelo.Cliente;
import api.modelo.Criptografia;
import api.modelo.Pedido;
import api.modelo.Usuario;
import api.servico.ClienteServico;
import api.servico.PedidoServico;
import api.servico.UsuarioServico;
import core.servico.ClienteServicoImpl;
import core.servico.PedidoServicoImpl;
import core.servico.UsuarioServicoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletHome")
public class ServletHome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("form-edit-pedido") != null) {
            String nomeCliente = request.getParameter("nome-cliente");
            String maoDeObra = request.getParameter("mao-de-obra");
            String desconto = request.getParameter("desconto");
            String formPag = request.getParameter("select-form-pag");
            String tipoPag = request.getParameter("select-tipo-pag");
            String qtdPacelas = request.getParameter("qtd-parcelas");

            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");


            PedidoServico pedidoServico = new PedidoServicoImpl();
            ClienteServico clienteServico = new ClienteServicoImpl();

            Cliente cliente = clienteServico.findByCliNome(nomeCliente).get(0);//Suely
            if (cliente.getId() > 0) {
                pedido.setDesconto(Double.parseDouble(desconto));
                pedido.setMaoDeObra(Double.parseDouble(maoDeObra));
                if (formPag.equalsIgnoreCase("Cartão de Crédito")) {
                    pedido.setFormPagId((byte) 1);
                } else {
                    pedido.setFormPagId((byte) 2);
                }
                if (tipoPag.equalsIgnoreCase("Parcelado")) {
                    pedido.setTipoPagId((byte) 1);
                } else {
                    pedido.setTipoPagId((byte) 2);
                }
                pedido.setQtdParcelas(Integer.parseInt(qtdPacelas));
                pedido.setCliId(cliente.getId());
                pedidoServico.update(pedido);


                List<Pedido> pedidos = pedidoServico.findAll();
                request.setAttribute("listPedidos", pedidos);
                request.getSession().setAttribute("listPedidos", pedidos);
                response.sendRedirect("/home.jsp");
            }
        } else if (request.getParameter("form-registrar-pedido") != null){
            System.out.println("entrou no post ");
            String nomeCliente = request.getParameter("nome-cliente");
            String maoDeObra = request.getParameter("mao-de-obra");
            String desconto = request.getParameter("desconto");
            String formPag = request.getParameter("select-form-pag");
            String tipoPag = request.getParameter("select-tipo-pag");
            String qtdPacelas = request.getParameter("qtd-parcelas");
            PedidoServico pedidoServico = new PedidoServicoImpl();
            ClienteServico clienteServico = new ClienteServicoImpl();
            Cliente cliente = clienteServico.findByCliNome(nomeCliente).get(0);//Suely
            if (cliente.getId() > 0) {
                Pedido pedido = new Pedido();
                pedido.setDesconto(Double.parseDouble(desconto));
                pedido.setMaoDeObra(Double.parseDouble(maoDeObra));
                if (formPag.equalsIgnoreCase("Cartão de Crédito")) {
                    pedido.setFormPagId((byte) 1);
                } else {
                    pedido.setFormPagId((byte) 2);
                }
                if (tipoPag.equalsIgnoreCase("Parcelado")) {
                    pedido.setTipoPagId((byte) 1);
                } else {
                    pedido.setTipoPagId((byte) 2);
                }
                pedido.setQtdParcelas(Integer.parseInt(qtdPacelas));
                pedido.setCliId(cliente.getId());
                pedidoServico.insert(pedido);

                List<Pedido> pedidos = pedidoServico.findAll();
                request.setAttribute("listPedidos", pedidos);
                request.getSession().setAttribute("listPedidos", pedidos);
                response.sendRedirect("/home.jsp");
            }
        } else if (request.getParameter("form-delete-pedido") != null) {
            short pedId = (short) request.getSession().getAttribute("pedId");
            PedidoServico pServico = new PedidoServicoImpl();
            pServico.deleteById(pedId);

            PedidoServico pedidoServico = new PedidoServicoImpl();
            List<Pedido> pedidos = pedidoServico.findAll();
            request.setAttribute("listPedidos", pedidos);
            request.getSession().setAttribute("listPedidos", pedidos);
            response.sendRedirect("/home.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioServico usuarioServico = new UsuarioServicoImpl();
        String nomeUsuario = request.getParameter("nome-usuario");
        String senha = request.getParameter("senha");
        Criptografia criptografia = new Criptografia();
        String senhaC = criptografia.criptografar(senha);
        Usuario u = usuarioServico.findByNomeUsuario(nomeUsuario);
        if (u.getSenha().equals(senhaC)) {
            PedidoServico pedidoServico = new PedidoServicoImpl();
            List<Pedido> pedidos = pedidoServico.findAll();
            request.setAttribute("listPedidos", pedidos);
            request.getSession().setAttribute("listPedidos", pedidos);
            response.sendRedirect("/home.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuario e/ou senha incorreta! Tente novamente!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}

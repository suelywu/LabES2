package web.servlet;

import api.modelo.Criptografia;
import api.modelo.Usuario;
import api.servico.UsuarioServico;
import core.servico.UsuarioServicoImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/login.jsp");


    }
}

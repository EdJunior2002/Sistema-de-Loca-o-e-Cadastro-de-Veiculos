package com.locadora;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ClienteServlet extends HttpServlet {
    private static List<Cliente> clientes = CadastrarClienteServlet.clientes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-BR'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Lista de Clientes</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Lista de Clientes Cadastrados</h1>");
        out.println("<table>");
        out.println("<tr><th>Nome</th><th>Endereço</th><th>Telefone</th><th>Email</th></tr>");

        for (Cliente cliente : clientes) {
            out.println("<tr>");
            out.println("<td>" + cliente.getNome() + "</td>");
            out.println("<td>" + cliente.getEndereco() + "</td>");
            out.println("<td>" + cliente.getTelefone() + "</td>");
            out.println("<td>" + cliente.getEmail() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='index.html'>Voltar ao Menu</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

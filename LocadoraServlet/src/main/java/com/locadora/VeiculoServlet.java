package com.locadora;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class VeiculoServlet extends HttpServlet {
    private static List<Veiculo> veiculos = CadastrarVeiculoServlet.veiculos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-BR'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Lista de Veículos</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Lista de Veículos Cadastrados</h1>");
        out.println("<table>");
        out.println("<tr><th>Marca</th><th>Modelo</th><th>Ano</th><th>Cor</th><th>Placa</th></tr>");

        for (Veiculo veiculo : veiculos) {
            out.println("<tr>");
            out.println("<td>" + veiculo.getMarca() + "</td>");
            out.println("<td>" + veiculo.getModelo() + "</td>");
            out.println("<td>" + veiculo.getAno() + "</td>");
            out.println("<td>" + veiculo.getCor() + "</td>");
            out.println("<td>" + veiculo.getPlaca() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='index.html'>Voltar ao Menu</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

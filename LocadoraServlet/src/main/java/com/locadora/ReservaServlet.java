package com.locadora;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReservaServlet extends HttpServlet {
    private static List<Reserva> reservas = CadastrarReservaServlet.reservas;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-BR'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Lista de Reservas</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Lista de Reservas</h1>");
        out.println("<table>");
        out.println("<tr><th>Cliente</th><th>Veículo</th><th>Data Início</th><th>Data Fim</th></tr>");

        for (Reserva reserva : reservas) {
            out.println("<tr>");
            out.println("<td>" + reserva.getCliente() + "</td>");
            out.println("<td>" + reserva.getVeiculo() + "</td>");
            out.println("<td>" + reserva.getDataInicio() + "</td>");
            out.println("<td>" + reserva.getDataFim() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='index.html'>Voltar ao Menu</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

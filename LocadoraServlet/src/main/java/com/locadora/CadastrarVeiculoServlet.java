package com.locadora;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastrarVeiculoServlet extends HttpServlet {
    static List<Veiculo> veiculos = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String cor = request.getParameter("cor");
        String placa = request.getParameter("placa");

        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, placa);
        veiculos.add(veiculo);

        // Redireciona para a página de visualização de veículos
        response.sendRedirect("veiculos");
    }
}

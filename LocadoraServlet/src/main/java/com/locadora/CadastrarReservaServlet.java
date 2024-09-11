package com.locadora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarReservaServlet extends HttpServlet {
    static List<Reserva> reservas = new ArrayList<>();
    private static List<Cliente> clientes = CadastrarClienteServlet.clientes;
    private static List<Veiculo> veiculos = CadastrarVeiculoServlet.veiculos;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteNome = request.getParameter("cliente");
        String veiculoPlaca = request.getParameter("veiculo");
        String dataInicio = request.getParameter("dataInicio");
        String dataFim = request.getParameter("dataFim");

        // Verificar se o cliente está cadastrado
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equals(clienteNome))
                .findFirst()
                .orElse(null);

        // Verificar se o veículo está cadastrado
        Veiculo veiculo = veiculos.stream()
                .filter(v -> v.getPlaca().equals(veiculoPlaca))
                .findFirst()
                .orElse(null);

        if (cliente == null || veiculo == null) {
            // Cliente ou veículo não cadastrado
            request.setAttribute("mensagem", "Cliente ou veículo não cadastrado.");
            request.getRequestDispatcher("/reservar.html").forward(request, response);
            return;
        }

        // Verificar se o veículo está disponível
        boolean veiculoDisponivel = reservas.stream()
                .filter(r -> r.getVeiculo().equals(veiculoPlaca))
                .noneMatch(r -> (dataInicio.compareTo(r.getDataFim()) <= 0 && dataFim.compareTo(r.getDataInicio()) >= 0));

        if (!veiculoDisponivel) {
            // Veículo já está reservado no período solicitado
            request.setAttribute("mensagem", "Veículo não disponível para o período solicitado.");
            request.getRequestDispatcher("/reservar.html").forward(request, response);
            return;
        }

        // Adicionar reserva
        Reserva reserva = new Reserva(clienteNome, veiculoPlaca, dataInicio, dataFim);
        reservas.add(reserva);

        // Redirecionar para a página de visualização de reservas
        response.sendRedirect("reservas");
    }
}

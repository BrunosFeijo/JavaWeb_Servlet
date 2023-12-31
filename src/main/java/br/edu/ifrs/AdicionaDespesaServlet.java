package br.edu.ifrs;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/adicionaDespesa")
public class AdicionaDespesaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String dataStr = request.getParameter("data");
        String valorStr = request.getParameter("valor");
        String categoriaStr = request.getParameter("categoria");

        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        double valor = Double.parseDouble(valorStr);
        Categoria categoria = Categoria.valueOf(categoriaStr);

        Despesa despesa = new Despesa(descricao,data,valor,categoria);
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao = new DespesaDAO(connection);
        dao.save(despesa);

        PrintWriter out = response.getWriter();
        out.println("<html><body>Despesa adicionada com sucesso</body></html>");

    }
}

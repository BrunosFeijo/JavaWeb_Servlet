package br.edu.ifrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/segundaServlet")
@WebServlet(urlPatterns = {"/xpto", "/teste", "terceiraServlet"})
public class PrimeiraServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Primeira Página da nossa aplicação Web! Usando Servlet</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }
}

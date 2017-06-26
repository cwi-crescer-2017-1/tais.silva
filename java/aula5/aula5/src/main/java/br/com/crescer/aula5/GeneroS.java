package br.com.crescer.aula5;

import br.com.crescer.aula4.tema.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author carloshenrique
 */
@WebServlet(name = "genero", urlPatterns = "/genero")
public class GeneroS extends HttpServlet {

    @EJB
    private GeneroBean generoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final List<Genero> list = generoBean.findAll();

        try (final PrintWriter out = resp.getWriter()) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<form action=\"/aula5/genero\" method=\"POST\">\n");
            out.append(" <input name=\"nome\" autofocus/>\n");
            out.append(" <input type=\"submit\" value=\"Enviar\" />    \n");
            out.append("</form>");

            out.append("<table class=\"table table-hover\"><thead><tr><th>Genero</th></tr></thead><tbody>");
            list.forEach(genero -> out.append("<tr><td>").append(genero.getDescricao()).append("</td></tr>"));
            out.append("</tbody></table>");

            out.append("</body>");
            out.append("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
//            final GeneroDao generoDao = new GeneroDaoImpl(entityManager);
            final Genero genero = new Genero();
            genero.setDescricao(nome);
            generoBean.save(genero);
        }
        resp.sendRedirect("/aula5/genero");
    }

}

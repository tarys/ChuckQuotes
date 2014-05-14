package ua.kpi.fpm.pma.oop.chuckquotes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChuckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final QuotesRegistry quotesRegistry = (QuotesRegistry) getServletContext().getAttribute("quotesRegistry");
        if (request.getParameter("command").equals("remove")) {
            quotesRegistry.remove(Integer.parseInt(request.getParameter("quote_index")));
            getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
        } else if (request.getParameter("command").equals("edit")) {
            final Quote quoteToEdit = quotesRegistry.get(Integer.parseInt(request.getParameter("quote_index")));
            request.setAttribute("quoteToEdit", quoteToEdit);
            getServletContext().getRequestDispatcher("/edit_quote.jsp").forward(request, response);
        } else if (request.getParameter("command").equals("confirm_edit")) {
            final Quote quoteToEdit = quotesRegistry.get(Integer.parseInt(request.getParameter("quote_index")));
            quoteToEdit.setText(request.getParameter("quote_text"));
            getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
        } else if (request.getParameter("command").equals("cancel_edit")) {
            getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
        }
    }
}

package ua.jug.chuckquotes;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.Quote;
import ua.jug.chuckquotes.quote.QuotesRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChuckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuotesRegistry quotesRegistry = (QuotesRegistry) getServletContext().getAttribute("quotesRegistry");
        if (quotesRegistry == null) {
            quotesRegistry = QuotesRegistry.getInstance();
            getServletContext().setAttribute("quotesRegistry", quotesRegistry);
        }
        final String command = request.getParameter("command");
        if (command == null) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        } else {
            try {
                switch (command) {
                    case "next_quote": {
                        request.setAttribute("quote", quotesRegistry.getNextQuote());
                        getServletContext().getRequestDispatcher("/quote.jsp").forward(request, response);
                        break;
                    }
                    case "add": {
                        getServletContext().getRequestDispatcher("/add_quote.jsp").forward(request, response);
                        break;
                    }
                    case "confirm_add": {
                        quotesRegistry.add(request.getParameter("quote_text"));
                        getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                        break;
                    }
                    case "cancel_add": {
                        getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                        break;
                    }
                    case "remove": {
                        quotesRegistry.remove(Integer.parseInt(request.getParameter("quote_index")));
                        getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                        break;
                    }
                    case "edit": {
                        final Quote quoteToEdit = quotesRegistry.get(Integer.parseInt(request.getParameter("quote_index")));
                        request.setAttribute("quoteToEdit", quoteToEdit);
                        getServletContext().getRequestDispatcher("/edit_quote.jsp").forward(request, response);
                        break;
                    }
                    case "confirm_edit": {
                        final Quote quoteToEdit = quotesRegistry.get(Integer.parseInt(request.getParameter("quote_index")));
                        quoteToEdit.setText(request.getParameter("quote_text"));
                        getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                        break;
                    }
                    case "cancel_edit": {
                        getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                        break;
                    }
                    default: {
                        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                        break;
                    }
                }
            } catch (QuoteException e) {
                e.printStackTrace();
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
    }

}

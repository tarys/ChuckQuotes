package ua.kpi.fpm.pma.oop.chuckquotes;

import ua.kpi.fpm.pma.oop.chuckquotes.exceptions.UserNotExistException;
import ua.kpi.fpm.pma.oop.chuckquotes.quote.QuotesRegistry;
import ua.kpi.fpm.pma.oop.chuckquotes.user.UserRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserRegistry userRegistry;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userRegistry = new UserRegistry();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String command = request.getParameter("command");
        if (command == null) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        } else {
            switch (command) {
                case "login": {
                    final String username = request.getParameter("username");
                    final String password = request.getParameter("password");
                    try {
                        if (userRegistry.authenticate(username, password)) {
                            final HttpSession session = HttpServletRequest.class.cast(request).getSession();
                            QuotesRegistry quotesRegistry = (QuotesRegistry) getServletContext().getAttribute("quotesRegistry");
                            if (quotesRegistry == null) {
                                quotesRegistry = new QuotesRegistry();
                                getServletContext().setAttribute("quotesRegistry", quotesRegistry);
                            }
                            session.setAttribute("user", userRegistry.getUser(username));
                            request.setAttribute("quote", quotesRegistry.getNextQuote());
                            if (username.equals("Chuck")) {
                                getServletContext().getRequestDispatcher("/chuck.jsp").forward(request, response);
                            } else {
                                getServletContext().getRequestDispatcher("/quote.jsp").forward(request, response);
                            }
                        } else {
                            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        }
                    } catch (UserNotExistException e) {
                        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                    break;
                }
                case "logout": {
                    request.getSession().invalidate();
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                    break;
                }
                default: {
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                    break;
                }
            }
        }
    }
}

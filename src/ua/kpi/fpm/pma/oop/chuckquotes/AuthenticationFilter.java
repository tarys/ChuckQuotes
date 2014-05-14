package ua.kpi.fpm.pma.oop.chuckquotes;

import ua.kpi.fpm.pma.oop.chuckquotes.dao.UserNotExistException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig;
    private UserRegistry userRegistry;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.userRegistry = new UserRegistry();
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpSession session = HttpServletRequest.class.cast(servletRequest).getSession();

        final User currentUser = User.class.cast(session.getAttribute("user"));
        final String command = servletRequest.getParameter("command");
        // TODO fix this crap
        if (currentUser == null) {
            filterConfig.getServletContext().getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else if (command.equals("login")) {
            final String username = servletRequest.getParameter("username");
            final String password = servletRequest.getParameter("password");
            if (currentUser.getName().equals(username) && currentUser.getPassword().equals(password)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                try {
                    if (userRegistry.authenticate(username, password)) {
                        session.setAttribute("user", userRegistry.getUser(username));
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        filterConfig.getServletContext().getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
                    }
                } catch (UserNotExistException e) {
                    filterConfig.getServletContext().getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
                }
            }
        } else {
            filterConfig.getServletContext().getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }


    }
}

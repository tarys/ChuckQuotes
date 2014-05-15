package ua.kpi.fpm.pma.oop.chuckquotes;

import ua.kpi.fpm.pma.oop.chuckquotes.user.User;
import ua.kpi.fpm.pma.oop.chuckquotes.user.UserRegistry;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChuckWatchDogFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = HttpServletRequest.class.cast(servletRequest);
        final HttpSession session = httpServletRequest.getSession();

        final User currentUser = User.class.cast(session.getAttribute("user"));
        if (currentUser != null && httpServletRequest.isRequestedSessionIdValid()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterConfig.getServletContext().getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }
}
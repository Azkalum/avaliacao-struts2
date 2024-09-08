package com.seuprojeto.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionTimeoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        if (session != null) {
            Long lastAccessTime = session.getLastAccessedTime();
            Integer tempoInatividade = (Integer) session.getAttribute("tempoInatividade");

            if (tempoInatividade != null) {
                long currentTime = System.currentTimeMillis();
                long timeout = tempoInatividade * 60 * 1000;

                if ((currentTime - lastAccessTime) > timeout) {
                    session.invalidate();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}

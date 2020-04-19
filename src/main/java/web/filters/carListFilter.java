package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/cars")
public class carListFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String language = req.getParameter("locale");
        String ruCar = "МАШИНЫ";
        String enCar = "CARS";
        try {
            if (language.equals("ru")) {
                session.setAttribute("cars", ruCar);
            } else {
                session.setAttribute("cars", enCar);
            }
        } catch (Exception e){
            session.setAttribute("cars", enCar);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cars");
        requestDispatcher.forward(req, res);
    }

    @Override
    public void destroy() {

    }
}

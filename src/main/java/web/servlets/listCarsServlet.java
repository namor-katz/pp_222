package web.servlets;

import web.models.Car;
import web.service.returnListCarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/fuck", name = "listCarsServlet")
public class listCarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        returnListCarsService rlc = new returnListCarsService();
        List<Car> listCars = null;

        try {
            listCars = rlc.getListCars();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("listCars", listCars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cars.jsp");
        requestDispatcher.forward(req, resp);
    }
}

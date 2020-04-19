package web.controller;

import web.models.Car;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import web.service.returnListCarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/cars")
public class CarsController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            HttpSession session = req.getSession();
            returnListCarsService rls = new returnListCarsService();
            List<Car> listCars = new LinkedList<>();
            String cars = (String) session.getAttribute("cars");

            try {
                listCars = rls.getListCars();
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("listCars", listCars);
            req.setAttribute("cars", cars);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/cars.jsp");
            requestDispatcher.forward(req, resp);
        }
}

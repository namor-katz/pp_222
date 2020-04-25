package web.controller;

import web.models.Car;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import web.service.CarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cars")
public class CarsController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            CarsService rls = new CarsService();
            List<Car> listCars = new LinkedList<>();

            String cars;
            String lang = req.getParameter("locale");
            try {
                if(lang.equals("ru")) {
                    cars = "МАШИНЫ";
                } else {
                    cars = "CARS";
                }
            } catch (Exception e) {
                cars = "CARS";
            }

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

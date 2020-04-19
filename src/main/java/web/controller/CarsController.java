package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.models.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import web.service.returnListCarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
//@RequestMapping("/")
@WebServlet(urlPatterns = "/cars")
public class CarsController extends HttpServlet {

/*
    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCars(ModelMap model) {
        System.out.println("я тестовый метод");

//        returnListCarsService rls = new returnListCarsService();
        List<Car> listCars = new LinkedList<>();
        listCars = rls.getListCars();

        return "cars";


    }
 */
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

            returnListCarsService rls = new returnListCarsService();
            List<Car> listCars = new LinkedList<>();

            try {
                listCars = rls.getListCars();
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("listCars", listCars);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/cars.jsp");
            requestDispatcher.forward(req, resp);
        }
}

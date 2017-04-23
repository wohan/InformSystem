package main.controllers;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import main.models.pojo.Buyer;
import main.service.BuyerService;
import main.service.BuyerServiceImpl;

/**
 * Created by admin on 23.04.2017.
 */
public class ListBuyer extends HttpServlet {

    private static BuyerService buyerService = new BuyerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("value", "Hello, buyer");

        List<Buyer> buyers = buyerService.getAll();

        req.setAttribute("buyers", buyers);

        getServletContext().getRequestDispatcher("/listBuyer.jsp")
                .forward(req, resp);
    }
}

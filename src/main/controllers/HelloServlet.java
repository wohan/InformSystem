package main.controllers;
import main.models.pojo.Buyer;
import main.service.BuyerService;
import main.service.BuyerServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 23.04.2017.
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = getServletContext()
//                .getRequestDispatcher("/login.jsp");
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");

//        PrintWriter out = resp.getWriter();
//        out.println("Hello Servlet Владимир!!!");
//        out.close();

        System.out.println("Hello Vov!");
            BuyerService buyerService = new BuyerServiceImpl();
            Buyer buyer = buyerService.getBuyer(1);
            //req.setAttribute("buyer", buyer.getUser_name());

            PrintWriter out1 = resp.getWriter();
            out1.println(buyer.getUser_name() + buyer.getId());
            out1.close();

            List<Buyer> buyers = buyerService.getAll();
            req.setAttribute("buyer", buyer.getUser_name());

            getServletContext().getRequestDispatcher("/")
                .forward(req, resp);

      // dispatcher.forward(req, resp);
    }
}

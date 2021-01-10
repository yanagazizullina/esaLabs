package servlets;

import beans.PlantBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @EJB
    private PlantBean plantsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("plantsList", plantsBean.findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/page.jsp");
        if (dispatcher != null){
            dispatcher.forward(request, response);
        }
    }
}

package controller;

import model.multiWorld.World;
import model.user.User;
import model.user.Wibu;
import repository.worldRepository.WorldRepository1;
import service.WorldService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "world", value = {"/world"})
public class WorldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "showCreateWorldForm":
                showCreateWorldForm(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "createWorld":
                createWorld(request,response);
                break;
        }
    }
    public void showCreateWorldForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/createWorldForm.jsp");
        dispatcher.forward(request, response);
    }
    public void createWorld(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String worldName = request.getParameter("worldName");
        String worldFantasy = request.getParameter("worldFantasy");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        int currentUserID = currentUser.getId();
        WorldService.createWorld(worldName,worldFantasy,currentUser,currentUserID);

        List<World> worldList = WorldRepository1.getListWorld();
        session.setAttribute("worldList",worldList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
        dispatcher.forward(request,response);
        
    }
}


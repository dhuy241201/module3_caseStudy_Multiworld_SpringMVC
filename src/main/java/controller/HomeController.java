package controller;

import model.multiWorld.World;
import repository.worldRepository.WorldRepository;
import repository.worldRepository.WorldRepository1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "home", value = {"/home"})

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List <World> worldList = new ArrayList<>();
//        ResultSet resultSet = WorldRepository.getAllWorld();
//            try {
//                while (resultSet.next()){
//                    String name = resultSet.getString("NAME");
//                    String fantasy = resultSet.getString("FANTASY");
//                    String author = resultSet.getString("AUTHOR");
//                    String dateCreate = resultSet.getString("DATE_CREATED");
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd / MMMMMMMMM / yyyy |  hh : mm : ss");
//                    String dateForShow = dateFormat.format(new Date(dateCreate));
//                    World world = new World(name,fantasy,author,dateForShow,0);
//                    worldList.add(world);
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        HttpSession session = request.getSession();
//        session.setAttribute("worldList",worldList);

        List<World> worldList = WorldRepository1.getListWorld();
        HttpSession session = request.getSession();
        session.setAttribute("worldList",worldList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

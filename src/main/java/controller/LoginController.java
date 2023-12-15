package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.multiWorld.World;
import model.user.User;
import repository.userRepository.UserRepository;
import repository.worldRepository.WorldRepository1;
import service.LoginService;
import service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", value = {"/login","","/"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "login":
                login(request,response);
                break;
            case "logout":
                logout(request,response);
                break;
        }

    }
    public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (UserRepository.getInstance().getUserByUserName(username) != null){
            user = LoginService.login(username,password);
            if (user != null){
                String currentUserHidePassword = UserService.hidePassword(user);
                String currentUserHideEmail = UserService.hideEmail(user);
                HttpSession session = request.getSession();
                session.setAttribute("currentUser",user);
                session.setAttribute("currentUserHidePassword",currentUserHidePassword);
                session.setAttribute("currentUserHideEmail",currentUserHideEmail);

                List<World> worldList = WorldRepository1.getListWorld();
                session.setAttribute("worldList",worldList);
                request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request,response);
            }else {
                request.setAttribute("loginMessage","Wrong information. Try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
                dispatcher.forward(request,response);
            }
        }else {
            request.setAttribute("loginMessage","Account doesn't existed. Try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
            dispatcher.forward(request,response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/login?action=logout");
    }
}

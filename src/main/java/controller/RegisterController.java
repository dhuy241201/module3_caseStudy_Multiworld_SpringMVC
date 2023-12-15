package controller;

import ulti.ValidateUlti;
import service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", value = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        boolean isUsernameValid = ValidateUlti.validate(username,"USERNAME");
        boolean isPasswordValid = ValidateUlti.validate(password,"PASSWORD");
        boolean isNameValid = ValidateUlti.validate(name,"NAME");
        boolean isEmailValid = ValidateUlti.validate(email,"EMAIL");

        if (isUsernameValid && isPasswordValid && isNameValid && isEmailValid){
            if (!RegisterService.register(username,password,name,email)){
                request.setAttribute("isRegisterSucceed",false);
                request.setAttribute("registerMessage","Username have been existed");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
                dispatcher.forward(request,response);
            }else {
                RegisterService.register(username,password,name,email);
                request.setAttribute("isRegisterSucceed",true);
                request.setAttribute("registerMessage","Register succeed. Let login");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
                dispatcher.forward(request,response);
            }
        }else {
            request.setAttribute("isRegisterSucceed",false);
            request.setAttribute("registerMessage","Wrong information");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
            dispatcher.forward(request,response);
        }
    }
}

package controller;

import model.user.User;
import repository.userRepository.UserRepository;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@WebServlet(name = "profile", value = {"/profile"})
@MultipartConfig()
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "showProfile":
                showProfile(request, response);
                break;
            case "showUpdateUserForm":
                showUpdateUserForm(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("updateUser")) {
            updateUser(request, response);
        }

    }

    private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/updateUserForm.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            int userId = ((User) session.getAttribute("currentUser")).getId();
            String username = ((User) session.getAttribute("currentUser")).getUsername();

            //Xử lý không đổi mật khẩu
            String currentPasswordInForm = request.getParameter("currentPassword");
            if (currentPasswordInForm.equals("")){
                currentPasswordInForm = ((User) session.getAttribute("currentUser")).getPassword();
            }
            //Xử lý không đổi mật khẩu
            String newPassword = request.getParameter("newPassword");
            if (newPassword.equals("")){
                newPassword = ((User) session.getAttribute("currentUser")).getPassword();
            }

            //Xử lý không đổi tên
            String newName = request.getParameter("name");
            if (newName.equals("")){
                newName = ((User) session.getAttribute("currentUser")).getName();
            }

            //Xử lý không đổi email
            String newEmail = request.getParameter("emailAddress");
            if (newEmail.equals("")){
                newEmail = ((User) session.getAttribute("currentUser")).getEmail();
            }

            //Xử lý validate
            boolean iscurrentPasswordInformValid = currentPasswordInForm.equals(((User) session.getAttribute("currentUser")).getPassword());
//            boolean isNewPasswordValid = ValidateUlti.validate(newPassword, "PASSWORD");
//            boolean isNewNameValid = ValidateUlti.validate(newName, "NAME");
//            boolean isNewEmailValid = ValidateUlti.validate(newEmail, "EMAIL");

            //Xử lý không đổi Avatar
            Part newAvatar = request.getPart("newAvatar");
            String avatarFileName;
            if (newAvatar != null) {
                String avatarURL = "D:/JOB/CODE - IJ/Module 3/Case_study_multiworld/src/main/webapp/static/userAvatar";
                avatarFileName = Paths.get(newAvatar.getSubmittedFileName()).getFileName().toString();
                newAvatar.write(avatarURL + "/" + avatarFileName);
            }else {
                avatarFileName = ((User) session.getAttribute("currentUser")).getAvatar();
            }

                if (iscurrentPasswordInformValid) {
                    User userTemp = new User(userId,newPassword,newName,newEmail,avatarFileName);
                    boolean isInsertUserSucceed = UserService.updateUser(userTemp);
                    if (isInsertUserSucceed){
                        User userAfterUpdate = UserRepository.getInstance().getUserByUserName(username);
                        session.setAttribute("currentUser",userAfterUpdate);
                        response.sendRedirect("/profile?action=showProfile");
                    }else {
                        request.setAttribute("updateProfileMessage", "Wrong information. Try again");
                        request.getRequestDispatcher("WEB-INF/view/updateUserForm.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("updateProfileMessage", "Wrong information. Try again");
                    request.getRequestDispatcher("WEB-INF/view/updateUserForm.jsp").forward(request, response);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

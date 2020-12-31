package Commands.Impl;

import Commands.Command;
import DAO.UserDAOImpl;
import Entity.UsersEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class CreateUser implements Command {
    private final UserDAOImpl userDAO = UserDAOImpl.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if ((name==null||"".equals(name))||(surname==null||"".equals(surname))){
            response.sendRedirect(request.getContextPath() + "/error");
        }

        UsersEntity user = new UsersEntity();
        user.setName(name);
        user.setSurname(surname);

        userDAO.save(user);

        response.sendRedirect(request.getContextPath() + "/");


    }
}

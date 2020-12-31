package Commands.Impl;

import Commands.Command;
import DAO.UserDAO;
import DAO.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToMain implements Command {
    private final UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userDAO.findAll());
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
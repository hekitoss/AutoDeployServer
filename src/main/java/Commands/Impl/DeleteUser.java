package Commands.Impl;

import Commands.Command;
import DAO.UserDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class DeleteUser implements Command {
    private final UserDAOImpl userDAO = UserDAOImpl.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        userDAO.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/");
    }
}

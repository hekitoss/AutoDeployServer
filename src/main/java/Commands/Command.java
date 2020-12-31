package Commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException;
}

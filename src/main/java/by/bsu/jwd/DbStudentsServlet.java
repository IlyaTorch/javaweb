package by.bsu.jwd;

import by.bsu.jwd.db.dao.mysql.MySQLUserDAO;
import by.bsu.jwd.db.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/db_students")
@MultipartConfig
public class DbStudentsServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FileDevicesServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processDbStudents(request, response);
        } catch (Exception e) {
            LOGGER.error("Something went wrong in POST");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            LOGGER.error(e.toString());
        }
    }

    private void processDbStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDTO> users = new MySQLUserDAO().getAllUsers();
        boolean status = !users.isEmpty();
        request.setAttribute("status", status);
        if (status) {
            request.setAttribute("users", users);
        }
        request.getRequestDispatcher("WEB-INF/view/result_students.jsp").forward(request, response);
    }
}

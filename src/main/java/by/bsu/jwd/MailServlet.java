package by.bsu.jwd;


import by.bsu.jwd.mail.MailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail")
@MultipartConfig
public class MailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MailSender mailSender = new MailSender();
        mailSender.sendEmail(
            request.getParameter("recipient"),
            request.getParameter("message")
        );
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

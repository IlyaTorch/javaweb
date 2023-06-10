package by.bsu.jwd;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/language")
@MultipartConfig
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> languages = Arrays.asList("en", "fr");
        String language = request.getParameter("language");
        boolean existLanguage = false;
        for(String lang: languages){
            if (language.equals(lang)){
                existLanguage = true;
            }
        }
        if (!existLanguage){
            session.setAttribute("language", "en");
        } else {
            session.setAttribute("language", language);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}

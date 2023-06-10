package by.bsu.jwd;

import by.bsu.jwd.exceptions.ParserException;
import by.bsu.jwd.parser.AbstractDeviceParser;
import by.bsu.jwd.parser.factory.ParserFactory;
import by.bsu.jwd.validation.ValidatorXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/file_devices")
@MultipartConfig
public class FileDevicesServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FileDevicesServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            LOGGER.error("Something went wrong in GET");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            LOGGER.error("Something went wrong in POST");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            LOGGER.error(e.toString());
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parserType = request.getParameter("parserType");

        Part part = request.getPart("file");
        boolean status = ValidatorXML.isValid(part.getInputStream());

        request.setAttribute("status", status);
        if (status) {
            try {
                AbstractDeviceParser parser = ParserFactory.getInstance().createDeviceParser(parserType);
                InputStream streamXml = part.getInputStream();
                parser.buildSetDevices(streamXml);
                request.setAttribute("devices", parser.getDevices());
                request.getRequestDispatcher("WEB-INF/view/result_devices.jsp").forward(request, response);
            } catch (ParserException e) {
                LOGGER.error("Error in servlet", e);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/view/result_devices.jsp").forward(request, response);
        }
    }
}

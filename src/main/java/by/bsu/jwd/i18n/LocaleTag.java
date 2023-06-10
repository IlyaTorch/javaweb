package by.bsu.jwd.i18n;


import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Custom tag for support i18n.
 * @author Ilya Torch
 */
public class LocaleTag extends TagSupport {


    private String value;

    public void setValue(String value){
        this.value= value;
    }

    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        String language = String.valueOf(session.getAttribute("language"));
        if (language.isEmpty() || language.equals(null) || language.equals("null")){
            language = "ru";
        }
        if (value!=null){
            Locale locale = new Locale(language);
            ResourceBundle rb = ResourceBundle.getBundle("resources", locale);
            JspWriter out = pageContext.getOut();
            try {
                out.println(rb.getString(value));
            } catch (IOException ignored) {
            }
        }
        return SKIP_BODY;
    }
}

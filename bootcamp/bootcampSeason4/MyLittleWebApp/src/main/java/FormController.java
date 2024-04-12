import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormController extends HttpServlet{



    Customer customer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");

        if(name != null){
            if (name.equals("")){
                resp.getWriter().println("invalid name");
                return;
            }

            resp.setContentType("text/html");
            resp.getWriter().printf("" +
                    "<html>" +
                    "<body>" +
                    "<h1> Hello %s</h1>" +
                    "   </body>" +
                    "</html>", name);

        } else {
            resp.getWriter().println("please enter a name");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        if (name == null || name.isEmpty()){
            resp.sendRedirect("/myform");
        } else {


            //print directly to client
            resp.getWriter().printf("Hello %s", name);

            //redirect to force client to GET request to url
            //resp.sendRedirect("/myform/login?username="+name);
        }
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}


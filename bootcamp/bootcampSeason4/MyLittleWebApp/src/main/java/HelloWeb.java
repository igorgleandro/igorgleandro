import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer customer = new Customer();
        customer.setCustomerNumber(1);
        customer.setName("Igor");
        customer.setEmail("igorgleandro@icloud.com");
        customer.setPhone(915668346);


        req.getSession().setAttribute("customer",customer);
        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/User.jsp");
        page1Dispatcher.forward(req, resp);

    }
}
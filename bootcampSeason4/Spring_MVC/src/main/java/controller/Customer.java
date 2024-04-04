package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServlet;

@Controller
public class Customer extends HttpServlet {
    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String showCard(Model model){

        Customer c = new Customer();
        c.setName("bob");
        c.setEmail("bob@gmail.com");

        model.addAttribute("c", c);

        return "customer";
    }

}

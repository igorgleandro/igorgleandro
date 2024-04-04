package org.academiadecodigo.bootcamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CustomerController {


    @RequestMapping(method = RequestMethod.GET, value = "api/hello")
    public ResponseEntity<String>  helloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("Hello " + str, HttpStatus.ACCEPTED);

    }

/*@RequestMapping(method = RequestMethod.GET, path = "/")
 public String showCustomer(Model model) {

        Customer customer = new Customer();


        customer.setId(1);
        customer.setFirstName("Rui");
        customer.setLastName("Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone("916668877");

        model.addAttribute("customer", customer);

        return "/index";
    }*/
}

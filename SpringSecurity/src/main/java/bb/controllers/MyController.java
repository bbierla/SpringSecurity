package bb.controllers;

import bb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bartosz on 07.07.16.
 */
@Controller
@RequestMapping(value = "/home")
public class MyController {

//    @RequestMapping(value = {"/myhello"}, method = RequestMethod.GET)
//    public ModelAndView welcome(){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("");
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> hello() {

        return new ResponseEntity<>("Hello Hello Hello from User!!!", HttpStatus.OK);
    }
    @RequestMapping(value = "/abcde", method = RequestMethod.GET)
    public ResponseEntity<?> abcde() {

        return new ResponseEntity<>("tryrtyjweryjetyj!!!", HttpStatus.OK);
    }
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getContactsPage(){
        /*Vital thing to contain both: Model and View*/
        ModelAndView modelAndView = new ModelAndView();
        /*data container */
        ModelMap map = new ModelMap();
        map.addAttribute("name", "Airika");
        map.addAttribute("age", "25");
        map.addAttribute("course", "Java");
        /*populating my ModelAndView*/
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String setContacts(@RequestParam String name,
                              @RequestParam String lastname,
                              @RequestParam int age,
                              Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("course", lastname);

        return "contact";
    }
}

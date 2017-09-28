package com.my.test.controller;

import com.my.test.dto.Spitter;
import com.my.test.dto.Spittle;
import com.my.test.service.itf.SpitterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Spitter spitter){

        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{userName}")
    public String showSpitterProfile(@PathVariable String userName, Model model){

        model.addAttribute("spitter", spitterRepository.findByUserName(userName));
        return "profile";
    }
}

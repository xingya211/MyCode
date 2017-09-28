package com.my.test.controller;

import com.my.test.dto.Spittle;
import com.my.test.service.itf.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SpittleController {

    private SpittleRepository spittleRepository;

    public SpittleController() {
        super();
    }

    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittle/spittles", method = RequestMethod.GET)
    public String spittles(Model model){

        List<Spittle> list = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute("spittleList", list);

        return "spittleList";
    }

    @RequestMapping(value = "/spittle/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable String spittleId, Model model){

        Spittle spittle = spittleRepository.findById(spittleId);
        model.addAttribute("spittle", spittle);

        return "spittleList";
    }
}

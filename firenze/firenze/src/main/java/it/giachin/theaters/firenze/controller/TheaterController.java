package it.giachin.theaters.firenze.controller;

import it.giachin.theaters.firenze.dto.response.TheaterRes;
import it.giachin.theaters.firenze.service.IService.ITheaterService;
import it.giachin.theaters.firenze.service.TheaterService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheaterController {

    @Autowired
    ITheaterService theaterService;
    @GetMapping("/v1/theater")
    public List<TheaterRes> GetTheaters(){
        return theaterService.GetAllTheater();
    }
}

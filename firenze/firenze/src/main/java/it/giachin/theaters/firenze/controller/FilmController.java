package it.giachin.theaters.firenze.controller;

import it.giachin.theaters.firenze.dto.response.FilmRes;
import it.giachin.theaters.firenze.service.IService.IFilmService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
public class FilmController {
    @Autowired
    IFilmService filmService;

    @GetMapping("/v1/allFilms")
    public ResponseEntity<List<FilmRes>> getAllFilm(){
        try{
            return ResponseEntity.ok().body(filmService.getALlfilms());
        }catch (Exception ex) {
            log.log(Level.ERROR, ex);
            return ResponseEntity.internalServerError().body(null);

        }
    }

    @GetMapping("/v1/film")
    public ResponseEntity<List<FilmRes>> getFilmsByOld(@RequestParam(required = false) boolean isOld,
                                                       @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
                                                       @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate){
        try{
            return ResponseEntity.ok().body(filmService.getFilms(isOld, startDate, endDate));
        }catch (Exception ex) {
            log.log(Level.ERROR, ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }
}

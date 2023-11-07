package it.giachin.theaters.firenze.controller;

import it.giachin.theaters.firenze.dto.response.FilmPlanningRes;
import it.giachin.theaters.firenze.service.IService.IFilmPlanningService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Log4j2
public class FilmPlanningController {
    @Autowired
    IFilmPlanningService filmPlanningService;


    @GetMapping("/v1/filmplanning")
    public ResponseEntity<List<FilmPlanningRes>> getFilmPlanning(
            @RequestParam(required = false) long proomId,
            @RequestParam(required = false) long filmID,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate
    )
    {
        try{
            return ResponseEntity.ok().body(filmPlanningService.getFilmPlanning(proomId, filmID, startDate, endDate));
        }catch (Exception ex) {
            log.log(Level.ERROR, ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }
}

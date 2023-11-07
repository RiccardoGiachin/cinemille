package it.giachin.theaters.firenze.service;

import it.giachin.theaters.firenze.dto.response.FilmPlanningRes;
import it.giachin.theaters.firenze.dto.response.FilmRes;
import it.giachin.theaters.firenze.repository.FilmPlanningRepository;
import it.giachin.theaters.firenze.service.IService.IFilmPlanningService;
import it.giachin.theaters.firenze.service.IService.IFilmService;
import it.giachin.theaters.firenze.utility.MapUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilmPlanningService implements IFilmPlanningService {

    @Autowired
    FilmPlanningRepository filmPlanningRepository;


    @Override
    public List<FilmPlanningRes> getFilmPlanning(Long projectionRoomId, Long filmId, Date startDate, Date endDate) {
        return MapUtility.mapFilmPlanning(filmPlanningRepository.findFilmPlanning(projectionRoomId, filmId, startDate, endDate));
    }
}

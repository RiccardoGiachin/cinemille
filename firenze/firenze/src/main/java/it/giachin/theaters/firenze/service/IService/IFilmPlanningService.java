package it.giachin.theaters.firenze.service.IService;

import it.giachin.theaters.firenze.dto.response.FilmPlanningRes;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IFilmPlanningService {

    public List<FilmPlanningRes> getFilmPlanning(Long projectionRoomId, Long filmId, Date startDate, Date endDate);
}

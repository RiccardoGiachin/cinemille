package it.giachin.theaters.firenze.service;

import it.giachin.theaters.firenze.dto.response.FilmRes;
import it.giachin.theaters.firenze.repository.FilmRepository;
import it.giachin.theaters.firenze.service.IService.IFilmService;
import it.giachin.theaters.firenze.utility.MapUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilmService implements IFilmService {

    @Autowired
    FilmRepository filmRepo;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public List<FilmRes> getALlfilms() {
        return MapUtility.mapList(filmRepo.findAll(), FilmRes.class);
    }

    @Override
    public List<FilmRes> getFilms(boolean isOld, Date startDate, Date endDate) {
        return MapUtility.mapList(filmRepo.findFilms(isOld, startDate, endDate), FilmRes.class);
    }
}

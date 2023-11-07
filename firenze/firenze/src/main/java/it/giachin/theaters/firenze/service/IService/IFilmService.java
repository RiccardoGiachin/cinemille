package it.giachin.theaters.firenze.service.IService;

import it.giachin.theaters.firenze.dto.response.FilmRes;
import it.giachin.theaters.firenze.model.Film;
import it.giachin.theaters.firenze.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface IFilmService {
    public List<FilmRes> getALlfilms();

    public List<FilmRes> getFilms(boolean isOld, Date startDate, Date endDate);
}

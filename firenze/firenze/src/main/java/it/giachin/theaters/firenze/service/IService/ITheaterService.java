package it.giachin.theaters.firenze.service.IService;

import it.giachin.theaters.firenze.dto.response.TheaterRes;
import it.giachin.theaters.firenze.model.Theater;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITheaterService {

    List<TheaterRes> GetAllTheater();
}

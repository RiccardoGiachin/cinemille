package it.giachin.theaters.firenze.service;

import it.giachin.theaters.firenze.dto.response.TheaterRes;
import it.giachin.theaters.firenze.model.Theater;
import it.giachin.theaters.firenze.repository.TheaterRepository;
import it.giachin.theaters.firenze.service.IService.ITheaterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService implements ITheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<TheaterRes> GetAllTheater() {
        return mapList(theaterRepository.findAll(), TheaterRes.class);
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

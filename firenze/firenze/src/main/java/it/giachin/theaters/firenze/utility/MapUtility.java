package it.giachin.theaters.firenze.utility;

import it.giachin.theaters.firenze.dto.response.FilmPlanningRes;
import it.giachin.theaters.firenze.dto.response.ProjectionRoomRes;
import it.giachin.theaters.firenze.model.FilmPlanning;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapUtility {
    private static ModelMapper modelMapper = new ModelMapper();
    public static  <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public static List<FilmPlanningRes> mapFilmPlanning(List<FilmPlanning> source){
       var response = new ArrayList<FilmPlanningRes>();
        for (var planning : source) {
            var res = FilmPlanningRes.builder().
                    filmName(planning.getFilm().getName()).
                    projectionRoomNumber(
                            planning.getProjectionRoom().getRoomNumber()).startDate(planning.getStartFilm()).endDate(planning.getEndFilm())
                    .build();
            response.add(res);
        }
        return response;
    }
}

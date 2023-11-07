package it.giachin.theaters.firenze.service.IService;

import it.giachin.theaters.firenze.dto.response.ProjectionRoomRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectionRoomService {

    List<ProjectionRoomRes> getProjectionRoomFromTheater(long theaterId);
}

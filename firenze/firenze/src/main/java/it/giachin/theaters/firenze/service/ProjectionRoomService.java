package it.giachin.theaters.firenze.service;

import it.giachin.theaters.firenze.dto.response.ProjectionRoomRes;
import it.giachin.theaters.firenze.model.ProjectionRoom;
import it.giachin.theaters.firenze.repository.ProjectionRoomRepository;
import it.giachin.theaters.firenze.service.IService.IProjectionRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectionRoomService implements IProjectionRoomService {

    @Autowired
    ProjectionRoomRepository projectionRoomRepository;
    @Override
    public List<ProjectionRoomRes> getProjectionRoomFromTheater(long theaterId) {
        var rooms = projectionRoomRepository.FindProjectionRoomByTheater(theaterId);
        var roomress = new ArrayList<ProjectionRoomRes>();
        for (var room : rooms) {
            var res = ProjectionRoomRes.builder().
                    roomType(room.getProjectionRoomType().getType()).
                    descriptionRoomType(
                            room.getProjectionRoomType().
                                    getDescription()).capacity(room.getCapacity())
                    .build();
            roomress.add(res);
        }
        return roomress;
    }
}

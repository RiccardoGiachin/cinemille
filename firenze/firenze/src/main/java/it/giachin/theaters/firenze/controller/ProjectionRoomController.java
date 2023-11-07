package it.giachin.theaters.firenze.controller;

import it.giachin.theaters.firenze.dto.response.ProjectionRoomRes;
import it.giachin.theaters.firenze.service.IService.IProjectionRoomService;
import jakarta.websocket.server.PathParam;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class ProjectionRoomController {

    @Autowired
    IProjectionRoomService projectionRoomService;

    @GetMapping("/v1/projectionRoom/{theaterId}")
    public ResponseEntity<List<ProjectionRoomRes>> getProjectionRoom(@PathParam("theaterId") long theaterId){
        try{
            return ResponseEntity.ok().body(projectionRoomService.getProjectionRoomFromTheater(theaterId));
        }catch (Exception ex) {
            log.log(Level.ERROR, ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }
}

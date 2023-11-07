package it.giachin.theaters.firenze.repository;

import it.giachin.theaters.firenze.model.ProjectionRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectionRoomRepository extends JpaRepository<ProjectionRoom, Long> {

    @Query("select projectionRoom from ProjectionRoom projectionRoom where projectionRoom.theater.id=?1")
    List<ProjectionRoom> FindProjectionRoomByTheater(long theaterId);

}

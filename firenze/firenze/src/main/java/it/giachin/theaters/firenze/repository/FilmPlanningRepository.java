package it.giachin.theaters.firenze.repository;

import it.giachin.theaters.firenze.model.FilmPlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmPlanningRepository extends JpaRepository<FilmPlanning, Long> {

    @Query("select film from FilmPlanning film where film.projectionRoom.id= ?1")
    Optional<FilmPlanning> findByProjectionRoomId(Long projectionRoomId);


    @Query("select film from FilmPlanning film where film.film.id= ?1")
    Optional<FilmPlanning> findByFilmId(long filmId);

    @Query("select planning from FilmPlanning planning where (:prjroomId is null or planning.projectionRoom.id = :prjRoomId) and (:filmId is null or planning.projectionRoom.id = :filmId) and (:startDate is null or planning.startFilm >= :startDate) and (:endDate is null or planning.endFilm <= :endDate)")
    public List<FilmPlanning> findFilmPlanning(@Param("prjroomId") long prjRoomId, @Param("filmId") long filmId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

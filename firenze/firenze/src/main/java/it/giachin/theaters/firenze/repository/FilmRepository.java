package it.giachin.theaters.firenze.repository;

import it.giachin.theaters.firenze.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByNameIsLike(String name);

    @Query("select film from Film film where (:old is null or film.old=:old) and (:startDate is null or film.createdDate >= :startDate) and (:endDate is null or film.lastProjectionDate <= :endDate)")
    List<Film> findFilms(@Param("old") boolean isOld,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}

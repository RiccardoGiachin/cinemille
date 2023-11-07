package it.giachin.theaters.firenze.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmPlanning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private ProjectionRoom projectionRoom;

    @OneToOne
    private Film film;

    private Date startFilm;
    private Date endFilm;
}

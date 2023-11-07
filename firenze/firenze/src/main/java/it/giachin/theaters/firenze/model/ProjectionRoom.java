package it.giachin.theaters.firenze.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectionRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long roomNumber;

    @ManyToOne
    private Theater theater;

    private long capacity;

    @ManyToOne
    private ProjectionRoomType projectionRoomType;


}

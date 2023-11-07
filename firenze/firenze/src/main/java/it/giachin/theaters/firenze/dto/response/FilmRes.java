package it.giachin.theaters.firenze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmRes {
    String name;
    String description;
    Date createdDate;
    Date lastProjectionDate;
    boolean old;
}

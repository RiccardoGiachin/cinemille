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
public class FilmPlanningRes {
    String filmName;
    long projectionRoomNumber;
    Date startDate;
    Date endDate;
}

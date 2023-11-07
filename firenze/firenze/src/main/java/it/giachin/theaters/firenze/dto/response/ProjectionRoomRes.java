package it.giachin.theaters.firenze.dto.response;

import lombok.Builder;

@Builder
public class ProjectionRoomRes {

    private long capacity;
    private long roomNumber;
    private String roomType;
    private String descriptionRoomType;
}

package it.giachin.theaters.firenze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {
    private String name;
    private String surname;
    private String email;
    private long id;
}

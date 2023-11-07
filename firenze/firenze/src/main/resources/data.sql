insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
                                                                             (1,
                                                                              'Matrix',
                                                                              'Neo si ribella al sistema',
                                                                              CURRENT_DATE,
                                                                              DATE_ADD(CURRENT_DATE, interval 30 day),
                                                                              CURRENT_DATE) On DUPLICATE key update name= 'Matrix';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (2,
     'Kunk Fu Panda',
     'Il re del kunk fu è un panda',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE) On DUPLICATE key update name= 'Kung fu panda';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (3,
     'The Whale',
     'Charlie è un professore di inglese gravemente obeso e solitario che tiene corsi universitari di scrittura in videoconferenza, ma senza mai attivare la webcam per non mostrare il suo aspetto fisico agli studenti',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE)On DUPLICATE key update name= 'The Whale';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (4,
     'Godzilla vs Kong',
     'La battaglia tra le due creature che hanno cresciute le generazioni',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE)On DUPLICATE key update name= 'Godzilla vs Kong';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (5,
     'V per vendetta',
     'La vendetta verso un sistema nazionalista, vista da una maschera',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE) On DUPLICATE key update name= 'V per Vendetta';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (6,
     'DeadPool',
     'Un antieroe sarcastico, simpatico e che picchia!',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE) On DUPLICATE key update name= 'Deadpool';
insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date) VALUES
    (7,
     'Interstellar',
     'Un viaggio tra fisica, pianeti e fisica quantistica',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE);

insert IGNORE into film (id, name, description, created_date, last_projection_date, first_projection_date, old) VALUES
    (8,
     'Frankenstein Junior',
     'Parodia di Frankestein',
     CURRENT_DATE,
     DATE_ADD(CURRENT_DATE, interval 30 day),
     CURRENT_DATE, true);
                                                                                                                    ;
insert IGNORE into theater(id, address, city, name) VALUE (1, 'VIa Roma', 'Firenze', 'CineMille' );


insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (1, 250, 1, 1, 1);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (2, 250, 2, 1, 2);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (3, 250, 2, 1, 3);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (4, 250, 1, 1, 4);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number ) VALUE (5, 250, 1, 1,  5);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (6, 250, 1, 1, 6);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (7, 250, 1, 1, 7);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (8, 250, 1, 1, 8);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (9, 250, 1,  1,9);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (10, 250, 1, 1, 10);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (11, 250, 1, 1, 11);
insert IGNORE into projection_room(id, capacity, projection_room_type_id, theater_id, room_number) VALUE (12, 250, 1, 1, 12);

insert IGNORE into film_planning(id, end_film, start_film, film_id, projection_room_id) VALUE
    (1, DATE_ADD(CURRENT_DATE, interval 2 hour ), current_date, 1, 1);
insert IGNORE into film_planning(id, end_film, start_film, film_id, projection_room_id) VALUE
    (2, DATE_ADD(CURRENT_DATE, interval 4 hour ), DATE_ADD(CURRENT_DATE, interval 2 hour ), 2, 4);

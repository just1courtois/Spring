INSERT INTO BUILDING(id, name) VALUES(1000, 'Maison principale');
INSERT INTO BUILDING(id, name) VALUES(2000, 'Bureau entreprise');

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(100, 'Chambre parent', 1, 18.5, 20.5,1000);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(101, 'Chambre enfant', 1, 19, 20.5,1000);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(102, 'Salon', 0, 18, 20.0,1000);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(103, 'Cuisine', 0, 18.3, 20.0,1000);

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(200, 'Bureau CEO', 2, 19.4, 21,2000);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(201, 'Bureau RH', 1, 20.8, 21,2000);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id)  VALUES(202, 'Accueil', 0, 19, 19.5,2000);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(50, 'ON', 'Heater Chambre parent', 2000, 100);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(51, 'ON', 'Heater1 Chambre enfant', 1000, 101);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(52, 'OFF', 'Heater2 Chambre enfant', 1000, 101);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(53, 'ON', 'Heater Salon', 1200, 102);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(54, 'ON', 'Heater Cuisine', 1000, 103);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(55, 'OFF', 'Heater Cuisine', 1100, 103);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(60, 'ON', 'Heater Bureau CEO', 2000, 200);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(61, 'ON', 'Heater1 Bureau RH', 1000, 201);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(62, 'OFF', 'Heater2 Bureau RH', 1600, 201);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(63, 'ON', 'Heater Accueil', 1200, 202);



INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(40, 'CLOSED', 'Window1 Chambre parent', 100);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(41, 'CLOSED', 'Window2 Chambre parent', 100);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(42, 'OPEN', 'Window Chambre enfant', 101);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(43, 'CLOSED', 'Window Salon', 102);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(44, 'CLOSED', 'Window1 Cuisine', 103);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(45, 'OPEN', 'Window2 Cuisine', 103);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(30, 'CLOSED', 'Window2 Bureau CEO', 200);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(31, 'OPEN', 'Window Bureau RH', 201);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(32, 'CLOSED', 'Window1 Accueil', 202);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(33, 'CLOSED', 'Window2 Accueil', 202);

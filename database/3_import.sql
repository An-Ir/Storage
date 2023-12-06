INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'customer');
INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'seller');

INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anu', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'andrus', '123', 'D');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anton', '123', 'D');

INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Harju');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Hiiu');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Ida-Viru');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Jõgeva');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Järva');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Lääne');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Lääne-Viru');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Põlva');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Rapla');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Saare');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Valga');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO storage.county (id, name) VALUES (DEFAULT, 'Võru');

INSERT INTO storage.type (id, name) VALUES (DEFAULT, 'Keldriboks');
INSERT INTO storage.type (id, name) VALUES (DEFAULT, 'Garaaž');
INSERT INTO storage.type (id, name) VALUES (DEFAULT, 'Ladu');
INSERT INTO storage.type (id, name) VALUES (DEFAULT, 'Angaar');
INSERT INTO storage.type (id, name) VALUES (DEFAULT, 'Varia');

INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 1, 59.41095402926769, 24.73704188387255);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 9, 58.38106365626340, 24.49951298280597);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 14, 58.30321349111780, 25.57822312103430);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 11, 58.25660700396890, 22.48073927116400);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 3, 59.38471618906680, 27.33955930526720);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 13, 57.77789351473060, 26.03407621534382);
INSERT INTO storage.location (id, county_id, latitude, longitude) VALUES (DEFAULT, 7, 59.36180293754910, 26.31411555746854);

INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 4, 2, 6, 'minu garaaž', 60, 210, 'Garaaž Valga kesklinnas', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 2, 3, 5, 'tootmishoone', 500, 400, 'Kõle sara Täkumetsas', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 3, 4, 3, 'unistuste angaar', 740, 987, 'Hiiglaslik angaar', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 2, 2, 4, 'Esplanaadi', 150, 150, 'Puhas garaažiboks', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 1, 2, 1, 'uhiuus garaaž', 80, 100, 'lihtsalt imelin', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 4, 4, 2, 'Eralennuki angaar', 1000, 5000, 'Kõigi kellade ja viledega angaar.', 'A');
INSERT INTO storage.storage (id, user_id, type_id, location_id, name, area, price, description, status) VALUES (DEFAULT, 3, 1, 7, 'kelder', 40, 50, 'Kõk vanaema hoidised mahuvad ära', 'A');


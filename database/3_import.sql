INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'customer');
INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'seller');

INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anu', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'andrus', '123', 'D');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anton', '123', 'D');

INSERT INTO storage.county (id, name) VALUES (1, 'Harju');
INSERT INTO storage.county (id, name) VALUES (2, 'Hiiu');
INSERT INTO storage.county (id, name) VALUES (3, 'Ida-Viru');
INSERT INTO storage.county (id, name) VALUES (4, 'Jõgeva');
INSERT INTO storage.county (id, name) VALUES (5, 'Järva');
INSERT INTO storage.county (id, name) VALUES (6, 'Lääne');
INSERT INTO storage.county (id, name) VALUES (7, 'Lääne-Viru');
INSERT INTO storage.county (id, name) VALUES (8, 'Põlva');
INSERT INTO storage.county (id, name) VALUES (9, 'Pärnu');
INSERT INTO storage.county (id, name) VALUES (10, 'Rapla');
INSERT INTO storage.county (id, name) VALUES (11, 'Saare');
INSERT INTO storage.county (id, name) VALUES (12, 'Tartu');
INSERT INTO storage.county (id, name) VALUES (13, 'Valga');
INSERT INTO storage.county (id, name) VALUES (14, 'Viljandi');
INSERT INTO storage.county (id, name) VALUES (15, 'Võru');

INSERT INTO storage.type (id, name) VALUES (1, 'Keldriboks');
INSERT INTO storage.type (id, name) VALUES (2, 'Garaaž');
INSERT INTO storage.type (id, name) VALUES (3, 'Ladu');
INSERT INTO storage.type (id, name) VALUES (4, 'Angaar');
INSERT INTO storage.type (id, name) VALUES (5, 'Varia');

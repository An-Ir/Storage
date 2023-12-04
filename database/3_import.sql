INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO storage.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anu', '123', 'A');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'andrus', '123', 'D');
INSERT INTO storage."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'anton', '123', 'D');
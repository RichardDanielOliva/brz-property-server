INSERT INTO `users` (username, password, enabled, first_name, last_name, email) VALUES ('richard','$2a$10$ykhXmCAam5FUEF9GN.4Z8OwwWJidvMii6VFYe77cmS2X6oF6p4W86',true, 'Richard', 'Oliva','danielolivadenis@gmail.com');
INSERT INTO `users` (username, password, enabled, first_name, last_name, email) VALUES ('admin','$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK',true, 'Admin', 'Admin','admin@example.com');
-- PASSWORD 12345


INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');
INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO `user_role` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 2);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 1);

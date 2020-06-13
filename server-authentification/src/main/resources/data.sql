-- USER
-- hashed password: 12345
INSERT INTO user (id, username, password, first_name, last_name, email, auth_provider) VALUES
(1,  'admin', '$2a$11$In6msuXHsb5NIjBR7nBPu.G0knLaaOw8HtPw5mjPgdIBwNXzYD5Ai', 'Administrator', 'Adminstrator', 'adminstrator@gmail.com', 'local'),
(2,  'defaultuser', '$2a$11$In6msuXHsb5NIjBR7nBPu.G0knLaaOw8HtPw5mjPgdIBwNXzYD5Ai', 'User', 'Default', 'defaultuser@gmail.com', 'local');

-- ROLES

INSERT INTO role (id, role_name, description) VALUES (1, 'ROLE_ADMIN', 'Administrator');
INSERT INTO role (id, role_name, description) VALUES (2, 'ROLE_USER', 'Default user role');
INSERT INTO role (id, role_name, description) VALUES (3, 'ROLE_USER_GOOGLE', 'Default user role');
INSERT INTO role (id, role_name, description) VALUES (4, 'ROLE_USER_FACEBOOK', 'Default user role');
INSERT INTO role (id, role_name, description) VALUES (5, 'ROLE_USER_GITHUB', 'Default user role');

INSERT INTO user_role(user_id, role_id) VALUES (1, 1); -- give admin ROLE_ADMIN
INSERT INTO user_role(user_id, role_id) VALUES (2, 2);  -- give user ROLE_USER

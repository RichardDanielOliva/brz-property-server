CREATE TABLE user (
  	id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	username varchar(255),
  	password varchar(255),
  	first_name varchar(255),
  	last_name varchar(255),
	email varchar(255) NOT NULL,
	auth_provider varchar(255) NOT NULL
);

CREATE TABLE role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  description varchar(100) DEFAULT NULL,
  role_name varchar(100) DEFAULT NULL
);

CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT FK_SECURITY_USER_ID FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT FK_SECURITY_ROLE_ID FOREIGN KEY (role_id) REFERENCES role (id)
);
CREATE TABLE IF NOT EXISTS Roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT UNSIGNED, -- Asegura que sea UNSIGNED como Users.id
    role_id BIGINT UNSIGNED, -- Asegura compatibilidad con Roles.id
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES Roles(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender VARCHAR(10),
    salary_expected DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




INSERT INTO Roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO Roles (name) VALUES ('ROLE_USER');

INSERT INTO Users (username, nombre, email, password) VALUES ('admin', 'admin123' , 'admin@gmail.com', '$2a$10$aIZH072mVsHAg9DPk4xqtOQA6IJicGCcKV73GmukMTayiKV7aTZiu');
INSERT INTO Users (username, nombre,email, password) VALUES ('user', 'user' , 'user@gmail.com', '$2a$10$aIZH072mVsHAg9DPk4xqtOQA6IJicGCcKV73GmukMTayiKV7aTZiu');


INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Admin con ROLE_ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- User con ROLE_USER

INSERT INTO candidates (name, email, gender, salary_expected) VALUES
('Alice Johnson', 'alice@example.com', 'Female', 60000.00),
('Bob Smith', 'bob@example.com', 'Male', 55000.00),
('Charlie Brown', 'charlie@example.com', 'Male', 70000.00),
('Diana Prince', 'diana@example.com', 'Female', 80000.00),
('Ethan Hunt', 'ethan@example.com', 'Male', 75000.00);
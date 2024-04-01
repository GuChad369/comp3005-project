CREATE TABLE Member (
       email VARCHAR(255) PRIMARY KEY,
       first_name VARCHAR(255),
       last_name VARCHAR(255),
       phone VARCHAR(15)
);

CREATE TABLE Fitness_Goals (
       member_email VARCHAR(255) PRIMARY KEY,
       -- only show months
       time_goal SMALLINT,
       -- only show kg
       weight_goal SMALLINT,
       FOREIGN KEY (member_email) REFERENCES Member (email)
);

CREATE TABLE Health_Metrics (
       member_email VARCHAR(255) PRIMARY KEY,
       -- only show kg
       weight SMALLINT,
       -- only show cm
       height SMALLINT,
       BMI DECIMAL,
       FOREIGN KEY (member_email) REFERENCES Member (email)
);

CREATE TABLE Dashboard (
       member_email VARCHAR(255) PRIMARY KEY,
       oneday_hours SMALLINT,
       oneweek_days SMALLINT,
       achieve_hours SMALLINT,
       FOREIGN KEY (member_email) REFERENCES Member (email)
);

CREATE TABLE Health_Statistics (
       member_email VARCHAR(255) PRIMARY KEY,
       -- beats/minute
       heartbeat SMALLINT,
       -- mmHg
       systolic SMALLINT,
       -- mmHg
       diastolic SMALLINT,
       -- mg/dL
       cholesterol_levels SMALLINT,
       FOREIGN KEY (member_email) REFERENCES Dashboard
);

CREATE TABLE Trainer (
       email VARCHAR(255) PRIMARY KEY,
       first_name VARCHAR(255),
       last_name VARCHAR(255),
       phone VARCHAR(15)
);

CREATE TABLE Schedule (
       id SERIAL PRIMARY KEY,
       -- yyyy-mm-dd
       date DATE NOT NULL,
       -- 00:00:00
       start_time TIME NOT NULL,
       end_time TIME NOT NULL
);

CREATE TABLE Available (
       trainer_email VARCHAR(255),
       time_id INT,
       PRIMARY KEY (trainer_email, time_id),
       FOREIGN KEY (trainer_email) REFERENCES Trainer (email),
       FOREIGN KEY (time_id) REFERENCES Schedule (id)
);

CREATE TABLE Training (
       member_email VARCHAR(255),
       trainer_email VARCHAR(255),
       time_id INT,
       PRIMARY KEY (member_email, trainer_email, time_id),
       FOREIGN KEY (member_email) REFERENCES Member (email),
       FOREIGN KEY (trainer_email) REFERENCES Trainer (email),
       FOREIGN KEY (time_id) REFERENCES Schedule (id)
);

CREATE TABLE Bill (
       member_email VARCHAR(255),
       date DATE DEFAULT CURRENT_DATE,
       time TIME DEFAULT CURRENT_TIME,
       project_name VARCHAR(255) NOT NULL,
       card_number VARCHAR(30) NOT NULL,
       subtotal DECIMAL NOT NULL,
       hst DECIMAL NOT NULL,
       PRIMARY KEY (member_email, date, time),
       FOREIGN KEY (member_email) REFERENCES Member (email)
);

CREATE TABLE Room (
       id SERIAL PRIMARY KEY,
       room_number VARCHAR(30) NOT NULL,
       time_id INT NOT NULL,
       FOREIGN KEY (time_id) REFERENCES Schedule (id)
);

CREATE TABLE Class (
       class_id SERIAL PRIMARY KEY,
       class_name VARCHAR(255) NOT NULL,
       room_id INT,
       FOREIGN KEY (room_id) REFERENCES Room (id)
);

CREATE TABLE Group_class (
       member_email VARCHAR(255),
       class_id INT,
       PRIMARY KEY (member_email, class_id),
       FOREIGN KEY (member_email) REFERENCES Member (email),
       FOREIGN KEY (class_id) REFERENCES Class (class_id)
);

CREATE TABLE Equipment (
       id SERIAL PRIMARY KEY,
       model VARCHAR(30) NOT NULL,
       room_id INT,
       -- -1, 0 , 1
       status SMALLINT NOT NULL,
       FOREIGN KEY (room_id) REFERENCES Room (id)
);
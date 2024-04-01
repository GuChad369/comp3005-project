INSERT INTO
    Member (email, first_name, last_name, phone)
VALUES
    (
        'john.doe@example.com',
        'John',
        'Doe',
        '123-456-7890'
    ),
    (
        'jane.doe@example.com',
        'Jane',
        'Doe',
        '234-567-8901'
    ),
    (
        'mike.smith@example.com',
        'Mike',
        'Smith',
        '345-678-9012'
    ),
    (
        'sarah.jones@example.com',
        'Sarah',
        'Jones',
        '456-789-0123'
    ),
    (
        'alex.brown@example.com',
        'Alex',
        'Brown',
        '567-890-1234'
    ),
    (
        'lisa.white@example.com',
        'Lisa',
        'White',
        '678-901-2345'
    ),
    (
        'kevin.green@example.com',
        'Kevin',
        'Green',
        '789-012-3456'
    ),
    (
        'emily.clark@example.com',
        'Emily',
        'Clark',
        '890-123-4567'
    ),
    (
        'david.wilson@example.com',
        'David',
        'Wilson',
        '901-234-5678'
    ),
    (
        'emma.taylor@example.com',
        'Emma',
        'Taylor',
        '012-345-6789'
    );

-- Insert sample data into Fitness_Goals
INSERT INTO
    Fitness_Goals (member_email, time_goal, weight_goal)
VALUES
    ('john.doe@example.com', 6, 75),
    ('jane.doe@example.com', 4, 65),
    ('mike.smith@example.com', 5, 80),
    ('sarah.jones@example.com', 3, 55),
    ('alex.brown@example.com', 8, 90),
    ('lisa.white@example.com', 7, 70),
    ('kevin.green@example.com', 9, 85),
    ('emily.clark@example.com', 10, 60),
    ('david.wilson@example.com', 12, 90),
    ('emma.taylor@example.com', 11, 60);

-- Insert sample data into Health_Metrics
INSERT INTO
    Health_Metrics (member_email, weight, height, BMI)
VALUES
    ('john.doe@example.com', 80, 180, 24.7),
    ('jane.doe@example.com', 60, 165, 22.0),
    ('mike.smith@example.com', 85, 175, 27.8),
    ('sarah.jones@example.com', 50, 160, 19.5),
    ('alex.brown@example.com', 95, 185, 27.8),
    ('lisa.white@example.com', 80, 170, 27.7),
    ('kevin.green@example.com', 100, 182, 30.2),
    ('emily.clark@example.com', 55, 158, 22.0),
    ('david.wilson@example.com', 100, 190, 27.7),
    ('emma.taylor@example.com', 75, 168, 26.6);

-- Insert sample data into Dashboard
INSERT INTO
    Dashboard (
        member_email,
        oneday_hours,
        oneweek_days,
        achieve_hours
    )
VALUES
    ('john.doe@example.com', 2, 5, 10),
    ('jane.doe@example.com', 1, 4, 8),
    ('mike.smith@example.com', 3, 6, 12),
    ('sarah.jones@example.com', 1, 3, 6),
    ('alex.brown@example.com', 4, 7, 14),
    ('lisa.white@example.com', 2, 5, 10),
    ('kevin.green@example.com', 3, 6, 12),
    ('emily.clark@example.com', 1, 4, 8),
    ('david.wilson@example.com', 4, 7, 14),
    ('emma.taylor@example.com', 2, 5, 10);

-- Insert sample data into Health_Statistics
INSERT INTO
    Health_Statistics (
        member_email,
        heartbeat,
        systolic,
        diastolic,
        cholesterol_levels
    )
VALUES
    ('john.doe@example.com', 70, 120, 80, 190),
    ('jane.doe@example.com', 75, 115, 75, 180),
    ('mike.smith@example.com', 80, 130, 85, 200),
    ('sarah.jones@example.com', 65, 110, 70, 170),
    ('alex.brown@example.com', 85, 135, 90, 210),
    ('lisa.white@example.com', 70, 120, 80, 190),
    ('kevin.green@example.com', 75, 125, 85, 195),
    ('emily.clark@example.com', 60, 105, 65, 165),
    ('david.wilson@example.com', 90, 140, 95, 220),
    ('emma.taylor@example.com', 68, 118, 78, 185);

-- Insert sample data into Trainer
INSERT INTO
    Trainer (email, first_name, last_name, phone)
VALUES
    (
        'tom.jones@example.com',
        'Tom',
        'Jones',
        '456-789-0123'
    ),
    (
        'susan.miller@example.com',
        'Susan',
        'Miller',
        '567-890-1234'
    ),
    (
        'jim.moore@example.com',
        'Jim',
        'Moore',
        '678-901-2345'
    ),
    (
        'laura.williams@example.com',
        'Laura',
        'Williams',
        '789-012-3456'
    ),
    (
        'peter.harris@example.com',
        'Peter',
        'Harris',
        '890-123-4567'
    ),
    (
        'rachel.jackson@example.com',
        'Rachel',
        'Jackson',
        '890-123-4567'
    ),
    (
        'steve.martin@example.com',
        'Steve',
        'Martin',
        '901-234-5678'
    ),
    (
        'nancy.lee@example.com',
        'Nancy',
        'Lee',
        '012-345-6789'
    ),
    (
        'patrick.king@example.com',
        'Patrick',
        'King',
        '123-456-7890'
    ),
    (
        'julia.scott@example.com',
        'Julia',
        'Scott',
        '234-567-8901'
    );

-- Insert sample data into Schedule
INSERT INTO
    Schedule (date, start_time, end_time)
VALUES
    ('2024-03-20', '08:00:00', '09:00:00'),
    ('2024-03-20', '09:00:00', '10:00:00'),
    ('2024-03-20', '10:00:00', '11:00:00'),
    ('2024-03-20', '11:00:00', '12:00:00'),
    ('2024-03-20', '12:00:00', '13:00:00'),
    ('2024-03-20', '13:00:00', '14:00:00'),
    ('2024-03-20', '14:00:00', '15:00:00'),
    ('2024-03-20', '15:00:00', '16:00:00'),
    ('2024-03-20', '16:00:00', '17:00:00'),
    ('2024-03-20', '17:00:00', '18:00:00'),
    ('2024-03-20', '16:00:00', '17:00:00');

-- Insert sample data into Available
INSERT INTO
    Available (trainer_email, time_id)
VALUES
    ('tom.jones@example.com', 1),
    ('susan.miller@example.com', 2),
    ('jim.moore@example.com', 3),
    ('laura.williams@example.com', 4),
    ('peter.harris@example.com', 5),
    ('rachel.jackson@example.com', 6),
    ('steve.martin@example.com', 7),
    ('nancy.lee@example.com', 8),
    ('patrick.king@example.com', 9),
    ('julia.scott@example.com', 10),
    ('tom.jones@example.com', 11);

-- Insert sample data into Training
INSERT INTO
    Training (member_email, trainer_email, time_id)
VALUES
    (
        'john.doe@example.com',
        'tom.jones@example.com',
        1
    ),
    (
        'jane.doe@example.com',
        'susan.miller@example.com',
        2
    ),
    (
        'mike.smith@example.com',
        'jim.moore@example.com',
        3
    ),
    (
        'sarah.jones@example.com',
        'laura.williams@example.com',
        4
    ),
    (
        'alex.brown@example.com',
        'peter.harris@example.com',
        5
    ),
    (
        'lisa.white@example.com',
        'rachel.jackson@example.com',
        6
    ),
    (
        'kevin.green@example.com',
        'steve.martin@example.com',
        7
    ),
    (
        'emily.clark@example.com',
        'nancy.lee@example.com',
        8
    ),
    (
        'david.wilson@example.com',
        'patrick.king@example.com',
        9
    ),
    (
        'emma.taylor@example.com',
        'julia.scott@example.com',
        10
    );

-- Insert sample data into Bill
INSERT INTO
    Bill (
        member_email,
        project_name,
        card_number,
        subtotal,
        hst
    )
VALUES
    (
        'john.doe@example.com',
        'Personal Training',
        '1234 5678 9012 3456',
        100,
        0.13
    ),
    (
        'jane.doe@example.com',
        'Group Class',
        '2345 6789 0123 4567',
        50,
        0.065
    ),
    (
        'mike.smith@example.com',
        'Nutrition Plan',
        '3456 7890 1234 5678',
        80,
        0.104
    ),
    (
        'sarah.jones@example.com',
        'Gym Membership',
        '4567 8901 2345 6789',
        60,
        0.78
    ),
    (
        'alex.brown@example.com',
        'Personal Training',
        '5678 9012 3456 7890',
        100,
        0.13
    ),
    (
        'lisa.white@example.com',
        'Group Class',
        '6789 0123 4567 8901',
        50,
        0.065
    ),
    (
        'kevin.green@example.com',
        'Nutrition Plan',
        '7890 1234 5678 9012',
        80,
        0.104
    ),
    (
        'emily.clark@example.com',
        'Gym Membership',
        '8901 2345 6789 0123',
        60,
        0.078
    ),
    (
        'david.wilson@example.com',
        'Personal Training',
        '9012 3456 7890 1234',
        100,
        0.13
    ),
    (
        'emma.taylor@example.com',
        'Group Class',
        '0123 4567 8901 2345',
        50,
        0.065
    );

-- Insert sample data into Room
INSERT INTO
    Room (room_number, time_id)
VALUES
    ('101', 1),
    ('102', 2),
    ('103', 3),
    ('104', 4),
    ('105', 5),
    ('106', 6),
    ('107', 7),
    ('108', 8),
    ('109', 9),
    ('110', 10);

-- Insert sample data into Class
INSERT INTO
    Class (class_name, room_id)
VALUES
    ('Yoga', 1),
    ('Pilates', 2),
    ('Zumba', 3),
    ('Spin Class', 4),
    ('CrossFit', 5),
    ('Kickboxing', 6),
    ('Aerobics', 7),
    ('Strength Training', 8),
    ('HIIT', 9),
    ('Dance Fitness', 10);

-- Insert sample data into Group_class
INSERT INTO
    Group_class (member_email, class_id)
VALUES
    ('john.doe@example.com', 1),
    ('jane.doe@example.com', 2),
    ('mike.smith@example.com', 3),
    ('sarah.jones@example.com', 4),
    ('alex.brown@example.com', 5),
    ('lisa.white@example.com', 6),
    ('kevin.green@example.com', 7),
    ('emily.clark@example.com', 8),
    ('david.wilson@example.com', 9),
    ('emma.taylor@example.com', 10);

-- Insert sample data into Equipment
INSERT INTO
    Equipment (model, room_id, status)
VALUES
    ('Treadmill A', 1, 1),
    ('Elliptical B', 2, 0),
    ('Stationary Bike C', 3, -1),
    ('Rowing Machine D', 4, 1),
    ('Dumbbell Set E', 5, 0),
    ('Barbell Set F', 6, -1),
    ('Kettlebell Set G', 7, 1),
    ('Medicine Ball H', 8, 0),
    ('Yoga Mat I', 9, -1),
    ('Resistance Bands J', 10, 1);
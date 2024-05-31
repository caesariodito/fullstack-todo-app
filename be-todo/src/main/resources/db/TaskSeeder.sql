-- Ensure the table exists
CREATE TABLE IF NOT EXISTS Task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    created_at DATETIME,
    updated_at DATETIME
);

-- Insert dummy data
INSERT INTO Task (title, description, created_at, updated_at) VALUES
    ('Complete Project', 'Finish the project by the end of the week', '2024-05-01 10:00:00', '2024-05-01 10:00:00'),
    ('Write Report', 'Write the final report for the project', '2024-05-02 12:00:00', '2024-05-02 12:00:00'),
    ('Attend Meeting', 'Attend the project status meeting', '2024-05-03 09:00:00', '2024-05-03 09:30:00'),
    ('Fix Bugs', 'Fix the bugs identified in the testing phase', '2024-05-04 14:00:00', '2024-05-04 14:00:00'),
    ('Deploy Application', 'Deploy the final version of the application', '2024-05-05 16:00:00', '2024-05-05 16:00:00');

-- Drop the tasks table if it exists
DROP TABLE IF EXISTS task;

-- Create the tasks table
CREATE TABLE `task` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `title` VARCHAR(255) NOT NULL,
     `description` TEXT,
     `completed` BOOLEAN NOT NULL DEFAULT FALSE,
     `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
);

-- Drop the todo table if it exists
DROP TABLE IF EXISTS todo;

-- Create the todo table
CREATE TABLE `todo` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `title` VARCHAR(255) NOT NULL,
     `description` TEXT,
     `completed` BOOLEAN NOT NULL DEFAULT FALSE,
     `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
);

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
    ('Complete Project', 'Finish the project by the end of the week. This includes finalizing all pending tasks, ensuring all code is properly reviewed, and preparing for the final presentation. Collaborate with all team members to ensure everything is on track.', '2024-05-01 10:00:00', '2024-05-01 10:00:00'),
    ('Write Report', 'Write the final report for the project. The report should include an executive summary, detailed methodology, results, discussions, and conclusions. Make sure to include all necessary charts and diagrams.', '2024-05-02 12:00:00', '2024-05-02 12:00:00'),
    ('Attend Meeting', 'Attend the project status meeting. Discuss the current status of the project, any roadblocks encountered, and the plans for the next phase. Ensure to document all meeting notes and follow-up items.', '2024-05-03 09:00:00', '2024-05-03 09:30:00'),
    ('Fix Bugs', 'Fix the bugs identified in the testing phase. This includes debugging code, running tests, and ensuring all issues are resolved. Prioritize bugs based on their severity and impact on the project.', '2024-05-04 14:00:00', '2024-05-04 14:00:00'),
    ('Deploy Application', 'Deploy the final version of the application. This involves preparing the deployment environment, migrating data, and ensuring all configurations are set correctly. Conduct a final round of testing before the deployment.', '2024-05-05 16:00:00', '2024-05-05 16:00:00'),
    ('Create User Documentation', 'Prepare comprehensive user documentation. This should include installation guides, user manuals, and troubleshooting sections. Ensure the documentation is clear, concise, and easy to understand.', '2024-05-06 09:00:00', '2024-05-06 09:00:00'),
    ('Conduct Training Session', 'Organize and conduct a training session for the end users. This session should cover the key features of the application, how to navigate the system, and best practices. Prepare a presentation and training materials.', '2024-05-07 10:00:00', '2024-05-07 10:00:00'),
    ('Perform Code Review', 'Perform a detailed code review of the entire project. Ensure that the code adheres to the best practices and coding standards. Identify any potential improvements or optimizations.', '2024-05-08 11:00:00', '2024-05-08 11:00:00'),
    ('Update Project Plan', 'Update the project plan with the latest status. Include any changes to the schedule, resource allocation, and risk management. Ensure the project plan reflects the current state of the project.', '2024-05-09 13:00:00', '2024-05-09 13:00:00'),
    ('Prepare Presentation', 'Prepare the final presentation for the project. This should include an overview of the project, key achievements, challenges faced, and the future roadmap. Use visuals to make the presentation engaging.', '2024-05-10 14:00:00', '2024-05-10 14:00:00'),
    ('Conduct User Testing', 'Conduct user testing sessions to gather feedback from actual users. Document the feedback and identify areas for improvement. Ensure the sessions are structured and all scenarios are tested.', '2024-05-11 15:00:00', '2024-05-11 15:00:00'),
    ('Analyze Performance Metrics', 'Analyze the performance metrics of the application. Identify any bottlenecks or areas that need optimization. Prepare a report with recommendations for improving performance.', '2024-05-12 16:00:00', '2024-05-12 16:00:00'),
    ('Implement Feedback', 'Implement the feedback received from user testing and performance analysis. Prioritize the feedback based on its impact and feasibility. Ensure all changes are tested thoroughly.', '2024-05-13 09:00:00', '2024-05-13 09:00:00'),
    ('Plan Next Release', 'Plan the next release of the application. Define the scope, schedule, and resource requirements. Ensure all stakeholders are aligned on the plan and any dependencies are managed.', '2024-05-14 10:00:00', '2024-05-14 10:00:00'),
    ('Prepare Marketing Materials', 'Prepare marketing materials for the application. This includes brochures, flyers, and online content. Ensure the materials highlight the key features and benefits of the application.', '2024-05-15 11:00:00', '2024-05-15 11:00:00'),
    ('Conduct Market Research', 'Conduct market research to understand the target audience and competitors. Analyze market trends and user needs to inform the development of future features and enhancements.', '2024-05-16 13:00:00', '2024-05-16 13:00:00'),
    ('Set Up Support System', 'Set up a support system for the application users. This includes creating a knowledge base, setting up a ticketing system, and defining support processes. Ensure users can easily get help when needed.', '2024-05-17 14:00:00', '2024-05-17 14:00:00'),
    ('Conduct Security Audit', 'Conduct a security audit of the application. Identify any potential vulnerabilities and ensure that the application adheres to security best practices. Prepare a report with findings and recommendations.', '2024-05-18 15:00:00', '2024-05-18 15:00:00'),
    ('Optimize Database', 'Optimize the database for better performance. This includes indexing, query optimization, and reviewing the database schema. Ensure the database can handle the expected load efficiently.', '2024-05-19 16:00:00', '2024-05-19 16:00:00');
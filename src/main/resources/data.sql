-- All SQL statements in this file are automatically executed by Spring

-- `RESTART IDENTITY CASCADE` resets id counter to 0, since plain truncate does not
--TRUNCATE TABLE security_questions;
--
--INSERT INTO security_questions (question) VALUES ('What is the name of my first pet?');
--INSERT INTO security_questions (question) VALUES ('What is the age of my first pet?');
SELECT * FROM security_questions;
--
--INSERT INTO security_questions (question, question)
--SELECT 'foo', 'foo'
--WHERE NOT EXISTS (SELECT * FROM security_questions)

--COMMIT;
-- --- AUTHOR Example
INSERT INTO "subscribers" (id, active_user, email, email_sent, name, number) VALUES(1,FALSE , 'boban@gmail.com', TRUE , 'Artur', 103293475);

--
-- -- BOOK EXAMPLE
-- INSERT INTO "item" (id, category, created_by, created_on, number_of_copies, publisher, publishing_date, title) VALUES (100, 'CRIMINAL', current_user, localtimestamp, 10, 'BBC Publisher', localtimestamp, 'Sherlock Holmes');
-- INSERT INTO "book" (edition, isbn, number_of_pages, id, author_id) VALUES ('Second Edition', '1430249269', 400, 100, 100);
--
-- -- BOOK EXAMPLE THE SAME AUTHOR WITH ZERO COPIES
-- INSERT INTO "item" (id, category, created_by, created_on, number_of_copies, publisher, publishing_date, title) VALUES (200, 'CRIMINAL', current_user, localtimestamp, 0, 'BBC Publisher', localtimestamp, 'Sherlock Holmes - A Study in Scarlet');
-- INSERT INTO "book" (edition, isbn, number_of_pages, id, author_id) VALUES ('First Edition', '1430212269', 500, 200, 100);
--
-- -- BOOK EXAMPLE THE SAME AUTHOR WITH ZERO COPIES
-- INSERT INTO "item" (id, category, created_by, created_on, number_of_copies, publisher, publishing_date, title) VALUES (300, 'CRIMINAL', current_user, localtimestamp, 20, 'BBC Publisher', localtimestamp, 'Sherlock Holmes - The Sign of Four');
-- INSERT INTO "book" (edition, isbn, number_of_pages, id, author_id) VALUES ('Third Edition', '1431412269', 550, 300, 100);
--
-- --NEWSPAPER EXAMPLE
-- INSERT INTO "item" (id, category, created_by, created_on, number_of_copies, publisher, publishing_date, title) VALUES (400, 'NEWS', current_user, localtimestamp, 100, 'The Guardian', localtimestamp, 'The Guardian');
-- INSERT INTO "newspaper" (country_of_publishing, type, id) VALUES ('United Kingdom', 'Daily', 400);
--
-- -- BORROWER EXAMPLE
-- INSERT INTO "borrower" (id, created_by, created_on, email, first_name, last_name) VALUES (100, current_user, localtimestamp, 'john.smith@gmail.com', 'John', 'Smith');
--
-- -- ACTIVE BORROW
-- INSERT INTO "borrow" (id, created_by, created_on, due_date_time, fine, number_of_borrowed_item_copies, borrower_id, item_id) VALUES (100, current_user, localtimestamp, '2017-09-23 14:38:07', 0, 1, 100, 300);
--
-- -- RETURNED BORROW EXAMPLE
-- INSERT INTO "borrow" (id, created_by, created_on, due_date_time, fine, number_of_borrowed_item_copies, return_date_time, borrower_id, item_id) VALUES (200, current_user, localtimestamp, '2017-09-23 14:38:07', 0, 1, localtimestamp, 100, 100);
--

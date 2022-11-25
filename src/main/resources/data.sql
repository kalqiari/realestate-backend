--ROLE
INSERT INTO ROLES (id, name)
VALUES(1, 'admin');

INSERT INTO ROLES (id, name)
VALUES(2, 'owner');

INSERT INTO ROLES (id, name)
VALUES(3, 'customer');


-- USERS

INSERT INTO USERS (id,username, first_name,last_name,email,phone_number,street_address,address2,city,state,zipcode,deactivate_at,created_at,deleted_at, role_id, status)
VALUES (1, 'admin', 'admin', 'admin', 'admin@email.com','(641)-123490','1000N 4th Street','FairwayApartments','Chicago', 'Illinois','53901','1990-10-01','1990-10-01', '1990-10-01', 1, true );

INSERT INTO USERS (id,username, first_name,last_name,email,phone_number,street_address,address2,city,state,zipcode,deactivate_at,created_at,deleted_at, role_id, status)
VALUES (2, 'owner', 'owner', 'owner', 'owner@email.com','(641)-123490','1000N 4th Street','FairwayApartments','Chicago', 'Illinois','53901','1990-10-01','1990-10-01', '1990-10-01', 2 , true);

INSERT INTO USERS (id,username, first_name,last_name,email,phone_number,street_address,address2,city,state,zipcode,deactivate_at,created_at,deleted_at, role_id, status)
VALUES (3, 'customer', 'customer', 'customer', 'customer@email.com','(641)-123490','1000N 4th Street','FairwayApartments','Chicago', 'Illinois','53901','1990-10-01','1990-10-01', '1990-10-01', 3 , true);

INSERT INTO USERS (id,username, first_name,last_name,email,phone_number,street_address,address2,city,state,zipcode,deactivate_at,created_at,deleted_at, role_id, status)
VALUES (011, 'umur', 'umur', 'inan', 'uinan@miu.edu','(641)-123490','1000N 4th Street','FairwayApartments','Chicago', 'Illinois','53901','1990-10-01','1990-10-01', '1990-10-01',3, true );

INSERT INTO USERS (id,username,  first_name,last_name,email,phone_number,street_address,address2,city,state,zipcode,deactivate_at,created_at,deleted_at, role_id, status)
VALUES (012,'john','john', 'doe', 'john@miu.edu','(800)-891901','124E 10th Street','Mansion Lane', 'Fairfield','Iowa','52557','1990-10-01', '1990-10-01', '1990-10-01',3, true);

INSERT INTO USERS (id,username, first_name, last_name, email, phone_number, street_address, address2, city, state, zipcode, deactivate_at, created_at, deleted_at,role_id, status)
VALUES (1234, 'keven', 'Keven', 'prince', 'keven@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, '1990-10-01', '1990-10-01', '1990-10-01',3, true);

INSERT INTO USERS (id,username, first_name, last_name, email, phone_number, street_address, address2, city, state, zipcode, deactivate_at, created_at, deleted_at, role_id, status)
VALUES (1235,'prince', 'Keven', 'prince', 'prince@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, '1990-10-01', '1990-10-01', '1990-10-01',3, true );

INSERT INTO USERS (id,username, first_name, last_name, email, phone_number, street_address, address2, city, state, zipcode, deactivate_at, created_at, deleted_at, role_id, status)
VALUES (1236, 'kprince','Keven', 'prince', 'kprince@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, '1990-10-01', '1990-10-01', '1990-10-01',3, true );

--PROPERTY
INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(21, 1236, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(22, 3, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(23, 1235, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(24, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(25, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(26, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(27, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(28, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(29, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(30, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(31, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(32, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(33, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(34, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(35, 2, '23W 1st St','Curry Lane','Beverly Hills', 'CA', '23089', 'Rent','beautiful mansion by the sea',43000000, 'mansion', 10056,10, 13, true, 'open parking space', 6, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01' );

INSERT INTO PROPERTY(id, user_id, street_address, address2, city, state, zipcode, listing_type, description, price, home_type, sq_ft, bedrooms, bathrooms, pool, parking_type, parking_spaces, floor_type, year_built, is_built_complete, listed_at, deleted_at )
VALUES(36, 2, '231N 1st St','KKK Lane','Beverly Hills', 'CA', '23089', 'Sale','beautiful mansion by the sea',12000000, 'mansion', 81056,8, 9.5, true, 'open parking space', 3, 'wood', '1990-10-01', true, '1990-10-01', '1990-10-01');

-- APPLICATION

INSERT INTO APPLICATION (id,user_id, property_id, application_type, employment_info, credit_score, review_status, dropped_at, created_at, reviewed_at, deleted_at)
VALUES (100,3, 21, 'Rent' , 'unemployment', 300, 'Rejected', '1990-10-01', '1990-10-01', '2021-10-01', '1990-10-01' );

INSERT INTO APPLICATION (id,user_id,property_id, application_type, employment_info, credit_score, review_status, dropped_at, created_at, reviewed_at, deleted_at)
VALUES (200,3, 22, 'Buy' , 'employment', 700, 'Approved', '1990-10-01', '1990-10-01', '1990-10-01', '1990-10-01' );


-- PHOTO

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (1, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 21,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(2, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',22,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (3, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 23,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(4, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',24,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (5, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 25,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(6, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',26,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (7, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 27,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(8, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',28,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (9, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 29,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(10, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',30,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (11, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 31,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(12, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',32,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (13, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 33,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(14, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',34,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES (15, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp', 35,  '1990-10-01');

INSERT INTO PHOTOS (id, url, property_id, deleted_at)
VALUES(16, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',36,  '1990-10-01');

-- --FAVORITE
--
-- INSERT INTO  FAVORITES(id, user_id,property_id, created_at)
-- VALUES (1, 3,21, '1990-10-01');
--
-- INSERT INTO FAVORITES (id,user_id,property_id, created_at)
-- VALUES (2, 3,22, '1990-10-01');


--QUESTION
INSERT INTO QUESTION (id,user_id, property_id, content, created_at)
VALUES(12, 3, 21, 'can i pass by on Wednesday afternoon to tour the apartment?', '2021-01-12');

INSERT INTO QUESTION (id,user_id, property_id, content, created_at)
VALUES(13, 3, 22, 'Oops! never mind, i am not interested anymore...', '2021-01-12');


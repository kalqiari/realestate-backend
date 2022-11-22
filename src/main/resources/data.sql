
-- APPLICATION

INSERT INTO APPLICATION (applicationId, applicationType, employmentInfo, creditScore, reviewStatus, droppedAt, createAt, reviewedAt, deletedAt)
VALUES (1,  'Rent' , 'unemployment', 300, 'Rejected', 09/11/2020, 10/12/2021, 11/1/2022, 12/2/2022 );

INSERT INTO APPLICATION (applicationId, applicationType, employmentInfo, creditScore, reviewStatus, droppedAt, createAt, reviewedAt, deletedAt)
VALUES (2,  'Buy' , 'employment', 700, 'Approved', 08/12/2020, 09/1/2021, 10/2/2022, 15/9/2022 );

-- PHOTO

INSERT INTO PHOTO (id,url,propertyId,deletedAt)
VALUES (1, 'https://photos.zillowstatic.com/fp/c16f87f0d72f81d924545ecbd2b6c60a-cc_ft_1536.webp',  11/11/2022);

INSERT INTO PHOTO (id,url,propertyId,deletedAt)
VALUES(1, 'https://photos.zillowstatic.com/fp/516277f76745f190c92f766ff6c1f59b-cc_ft_1536.webp',  12/11/2022);

--FAVORITE

INSERT INTO  FAVORITE(id, createAt)
VALUES (1,  12/12/2022);

INSERT INTO FAVORITE (id, createAt)
VALUES (2,  11/11/2022);

--LOG
INSERT INTO LOG (id, principal, operation, endPoint, method, requestTime, params )
VALUES (1,  'umur', 'getById', 'findById', 'sample', 10:00, 11);

INSERT INTO LOG (id, principal, operation, endPoint, method, requestTime, params)
VALUES (2,  'umur' , 'getById', 'findById', 'sample', 11:00, 12 );



-- USERS

INSERT INTO users (id, firstName,lastName,email,phoneNumber,streetAddress,address2,city,state,zipcode,deactivate_at,create_at,deleted_at)
VALUES (011, 'umur', 'inan', 'uinan@miu.edu','(641)-123490','1000N 4th Street','FairwayApartments','Chicago', 'Illinois','53901',00/00/0000,12/12/2022,0/00/0000 );

INSERT INTO users (id, firstName,lastName,email,phoneNumber,streetAddress,address2,city,state,zipcode,deactivate_at,create_at,deleted_at)
VALUES (012,'john', 'doe', 'john@miu.edu','(800)-891901','124E 10th Street','Mansion Lane', 'Fairfield','Iowa','52557',00/00/0000, 23/3/2019, 00/00/0000);

INSERT INTO users (id, firstName, lastName, email, phoneNumber, streetAddress, address2, city, state, zipcode, deactivate_at, create_at, deleted_at, role_id)
VALUES (1234, 'Keven', 'prince', 'keven@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, 0, 0, 0 );

INSERT INTO users (id, firstName, lastName, email, phoneNumber, streetAddress, address2, city, state, zipcode, deactivate_at, create_at, deleted_at, role_id)
VALUES (1235, 'Keven', 'prince', 'keven@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, 0, 0, 0 );

INSERT INTO users (id, firstName, lastName, email, phoneNumber, streetAddress, address2, city, state, zipcode, deactivate_at, create_at, deleted_at, role_id)
VALUES (1236, 'Keven', 'prince', 'keven@miu.edu', 'miu', 'fairfield', 'fairfield', 'iowa', 'US', 52557, 0, 0, 0 );

--ROLE
INSERT INTO role (id, name)
VALUES(11, 'User')

INSERT INTO role (id, name)
VALUES(12, 'Admin')

--QUESTION
INSERT INTO role (id,userId, propertyId, content, createdAt)
VALUES(22, 11, 309, 'can i pass by on Wednesday afternoon to tour the apartment?',12/5/2022)

INSERT INTO role (id,userId, propertyId, content, createdAt)
VALUES(32, 11, 309, 'Oops! never mind, i am not interested anymore...', 13/5/2022)

--PROPERTY
INSERT INTO property(id, ownerId, streetAddress, address2, city, state, zipcode, listingType,description, price, homeType, sqFt, bedrooms, bathrooms, pool, parkingType, parkingSpaces, floorType, yearBuilt,isBuiltComplete, listedAt, deletedAt )
VALUES(642, 1110, '236W 1st St','Curry Lane','Beverly Hills', 'California', '230089', '')

INSERT INTO property(id, ownerId, streetAddress, address2, city, state, zipcode, listingType,description, price, homeType, sqFt, bedrooms, bathrooms, pool, parkingType, parkingSpaces, floorType, yearBuilt,isBuiltComplete, listedAt, deletedAt )
VALUES()


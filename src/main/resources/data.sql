
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



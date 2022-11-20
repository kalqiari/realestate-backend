# realestate-backend
WAA Final Project

** Technologies:
- Spring boot.
- SMTP Server (Gmail).
- AWS S3.
- Keycloak.
- PostgreSQL. (AWS).
- RabbitMQ.

** Main Controllers 
- Admin
  -- Users 
  -- Propperty
  -- Report
- Owner
  -- Propperty 
  -- Application 
  -- Questions 
- Customer
  -- Propperty 
  -- Favorites
  -- Questions 
  -- Application
- Viewer
  -- Propperty

** Logging 
 - All post, put and delete actions

** Mailers 
 - Submit Appliaction Email for Owner.
 - Question Email.


** Database
- User 
- Role
- Propperty
- Question 
- Favorite
- Application
- Photo


** User: 
 - id
 - First Name
 - Last Name
 - email 
 - phone number
 - street addres 
 - addres2
 - city 
 - state
 - zipcode
 - role_id
 - deactived_at
 - created_at
 - deleted_at

** Role
  - id
  - name
 
** Propperty
 - id
 - owner_id
 - street addres 
 - addres2
 - city 
 - state
 - zipcode
 - listing_type ["Sale", "Rent"] 
 - description
 - price
 - home_type
 - sqFT 
 - bedrooms 
 - pathrooms
 - pool (true, false)
 - parking_type ["Open", "Closed"]
 - parking_spaces [Number]
 - flooringType ["Carpet", "Wooden Flooring"],
 - year_built
 - is_purchase_complete [Boolean]
 - listed_at
 - deleted_at

** Photo
 - id 
 - url
 - propperty_id
 - deleted_at

** Question 
 - id
 - user_id
 - propperty_id
 - content
 - created_at

** Favorite
 - id 
 - user_id
 - propperty_id
 - created_at

** Application 
 - id
 - propperty_id
 - user_id 
 - application_type ["Buy", "Rent", "Tour"]
 - employment_info
 - credit_score    ,
 - message
 - schedule_date
 - review_status ["Approved", "Rejected", "UnderReview"],
 - dropd_at 
 - created_at
 - reviewed_at
 - deleted_at 


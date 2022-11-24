# Real Estate Backend (WAA Final Project)

## Technologies:
- Spring boot.
- SMTP Server (Gmail).
- AWS S3.
- Keycloak.
- PostgreSQL. (AWS).
- RabbitMQ.

## Main Controllers 
- ### Admin
  - Users 
  - Property
  - Report
- ### Owner
  - Property 
  - Application 
  - Question 
- ### Customer
  - Property 
  - Favorite
  - Question 
  - Application
- ### Viewer
  - Property

## Logging 
 - All post, put and delete actions

## Mailers 
 - Submit Application Email for Owner.
 - Question Email.


# Database 
- User 
- Role
- Property
- Question 
- Favorite
- Application
- Photo


### User: 
 - id
 - First Name
 - Last Name
 - email 
 - phone number
 - street address 
 - address2
 - city 
 - state
 - zipcode
 - role_id
 - deactivated_at
 - created_at
 - deleted_at

### Role
  - id
  - name
 
### Property
 - id
 - owner_id
 - street_address 
 - address2
 - city 
 - state
 - zipcode
 - propertyStatus['sold', 'rented', 'pending']
 - listing_type ["Sale", "Rent"] 
 - description
 - price
 - home_type
 - sqFT 
 - bedrooms 
 - bathrooms
 - pool (true, false)
 - parking_type ["Open", "Closed"]
 - parking_spaces [Number]
 - flooringType ["Carpet", "Wooden Flooring"],
 - year_built
 - is_purchase_complete [Boolean]
 - listed_at
 - deleted_at
 - soldRentedAt

### Photo
 - id 
 - url
 - property_id
 - deleted_at

### Question 
 - id
 - user_id
 - property_id
 - content
 - created_at

### Favorite
 - id 
 - user_id
 - property_id
 - created_at

### Application 
 - id
 - property_id
 - user_id 
 - application_type ["Buy", "Rent", "Tour"]
 - employment_info
 - credit_score    ,
 - message
 - schedule_date
 - review_status ["Approved", "Rejected", "UnderReview"],
 - dropped_at 
 - created_at
 - reviewed_at
 - deleted_at 


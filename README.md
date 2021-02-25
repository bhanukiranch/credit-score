Credit Score Engine in Spring Boot App

## Database and Service
### Database Schema Design
- H2 
- Init Script For Reference Data

## Service takes the SSN Number Input

## Steps to Run the App
1. Credit Score Engine
The application should be run at http://localhost:8081/
###### This service returns the credit score based on SSN

##### Get Score
`GET http://localhost:8081/api/v1/credit/score/549214994`

###### Response
`{
     "ssnNumber": "549214994",
     "score": 690
 }`



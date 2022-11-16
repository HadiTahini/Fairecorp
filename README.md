# Fairecorp Java Spring Boot

## Smart Building application
Developed by Hadi Tahini (CPS2)

## Classes devloped:

- Building, Room, Window, Heater(modelization classes)
- Dto(Data Transfer Object) for Room, Window and Heater
- Dao(Data Access Object) for Room, Window and Heater
- CustomDao Implementaion for Room, Window and Heater
- Rest Controllers for each model

## Tests:

Bunch of tests were implemented for Room, Heater, Window Daos as well as for their Controllers.

I used an external api which will get the temperature from outside the building(emse). This Api take the lat and lon for a city at get it's temperature(I used lat and lon for Saint-Etienne).
The link of the api: http://ws1.metcheck.com/ENGINE/v9_0/json.asp?lat=45.4397&lon=4.3872&lid=244764&Fc=No
The time isn't enough to implement a lot of features so I didn't use this api directly inside my application.

All apis are tested via Swagger.

All the apis are working fine but their tests didn't work properly due to an unexpected error. I think in their logic they should work fine.

The security Controller and it's Configuration are working successffuly.

# Login
## user cred:
- username: user
- password: user

## admin cred:
- usernmae: admin
- password: admin

It's possible to test the application through clevercloud on this link:
https://haditahini.cleverapps.io/swagger-ui/index.html

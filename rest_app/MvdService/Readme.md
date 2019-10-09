# Инструкция по запуску сервиса отправки заявок в МВД для проверки паспортных данных

Запустить файл dep_service.cmd (java -jar target/mvdservice-2.0.jar)

curl -X POST http://localhost:8082/auth/signin -H "Content-Type:application/json" -d "{\"username\":\"user\", \"password\":\"password\"}"

Ответ : 
{
  "username" : "user",
  "token" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A"
}


<b>1. POST Запрос http://localhost:8082/api/service/search

<b>Формат запроса : </b>

curl -X POST "http://localhost:8082/api/request/search" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer < TOKEN >" -d "{ \"ser\": \"< value >\", \"num\": \"< value >\" }"

где :
	"ser" - серия паспорта клиента 
	"num" - номер паспорта клиента 

<b>Формат ответа : </b>

{
  "errorCode": 0,
  "errorText": [
    "string"
  ]
}

где :
   "errorCode" - код ошибки
	   "errorCode": 0 - успешно
	   "errorCode": 1 - ошибка, в поле "errorText" указывается описание ошибки, например : 
	   "errorText" - тест ошибки

<b>Примеры : </b>

{
  "errorCode": 0,
  "passport": {
    "id": 3,
    "ser": "1683",
    "number": "485920",
    "mvd": {
      "id": 3,
      "depname": "ПВС УВД г. Армавира",
      "code": "254-125"
    },
    "issuedate": "2007-09-23T20:00:00.000+0000",
    "lastname": "Пантелеев",
    "name": "Сергей",
    "pat": "Сергеевич",
    "active": false
  },
  "errorText": null
}

{
  "errorCode": 1,
  "passport": null,
  "errorText": [
    "База МВД : паспорт не найден"
  ]
}
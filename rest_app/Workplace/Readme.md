# Инструкция по обрабоке заявок в Ведомстве

Запустить файл workplace_3.cmd (java -jar target/workplace-2.0.jar)

<b>Получение токена : </b>

curl -X POST http://localhost:8081/auth/signin -H "Content-Type:application/json" -d "{\"username\":\"user\", \"password\":\"password\"}"

Ответ : 
{
  "username" : "user",
  "token" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A"
}


<b>1. POST Запрос http://localhost:8081/api/request/search - поиск заявок с сортировкой выбранного результата по номеру поля</b>

Формат запроса : 

curl -X POST "http://localhost:8081/api/request/search" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer < TOKEN >" 
-d "{ \"date\": \"< value >\", \"fio\": \"< value >\", \"orderIndex\": < value >, \"searchType\": \"< value >\", 
\"service\": \"< value >\", \"state\": \"< value >\"}"

где :

  "searchType" - наименование поля, по которому производится поиск (
	"date" - по дате завки, 
	"fio" - по ФИО пользователя, 
	"service" - по наименованию услуги, 
	"state" - по статусу заявки
  )
  "date": - значение даты заявки для поиска
  "fio": - текст начала ФИО для поиска
  "service": - наименования услуги
  "state": - статус заявки ("active", "inactive", "all")
  "orderIndex" - индекс поля для сортировки (1..4)

<b>Формат ответа : </b>

{
  "errorCode": 0,
  "errorText": [
    "string"
  ],
  "resultList": [
    {}
  ]
}
где :
   "errorCode" - код ошибки
	   "errorCode": 0 - успешно
	   "errorCode": 1 - ошибка в данных при отправки запроса, в поле "errorText" указывается описание ошибки: 
   "errorText" - тест ошибки
   "resultList" - массив найденных и отсортированных заявок

<b>Пример </b>

<b>Запрос : </b>

curl -X POST "http://localhost:8081/api/request/search" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A" 
-d "{ \"orderIndex\": 2, \"searchType\": \"state\", \"state\": \"all\"}"

<b>Ответ : </b>

{
  "errorCode": 0,
  "resultList": [
    [
      1,
      "Услуга № 1",
      "2019-10-07",
      "Сидорова Ирина Семеновна",
      "Активна"
    ],
    [
      3,
      "Услуга № 3",
      "2019-10-05",
      "Пантелеев Сергей Сергеевич",
      "Активна"
    ],
    [
      2,
      "Услуга № 2",
      "2019-10-06",
      "Иванов Иван Петрович",
      "Закрыта"
    ]
  ],
  "errorText": null
}

<b>2. GET Запрос http://localhost:8081/api/request/api/request/detailed - детализация заявки</b>

<b>Формат запроса : </b>

curl -X GET "http://localhost:8081/api/request/detailed" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer < TOKEN >" 
-d "{ \"id\": < value >}"

где :

  "id" - идентификатор заявки

<b>Формат ответа : </b>

{
  "errorCode": 0,
  "errorText": [
    "string"
  ],
  "result": {
    "attachments": [
      {
        "description": "string",
        "name": "string"
      }
    ],
    "date": "string",
    "id": 0,
    "passport": {
      "code": "string",
      "depname": "string",
      "issuedate": "string",
      "lastname": "string",
      "name": "string",
      "number": 0,
      "pat": "string",
      "ser": 0
    },
    "serviceName": "string",
    "terminated": true
  }
}

<b>Пример : </b>

<b>Запрос:</b>

curl -X GET "http://localhost:8081/api/request/detailed" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A" 
-d "{ \"id\": 1}"

<b>Ответ: </b>

{
  "errorCode": 0,
  "result": {
    "id": 1,
    "date": "07-10-2019",
    "terminated": false,
    "passport": {
      "ser": 2804,
      "number": 352379,
      "depname": "ПВС Центрального округа г. Краснодара",
      "code": "232-005",
      "issuedate": "02.04.1998",
      "lastname": "Сидорова",
      "name": "Ирина",
      "pat": "Семеновна"
    },
    "serviceName": "Услуга № 1",
    "attachments": [
      {
        "name": "8eb3a28e-cf8d-4e21-a7f8-6502644b8384.jpg",
        "description": "Описание № 2"
      },
      {
        "name": "381d01ef-4448-4570-8da0-e0399d5ee891.jpg",
        "description": "Описание № 1"
      }
    ]
  },
  "errorText": null
}

<b>3. POST Запрос http://localhost:8081/api/request/terminate - терминация заявки </b>

Формат запроса : 

curl -X GET "http://localhost:8081/api/request/terminate" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer < TOKEN >" 
-d "{ \"id\": < value >}"

где :

  "id" - идентификатор заявки

<b>Формат ответа : </b>

{
  "errorCode": 0,
  "errorText": "string"
}

<b>Пример </b>

<b>Запрос: </b>

curl -X GET "http://localhost:8081/api/request/terminate" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A" 
-d "{ \"id\": 1}"

<b>Ответ: </b>

{
  "errorCode": 0,
  "errorText": "Запись терминирована"
}
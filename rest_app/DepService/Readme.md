# Инструкция по запуску сервиса отправки заявок в Департамент для проверки валидности услуг

Запустить файл dep_service.cmd (java -jar target/depservice-2.0.jar)

<b>Получение токена : </b>

curl -X POST http://localhost:8083/auth/signin -H "Content-Type:application/json" -d "{\"username\":\"user\", \"password\":\"password\"}"

Ответ : 
{
  "username" : "user",
  "token" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU3MDQzMDcyNiwiZXhwIjoxNTcwNDM0MzI2fQ.6FaErdIi_7DEf-ukRhPmlocnaW5MwDxcEB982MHcr4A"
}

<b>1. POST Запрос http://localhost:8083/api/service/search</b>

<b>Формат запроса : </b>

curl -X POST "http://localhost:8083/api/request/search" -H "accept: */*" -H "Content-Type:application/json" 
-H "Authorization: Bearer < TOKEN >" -d { \"name\": \"< value >\" }

где :
  "name" - наименование услуги

<b>Формат ответа : </b>

{
  "errorCode": 0
}

где :
   "errorCode" - код ошибки
	   "errorCode": 0 - услуга найдена в Департаменте
	   "errorCode": 1 - услуга не найдена в Департаменте

<b>Пример :</b>

{
  "errorCode": 1
}
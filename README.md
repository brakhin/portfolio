# Репозиторий наиболее интересных проектов, реализованных во время обучения на курсе job4j

<h2>1. Парсер вакансий на sql.ru (Quartz, Jsoup, JDBC, PostgreSQL, Многопоточность)</h2>
<br><a href="https://github.com/brakhin/portfolio/tree/master/sqlru_parser/src/main/java/ru/bgbrakhi/sql/jobparser">Ссылка</a> 

<h2>2. Сервис покупки билетов в кинотеатр (PostgreSQL, JDBC, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
<br><a href="https://github.com/brakhin/portfolio/tree/master/servlets_cinema">Ссылка</a> 

<h2>3. Приложение "список дел" (PostgreSQL, Hibernate, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
<br><a href="https://github.com/brakhin/portfolio/tree/master/todolist_hibernate">Ссылка</a> 
 
<h2>4. Приложение "площадка продажи машин" (PostgreSQL, Hibernate, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
<br><a href="https://github.com/brakhin/portfolio/tree/master/carseller_hibernate">Ссылка</a> 
 
<h2>5. Приложение "площадка продажи машин" (SPRING) (Spring MVC, Spring Data, Spring Security, Spring Boot, Hibernate, PostgreSQL, Ajax, BootStrap, Thymeleaf)</h2>
<br><a href="https://github.com/brakhin/portfolio/tree/master/carseller_spring">Ссылка</a> 

<h2>6. Пример реaлизации RESTful приложения с использованием микросервисной архитектуры и SpringSecurity</h2>

1. Пользователь отправляет заявку по оказанию услуги в Ведомство. Заявка содержит паспортые данные пользователя, приложенные документы
2. Специалист Ведомства видит список пришедших заявок, может искать и сортировать по дате, имени заявителя, названю услуги, статусу заявки, видит детализацию по выбранной заявке, может исполнить заявку, терминировав ее

Назначение каталогов Проекта : 

- <b>MvdService</b> - сервис проверки корректности паспортных данных 

- <b>DepService</b> - сервис проверки корректности услуги

- <b>Receiver</b> - сервис приема заявок от пользователей. Использует MvdService и DepService как микросервисы для проверки корректности данных. Корректные данные записываются в БД<br>
  Подкаталог <b>test_json_data</b> содержит демонстрации данные для отправки JSON-запросов<br>
  Подкаталог <b>attached_docs содержит</b> полученные изображения приложенных документов.

- <b>Workplace</b> - сервис реализации рабочего места на стороне Министерства для работы с заявками, сохраненными в БД. Использует авторизацию SpringSecurity на основе JWT (JSON Web Token)

<br><a href="https://github.com/brakhin/portfolio/tree/master/rest_app">Ссылка</a> 




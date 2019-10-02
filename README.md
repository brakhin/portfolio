# Репозиторий наиболее интересных проектов, реализованных во время обучения на курсе job4j

<h2>1. Парсер вакансий на sql.ru (Quartz, Jsoup, JDBC, PostgreSQL, Многопоточность)</h2>
Постановка задачи:
<br>1. Реализовать модуль сборки анализа данных с sql.ru.
<br>2. Система должна использовать Jsoup для парсинга страниц.
<br>3. Система должна запускаться раз в день.
<br>4. Система должна собирать данные только про вакансии Java.
<br>5. Данные должны храниться в базе данных. 
<br>6. Учесть дубликаты. Вакансии с одинаковым именем считаются дубликатами.
<br>7. Учитывать время последнего запуска. если это первый запуск. то нужно собрать все объявления с начало года.
<br>8. В системе не должно быть ввода-вывода информации, все настройки берутся из файла app.properties.   
   
<br><a href="https://github.com/brakhin/portfolio/blob/master/2_sql/src/main/java/ru/bgbrakhi/sql/jobparser/SqlRuParser.java">Основной модуль</a>
<br><a href="https://github.com/brakhin/portfolio/tree/master/2_sql/src/main/java/ru/bgbrakhi/sql/jobparser">Ссылка</a> 
<h3>Скриншот</h3>
<img src="2_sql/Screenshot.jpg">

<h2>2. Сервис покупки билетов в кинотеатр (PostgreSQL, JDBC, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
Постановка задачи:
<br>Разработать простой веб сайт по покупки билетов в кинотеатр.
<br><a href="https://github.com/brakhin/portfolio/tree/master/3_servlets_cinema">Ссылка</a> 
<h3>Выбор места</h3>
<img src="3_servlets_cinema/Screenshot1.jpg">
<h3>Покупка билета</h3>
<img src="3_servlets_cinema/Screenshot2.jpg">
<h3>Отображение выбранного места как купленного</h3>
<img src="3_servlets_cinema/Screenshot3.jpg">

<h2>3. Приложение "список дел" (PostgreSQL, Hibernate, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
Постановка задачи:
Cоздать простое приложение todolist.
1. веб-приложение должно иметь одну страницу index.html. 
2. все данные на форму загружаються через ajax.
3. данные должны сохраняться через hibernate.
<br><a href="https://github.com/brakhin/portfolio/tree/master/3_hibernate">Ссылка</a> 
<h3>Общий вид</h3>
<img src="3_hibernate/Screenshot_1.jpg">
<h3>Фильтрация активных записей</h3>
<img src="3_hibernate/Screenshot_2.jpg">
 
<h2>4. Приложение "площадка продажи машин" (PostgreSQL, Hibernate, JavaServlet, ApacheTomcat, JavaScript, Ajax, BootStrap)</h2>
Постановка задачи:
Cоздать приложение удовлетворющее свойствам :
1. Основная страница содержит все объявления о продаже машин. 
2. При авторизации пользователя он заходит в свой личный кабинет, где может добавлять машины для продажи
3. В форме добавления объявления при изменении полей так же меняются списки выбора зависимых от них полей
4. Если в форме добавления объявления значения нет в выпадающем списке, вводится новое значение.
5. Только пользователь, создавший объявление, мжет активировать (деактивировать) его.
6. Используется Hibernate Mapping.
<br><a href="https://github.com/brakhin/portfolio/tree/master/3_hibernate_carseller">Ссылка</a> 
<h3>Общий вид</h3>
<img src="3_hibernate_carseller/Screenshot1.jpg">
<h3>Поиск</h3>
<img src="3_hibernate_carseller/Screenshot2.jpg">
<h3>Авторизация(регистрация) пользователя</h3>
<img src="3_hibernate_carseller/Screenshot3.jpg">
<h3>Личный кабинет пользователя</h3>
<img src="3_hibernate_carseller/Screenshot4.jpg">
 
<h2>5. Приложение "площадка продажи машин" (SPRING) (Spring MVC, Spring Data, Spring Security, Spring Boot, Hibernate, PostgreSQL, Ajax, BootStrap, Thymeleaf)</h2>
Постановка задачи:
Cоздать приложение удовлетворющее свойствам :
1. Основная страница содержит все объявления о продаже машин. 
2. При авторизации пользователя он заходит в свой личный кабинет, где может добавлять машины для продажи
3. В форме добавления объявления при изменении полей так же меняются списки выбора зависимых от них полей
4. Если в форме добавления объявления значения нет в выпадающем списке, вводится новое значение.
5. Только пользователь, создавший объявление, мжет активировать (деактивировать) его.
6. Используется Spring.
7. Добавлена форма регистрации пользователей с валидацией ввода на стороне сервера.
8. Реализована локализация текста ошибок валидации формы регистрации.
<br><a href="https://github.com/brakhin/portfolio/tree/master/3_hibernate_carseller">Ссылка</a> 
<h3>Регистрация пользователя</h3>
<img src="3_spring_boot/Screenshot1.jpg">
<h3>Личный кабинет пользователя</h3>
<img src="3_spring_boot/Screenshot2.jpg">
<h3>Авторизация пользователя</h3>
<img src="3_spring_boot/Screenshot3.jpg">
<h3>Общий вид</h3>
<img src="3_spring_boot/Screenshot4.jpg">
<h3>Поиск</h3>
<img src="3_spring_boot/Screenshot5.jpg">

# Project
В приложении проектный менеджер реализована аутентификация для пользователей с помощью Spring Security.

База данных с таблицами и первоначальными данными располагается в докер-контейнере и поднимается с помощью команды "docker-compose up". Во вкладке "database" в Intellij Idea создаем базу данных postgresql.

Запускаем приложение. Нужные эндпоинты можно дергать либо в директории test/resource, либо прилагается Postman-коллекция. Сначала логинимся по ссылке localhost:8080/auth, получаем токен и ходим с ним в другие эндпоинты. Разные эндпоинты доступны для разных ролей.

### Задача: Разработка системы управления задачами (Task Management System)

#### Описание
Вам нужно разработать систему управления задачами, которая позволяет пользователям создавать, назначать, обновлять и завершать задачи. Система должна иметь возможность работы с пользователями, задачами и командами, а также предоставлять API для взаимодействия с этими данными.

#### Требования

1. **Создание Spring Boot проекта**:
    - Используйте Spring Initializr для создания нового проекта с зависимостями Spring Web, Spring Data JPA, Spring Security, Spring Boot Actuator и базой данных (например, H2 для упрощения).

2. **Модели данных**:
    - **User**: пользователь системы
        - `id`: уникальный идентификатор пользователя
        - `username`: имя пользователя
        - `password`: пароль пользователя
        - `email`: адрес электронной почты пользователя
    - **Task**: задача
        - `id`: уникальный идентификатор задачи
        - `title`: название задачи
        - `description`: описание задачи
        - `assignedTo`: пользователь, которому назначена задача
        - `status`: статус задачи (например, NEW, IN_PROGRESS, DONE)
        - `createdDate`: дата создания задачи
        - `dueDate`: срок выполнения задачи
    - **Team**: команда (дополнительно)
        - `id`: уникальный идентификатор команды
        - `name`: название команды
        - `members`: список пользователей, входящих в команду

3. **Репозитории**:
    - Создайте репозитории для управления данными пользователей, задач и команд.

4. **Сервис**:
    - Создайте сервисные классы для выполнения бизнес-логики, связанной с пользователями, задачами и командами.
    - Реализуйте методы для управления задачами, включая создание, назначение, обновление и завершение задач.

5. **Контроллеры**:
    - Создайте контроллеры для обработки HTTP-запросов, связанных с пользователями, задачами и командами.
    - Реализуйте аутентификацию и авторизацию с использованием Spring Security.
    - Реализуйте методы для получения, создания, обновления и удаления задач.

6. **Обработчик исключений**:
    - Реализуйте обработку ошибок и исключений, чтобы API возвращало соответствующие коды статуса и сообщения об ошибках.

7. **Тестирование**:
    - Напишите интеграционные тесты для проверки функциональности вашего API, используя JUnit и Spring Boot Test.

8. **Документация**:
    - Используйте Swagger/OpenAPI для автоматической генерации документации вашего API.

9. **Метрики и мониторинг**:
    - Настройте Spring Boot Actuator для мониторинга приложения.

#### Пример структуры проекта

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── taskmanager
│   │               ├── controller
│   │               │   ├── UserController.java
│   │               │   ├── TaskController.java
│   │               │   └── TeamController.java
│   │               ├── model
│   │               │   ├── User.java
│   │               │   ├── Task.java
│   │               │   └── Team.java
│   │               ├── repository
│   │               │   ├── UserRepository.java
│   │               │   ├── TaskRepository.java
│   │               │   └── TeamRepository.java
│   │               ├── service
│   │               │   ├── UserService.java
│   │               │   ├── TaskService.java
│   │               │   └── TeamService.java
│   │               ├── security
│   │               │   ├── SecurityConfig.java
│   │               │   └── JwtUtil.java
│   │               └── TaskManagerApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── example
                └── taskmanager
                    └── TaskManagerApplicationTests.java
```

#### Подсказки и ресурсы

- Используйте [Spring Initializr](https://start.spring.io/) для создания базового проекта.
- Изучите [документацию по Spring Data JPA](https://spring.io/projects/spring-data-jpa) для понимания работы с JPA репозиториями.
- Ознакомьтесь с [гайдом по созданию REST API с использованием Spring Boot](https://spring.io/guides/gs/rest-service/) для примера создания контроллеров.
- Используйте [Spring Security](https://spring.io/projects/spring-security) для реализации аутентификации и авторизации.
- Используйте [Swagger](https://springfox.github.io/springfox/docs/current/) для документирования API.
- Настройте [Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/) для мониторинга приложения.

Эта задача охватывает более сложную структуру с множеством сущностей (пользователи, задачи, команды), что позволит вам углубленно изучить возможности Spring Boot, включая безопасность, взаимодействие с базой данных и разработку RESTful API.
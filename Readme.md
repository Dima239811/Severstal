# Настройки БД

Перед запуском необходимо в файле `main/resources/application.properties`
сменить настройки для подключения к вашей БД.

При включённой настройке `spring.jpa.hibernate.ddl-auto=update` таблицы будут
созданы автоматически при первом запуске приложения.

### Порты по умолчанию

Бэкенд : `8080` \
БД: `5432`

## Swagger

Swagger-UI доступен по ссылке [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)


Типы продуктов: [enum](src/main/java/org/severstal/enums/ProductType.java)

Виды продуктов: [enum](src/main/java/org/severstal/enums/ProductKind.java)
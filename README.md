# Сервис авторизации
### Листеренко Ольга Руслановна, БПИ217
Открыть Swagger можно по адресу http://localhost:8000/swagger-ui/index.html  
В программе реализованы все необходимые операции. Пароль при регистрации хэшируется
с помощью Argon2, токены генерируются с помощью Jwts. Токены содержат информацию о 
почте, роли, а также дате создания и окончания действия.
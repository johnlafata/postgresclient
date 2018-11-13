
```
cf cs postgresql-10-odb general pg-test -c postgres-conf.json
```
or
```
cf create-service azure-postgresqldb basic50 pg-test
```
then
```
cf push --no-start
cf bind-service crunchyClient pg-test
cf restage crunchyClient
```
after the application is running
edit the file: src/main/resources/application.properties

change spring.jpa.hibernate.ddl-auto value to validate

 #for first push
 #spring.jpa.hibernate.ddl-auto=create-drop
 #for subsequent pushes
 spring.jpa.hibernate.ddl-auto=validate

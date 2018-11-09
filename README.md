cf cs postgresql-10-odb general pg-test -c postgres-conf.json
cf bind-service crunchy-demo pg-test
cf restage crunchy-demo

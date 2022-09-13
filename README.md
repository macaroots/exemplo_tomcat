# exemplo_tomcat

Exemplo Tomcat + MySQL + Maven + Docker + Websocket + jLEA

1. Clonar repositório:
```
git clone https://github.com/macaroots/exemplo_tomcat.git
```

2. Compilar classes:
```
mvn compile
```

3. Ligar serviços com Docker Compose:
```
docker-compose up -d
```
* ```-d``` de Detach é opcional.
* Talvez seja necesário permissão de super-usuário (```sudo```).

4. Acessar pelo navegador web:
```
http://localhost/LEA
```

## Resolução de problemas

1. Verifique se o banco de dados e o usuário foram criados.
2. Se necessário, reinicie os containers.

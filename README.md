# exemplo_tomcat

Exemplo Tomcat + MySQL + Maven + Docker + Websocket + MInD

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
http://localhost:8080
```

FROM nginx:mainline-alpine

RUN mkdir -p /etc/nginx/certs
RUN apk --update --no-cache add openssl && \
    openssl req -x509 -nodes -days 365 \
    -subj  "/C=BR/ST=CE/O=Local/CN=localhost" \
     -newkey rsa:2048 -keyout /etc/nginx/certs/selfsigned.key \
     -out /etc/nginx/certs/selfsigned.crt;

#!/usr/bin/env bash
exec java -Djava.security.egd=file:/dev/./urandom $BOOTAPP_JAVA_OPTS -jar  -Dspring.profiles.active=$ENV_NAME $BOOTAPP_PATH --server.port=$SERVER_PORT > /dev/stdout 2>&1

#!/bin/bash
java -Xms${JVM_XMS} -Xmx${JVM_XMX} -XX:NewSize=${NEW_SIZE} -XX:MaxNewSize=${MAX_NEW_SIZE} \
-XX:MinHeapFreeRatio=${MIN_HEAP_FREE_RATIO} -XX:MaxHeapFreeRatio=${MAX_HEAP_FREE_RATIO} \
-Dlogging.level=${SPRING_LOGGING_LEVEL} -Duser.timezone=America/Sao_Paulo -Dspring.profiles.active=${PROFILE} \
-d64 -XX:+USeG1GC -noverify -jar app.jar --server.port=${PORT}

#XX:GCTimeRatio -> 1/n -> proporção que o GB será invocado
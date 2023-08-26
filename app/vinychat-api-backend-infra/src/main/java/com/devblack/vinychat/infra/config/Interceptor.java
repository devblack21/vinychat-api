package com.devblack.vinychat.infra.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
import java.util.Objects;

public class Interceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(final ServerHttpRequest serverHttpRequest,
                                   final ServerHttpResponse serverHttpResponse,
                                   final WebSocketHandler webSocketHandler,
                                   final Map<String, Object> map) {


        //!Objects.equals(serverHttpRequest.getHeaders().getOrigin(), "http://localhost:42002");

        return true;
    }

    @Override
    public void afterHandshake(final ServerHttpRequest serverHttpRequest,
                               final ServerHttpResponse serverHttpResponse,
                               final WebSocketHandler webSocketHandler,
                               final Exception e) {

    }
}

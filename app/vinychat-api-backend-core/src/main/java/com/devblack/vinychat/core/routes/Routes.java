package com.devblack.vinychat.core.routes;

public interface Routes {
    String MESSAGE_ROUTE_MAPPING = "/message";
    String CONNECTION_ROUTE_MAPPING = "/connection";
    String BACKUP_MESSAGES = "/backup/{ticket}";
    String SEND_MESSAGE = "/send";
    String FIRST_CONNECTION = "/first/connect";
    String QUEUE_MESSAGE = MESSAGE_ROUTE_MAPPING + "/queue/";
    String HANDSHAKE = "/handshake";

}

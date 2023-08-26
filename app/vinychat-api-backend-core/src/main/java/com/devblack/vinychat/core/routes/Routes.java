package com.devblack.vinychat.core.routes;

public interface Routes {
    String BACKUP_MESSAGES = "/message/backup/{ticket}";
    String SEND_MESSAGE = "/message/send";
    String FIRST_CONNECTION = "/connection/first/connect";
    String QUEUE_MESSAGE = "/message/queue/";
    String HANDSHAKE = "/handshake";

}

package com.leoncarraro.clientsopenfeign.clients.notificationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "NOTIFICATION-SERVICE", path = "/api/notifications")
public interface NotificationServiceClient {

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendNotification(@RequestBody NotificationVO notificationVO);

}

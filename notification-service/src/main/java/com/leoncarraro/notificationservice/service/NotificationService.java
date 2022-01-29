package com.leoncarraro.notificationservice.service;

import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.notificationservice.domain.entity.Notification;
import com.leoncarraro.notificationservice.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationVO notificationVO) {
        Notification notification = Notification.builder()
                .customerId(notificationVO.getCustomerId())
                .message(notificationVO.getMessage())
                .sent(true)
                .build();

        notificationRepository.save(notification);
    }

}

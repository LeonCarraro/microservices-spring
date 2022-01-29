package com.leoncarraro.clientsopenfeign.clients.notificationservice;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationVO {

    private Long customerId;

    private String message;

}

package com.leoncarraro.notificationservice.domain.entity;

import com.leoncarraro.notificationservice.constant.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = DatabaseConstants.SCHEMA_NOTIFICATION_SERVICE, name = DatabaseConstants.TABLE_NOTIFICATION)
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String message;

    private boolean sent;

}

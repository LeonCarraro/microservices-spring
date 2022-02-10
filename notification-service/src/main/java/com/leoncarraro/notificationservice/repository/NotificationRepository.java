package com.leoncarraro.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoncarraro.notificationservice.domain.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {}

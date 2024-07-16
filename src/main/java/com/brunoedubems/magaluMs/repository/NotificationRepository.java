package com.brunoedubems.magaluMs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoedubems.magaluMs.entity.Notification;
import com.brunoedubems.magaluMs.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
   List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime datetime);
}

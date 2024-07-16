package com.brunoedubems.magaluMs.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


import org.springframework.stereotype.Service;

import com.brunoedubems.magaluMs.controller.DTO.ScheduleNotificationDTO;
import com.brunoedubems.magaluMs.entity.Notification;
import com.brunoedubems.magaluMs.entity.Status;
import com.brunoedubems.magaluMs.repository.NotificationRepository;

@Service
public class NotificationService {

private final NotificationRepository notificationRepository;

public NotificationService(NotificationRepository notificationRepository){
    this.notificationRepository = notificationRepository;
}


public void ScheduleNotification(ScheduleNotificationDTO dto){
    notificationRepository.save(dto.toNotification());
}


public Optional<Notification> findById(Long notificationId){
    return  notificationRepository.findById(notificationId);
}

public void cancelNotification(Long notificationId){
    var notification = findById(notificationId);
    if(notification.isPresent()){
        notification.get().setStatus(Status.Values.CANCELED.toStatus());
        notificationRepository.save(notification.get());
    }
}


public void checkAndSend(LocalDateTime dateTime){
    var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
        Status.Values.PENDING.toStatus(),
        Status.Values.ERROR.toStatus()
    ), dateTime);

    notifications.forEach(sendNotification());
}

private Consumer<Notification> sendNotification() {
    return n -> {
        // TODO - realizar o envio da notificação
        n.setStatus(Status.Values.SUCCESS.toStatus());
        notificationRepository.save(n);
    };
}


}
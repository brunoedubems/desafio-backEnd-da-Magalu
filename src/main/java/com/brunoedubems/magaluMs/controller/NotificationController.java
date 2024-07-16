package com.brunoedubems.magaluMs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.brunoedubems.magaluMs.controller.DTO.ScheduleNotificationDTO;
import com.brunoedubems.magaluMs.entity.Notification;
import com.brunoedubems.magaluMs.service.NotificationService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto) {
        notificationService.ScheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }
    
    @GetMapping("/{notificationsId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationsId") Long notificationId) {
       var notification = notificationService.findById(notificationId);
    
       if(notification.isEmpty()){
        return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(notification.get());

    }
    
    @DeleteMapping("/{notificationsId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationsId") Long notificationId) {
    notificationService.cancelNotification(notificationId);
    return ResponseEntity.noContent().build();
    }
}
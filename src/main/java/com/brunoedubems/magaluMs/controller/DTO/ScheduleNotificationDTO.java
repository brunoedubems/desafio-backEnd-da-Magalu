package com.brunoedubems.magaluMs.controller.DTO;

import java.time.LocalDateTime;

import com.brunoedubems.magaluMs.entity.Channel;
import com.brunoedubems.magaluMs.entity.Notification;
import com.brunoedubems.magaluMs.entity.Status;

public record ScheduleNotificationDTO(LocalDateTime dateTime,
String destination,
String message,
Channel.Values channel) {

public Notification toNotification(){
    return new Notification(
        dateTime,
        destination,
        message,
        channel.toChannel(),
        Status.Values.PENDING.toStatus()

    );
}

}
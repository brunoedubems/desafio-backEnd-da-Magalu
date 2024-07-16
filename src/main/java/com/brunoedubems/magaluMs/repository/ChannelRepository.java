package com.brunoedubems.magaluMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoedubems.magaluMs.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    
}

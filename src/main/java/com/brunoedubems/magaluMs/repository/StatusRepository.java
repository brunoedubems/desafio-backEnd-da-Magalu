package com.brunoedubems.magaluMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoedubems.magaluMs.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

    
}
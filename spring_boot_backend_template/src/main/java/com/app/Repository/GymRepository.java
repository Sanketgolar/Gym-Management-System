package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Gym;


public interface GymRepository extends JpaRepository<Gym, Integer> {

	
}

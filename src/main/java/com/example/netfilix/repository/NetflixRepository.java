package com.example.netfilix.repository;

import com.example.netfilix.entity.NetflixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetflixRepository extends JpaRepository<NetflixEntity, String> {
}

package me.airlobang.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.airlobang.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);
    void deleteByEmail(String email);
}


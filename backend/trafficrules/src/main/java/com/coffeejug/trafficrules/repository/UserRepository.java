package com.coffeejug.trafficrules.repository;

import com.coffeejug.trafficrules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

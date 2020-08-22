package com.coffeejug.trafficrules.repository;

import com.coffeejug.trafficrules.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

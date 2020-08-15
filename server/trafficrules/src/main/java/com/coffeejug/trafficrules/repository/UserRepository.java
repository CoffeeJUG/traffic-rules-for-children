package com.coffeejug.trafficrules.repository;

import com.coffeejug.trafficrules.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByCode(String code);

    User findByCode(String code);
}

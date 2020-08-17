package com.coffeejug.trafficrules.repository;

import com.coffeejug.trafficrules.db.Progress;
import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Integer> {

    List<ProgressProjection> findAllByUser(User user);
}

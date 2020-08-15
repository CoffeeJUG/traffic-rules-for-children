package com.coffeejug.trafficrules.repository;

import com.coffeejug.trafficrules.Projection.ProgressPrj;
import com.coffeejug.trafficrules.db.Progress;
import com.coffeejug.trafficrules.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Integer> {

    List<ProgressPrj> findAllByUser(User user);
}

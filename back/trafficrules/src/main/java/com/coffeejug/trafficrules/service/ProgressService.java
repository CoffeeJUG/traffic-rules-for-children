package com.coffeejug.trafficrules.service;

import com.coffeejug.trafficrules.Projection.ProgressPrj;
import com.coffeejug.trafficrules.db.Progress;
import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public List<ProgressPrj> findAllByUser(User user) {
        return progressRepository.findAllByUser(user);
    }

    public Progress save(Progress progress) {
        return progressRepository.save(progress);
    }
}

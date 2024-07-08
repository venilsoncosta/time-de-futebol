package com.venilson.clubefutebol.services;

import com.venilson.clubefutebol.models.TimeDeFutebol;
import com.venilson.clubefutebol.repositories.TimeDeFutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeDeFutebolService {

    @Autowired
    private TimeDeFutebolRepository repository;

    public List<TimeDeFutebol> findAll() {
        return repository.findAll();
    }

    public Optional<TimeDeFutebol> findById(Long id) {
        return repository.findById(id);
    }

    public TimeDeFutebol save(TimeDeFutebol timeDeFutebol){
        return repository.save(timeDeFutebol);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

package it.prom.professionalmanager.service.impl;

import it.prom.professionalmanager.model.Coworker;
import it.prom.professionalmanager.repository.CoworkerRepo;
import it.prom.professionalmanager.service.CoworkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoworkersServiceImpl implements CoworkersService {

    private final CoworkerRepo coworkerRepo;

    @Autowired
    public CoworkersServiceImpl(CoworkerRepo coworkerRepo) {
        this.coworkerRepo = coworkerRepo;
    }

    @Override
    public Coworker addCoworker(Coworker coworker) {
        if (coworker.getId() == null) {
            return coworkerRepo.save(coworker);
        } else {
            throw new NullPointerException("asdasd");
        }
    }

    @Override
    public Coworker updateCoworker() {
        return null;
    }

    @Override
    public void deleteCoworker() {

    }

    @Override
    public List<Coworker> getCoworkers() {
        return coworkerRepo.findAll();
    }
}

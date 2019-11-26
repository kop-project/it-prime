package it.prom.professionalmanager.service.impl;

import it.prom.professionalmanager.model.Coworker;
import it.prom.professionalmanager.repository.CoworkerRepo;
import it.prom.professionalmanager.service.CoworkersService;
import it.prom.professionalmanager.service.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoworkersServiceImpl implements CoworkersService {

    private final CoworkerRepo coworkerRepo;

    /**
     * Компонент выдачи сообщения в зависимости от локали
     */
    private final Messages messages;

    @Autowired
    public CoworkersServiceImpl(CoworkerRepo coworkerRepo, Messages messages) {
        this.coworkerRepo = coworkerRepo;
        this.messages = messages;
    }

    @Override
    public Coworker addCoworker(Coworker coworker) {
        if (coworker.getId() == null) {
            return coworkerRepo.save(coworker);
        } else {
            throw new NullPointerException(messages.getMessage(""));
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

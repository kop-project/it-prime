package it.prom.professionalmanager.service.impl;

import it.prom.professionalmanager.model.Profession;
import it.prom.professionalmanager.repository.ProfessionRepo;
import it.prom.professionalmanager.service.ProfessionsService;
import it.prom.professionalmanager.service.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionsService {

    private final ProfessionRepo ProfessionRepo;

    /**
     * Компонент выдачи сообщения в зависимости от локали
     */
    private final Messages messages;

    @Autowired
    public ProfessionServiceImpl(ProfessionRepo ProfessionRepo, Messages messages) {
        this.ProfessionRepo = ProfessionRepo;
        this.messages = messages;
    }

    @Override
    public Profession addProfession(Profession Profession) {
        if (Profession.getName() == null) {
            return ProfessionRepo.save(Profession);
        } else {
            throw new NullPointerException(messages.getMessage(""));
        }
    }

    @Override
    public Profession updateProfession(Profession Profession) {
        return ProfessionRepo.save(Profession);
    }

    @Override
    public void deleteProfession(String id) {
        Profession Profession = ProfessionRepo.findById(id).orElseThrow(() -> new NullPointerException("asdas"));
        ProfessionRepo.delete(Profession);
    }

    @Override
    public List<Profession> getProfessions() {
        return ProfessionRepo.findAll();
    }
}

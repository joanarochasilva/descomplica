package com.descomplica.escola.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.escola.entity.Instrutor;
import com.descomplica.escola.repository.InstrutorRepository;

@Service
public class InstrutorService {
    @Autowired
    InstrutorRepository instrutorRepository;

    public List<Instrutor> getAll(){
        return instrutorRepository.findAll();
    }

    public Instrutor getById(Integer id) {
        return instrutorRepository.findById(id).orElse(null);
    }

    public Instrutor updateInstrutor(Integer id, Instrutor instrutor) {
        Instrutor instrutorAtualizada = instrutorRepository.findById(id).orElse(null);

        if(instrutorAtualizada != null) {
            instrutorAtualizada.setNomeInstrutor(instrutor.getNomeInstrutor());
            return instrutorRepository.save(instrutorAtualizada);
        } else {
            return null;
        }
    }

    public Instrutor saveInstrutor (Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public Boolean deleteInstrutor (Integer id) {
        Instrutor instrutor = instrutorRepository.findById(id).orElse(null);

        if(instrutor != null) {
            instrutorRepository.delete(instrutor);
            return true;
        } else {
            return false;
        }
    }
}

package com.descomplica.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.escola.entity.Turma;
import com.descomplica.escola.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getAll(){
        return turmaRepository.findAll();
    }

    public Turma getById(Integer id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma saveTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Integer id, Turma turma) {
        Turma turmaAtualizada = turmaRepository.findById(id).orElse(null);

        if(turmaAtualizada != null) {
            turmaAtualizada.setIdTurma(turma.getIdTurma());
            return turmaRepository.save(turmaAtualizada);
        } else {
            return null;
        }
    }

    public Boolean deleteTurma (Integer id) {
        Turma turma = turmaRepository.findById(id).orElse(null);

        if(turma != null) {
            turmaRepository.delete(turma);
            return true;
        } else {
            return false;
        }
    }

}

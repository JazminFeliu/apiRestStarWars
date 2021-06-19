package com.example.apireststarwars.services;

import com.example.apireststarwars.entities.PersonajeSW;
import com.example.apireststarwars.repositories.PersonajeSWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonajeSWService {

    private final PersonajeSWRepository personajeSWRepository;

    @Autowired
    public PersonajeSWService (PersonajeSWRepository personajeSWRepository){
        this.personajeSWRepository = personajeSWRepository;
    }

    public PersonajeSW save(PersonajeSW personajeSW){
        personajeSW.corregirID();
        return personajeSWRepository.save(personajeSW);
    }

    public Optional<PersonajeSW> findPersonajeById(Integer id){
        return personajeSWRepository.findById(id);
    }


}

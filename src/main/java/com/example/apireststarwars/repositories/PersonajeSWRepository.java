package com.example.apireststarwars.repositories;

import com.example.apireststarwars.entities.PersonajeSW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeSWRepository extends JpaRepository<PersonajeSW, Integer> {
}

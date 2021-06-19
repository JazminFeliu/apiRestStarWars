package com.example.apireststarwars.controllers;

import com.example.apireststarwars.entities.PersonajeSW;
import com.example.apireststarwars.services.PersonajeSWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonajeSWController {

    private final PersonajeSWService personajeSWService;

    @Autowired
    public PersonajeSWController(PersonajeSWService personajeSWService){
        this.personajeSWService = personajeSWService;
    }

    @GetMapping(value="/personajeSW/{id}/guardar", produces = "application/json")
    public PersonajeSW leerAPIyGuardar(@PathVariable Integer id){
        RestTemplate restTemplate= new RestTemplate();
        PersonajeSW personajeSW = restTemplate
                .getForEntity("https://swapi.dev/api/people/"+id+"/", PersonajeSW.class)
                .getBody();
        personajeSWService.save(personajeSW);
        return personajeSW;

    }

    @GetMapping(value = "/sw/{id}")
    public String sw(@PathVariable Integer id){
        RestTemplate apiStarWars = new RestTemplate();
        ResponseEntity<PersonajeSW>personaje = apiStarWars.getForEntity("https://swapi.dev/api/people/"+id+"/", PersonajeSW.class);
        return  personaje.getBody().getName();
    }

    @GetMapping(value="personajeSW/{id}")
    public PersonajeSW getPersonajeSW(@PathVariable Integer id){
        RestTemplate apiStarWars = new RestTemplate();
        ResponseEntity<PersonajeSW>personajeSW = apiStarWars.getForEntity("https://swapi.dev/api/people/"+id+"/",PersonajeSW.class);
        return personajeSW.getBody();
    }
}

package my.service.controller;


import my.service.model.Pet;
import my.service.repositories.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/pet")
public class PetResource {
    @Autowired
    private PetRepository petRepository;

    private Logger logger = LoggerFactory.getLogger(PetResource.class.getName());

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Pet getPetById(@PathVariable("id") Long id) {
        return petRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Pet with id %s is not found", id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet addPet(@RequestBody Pet pet) {
        pet = petRepository.save(pet);
        return pet;
    }
}
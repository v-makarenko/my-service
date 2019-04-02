package my.service.controller;


import my.service.model.Pet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/pet")
public class PetResource {
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Pet getPetById(@PathVariable("id") Long id) {
        return Pet.builder().id(id).name("Bobby").build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet addPet(Pet pet) {
        return pet;
    }
}
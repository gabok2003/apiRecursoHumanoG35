package co.edu.usa.miproyectog35.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.miproyectog35.demo.model.Audience;
import co.edu.usa.miproyectog35.demo.repository.crud.AudienceCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {
    @Autowired
    AudienceCrudRepository audienceCrudRepository;
    
    public List<Audience>getAll(){
        return (List<Audience>)audienceCrudRepository.findAll();
    }

    public Optional<Audience>getAudience(int id){
        return audienceCrudRepository.findById(id);
    }
    
    public Audience save (Audience audi){
        return audienceCrudRepository.save(audi);
    }
    
    public void delete(Audience audi){
        audienceCrudRepository.delete(audi);
    }

}

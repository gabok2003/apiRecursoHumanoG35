package co.edu.usa.miproyectog35.demo.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usa.miproyectog35.demo.model.Client;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
    
}

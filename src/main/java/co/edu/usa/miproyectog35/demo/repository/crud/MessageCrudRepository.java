package co.edu.usa.miproyectog35.demo.repository.crud;

import co.edu.usa.miproyectog35.demo.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer> {
    
}

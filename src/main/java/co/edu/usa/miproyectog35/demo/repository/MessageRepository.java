package co.edu.usa.miproyectog35.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import co.edu.usa.miproyectog35.demo.model.Message;
import co.edu.usa.miproyectog35.demo.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    
    @Autowired
    MessageCrudRepository messageCrudRepository;
    
    public List<Message>getAll(){
        return (List<Message>)messageCrudRepository.findAll();
        
    }

    public Optional<Message>getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save (Message msg){
        return messageCrudRepository.save(msg);
    }

    public void delete(Message msg){
        messageCrudRepository.delete(msg);
    }
    
}

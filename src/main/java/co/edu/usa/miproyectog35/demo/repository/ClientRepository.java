package co.edu.usa.miproyectog35.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import co.edu.usa.miproyectog35.demo.model.Client;
import co.edu.usa.miproyectog35.demo.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
   
    @Autowired
    ClientCrudRepository clientCrudRepository;
    
    public List<Client>getAll(){
        return (List<Client>)clientCrudRepository.findAll();
        
    }

    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save (Client clt){
        return clientCrudRepository.save(clt);
    }

    public void delete(Client clt){
        clientCrudRepository.delete(clt);
    }
     

}

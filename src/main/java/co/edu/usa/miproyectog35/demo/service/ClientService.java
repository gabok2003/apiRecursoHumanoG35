package co.edu.usa.miproyectog35.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import co.edu.usa.miproyectog35.demo.model.Client;
import co.edu.usa.miproyectog35.demo.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client clt) {
        if (clt.getIdClient() == null) {
            return clientRepository.save(clt);
        } else {
            Optional<Client> consulta = clientRepository.getClient(clt.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepository.save(clt);
            } else {
                return clt;

            }
        }
    }

    
    public Client update(Client clt){
        if(clt.getIdClient()!=null){
            Optional<Client> consulta = clientRepository.getClient(clt.getIdClient());
            if(!consulta.isEmpty()){
                if(clt.getName()!=null){
                    consulta.get().setName(clt.getName());
                }
                if(clt.getAge()!=null){
                    consulta.get().setAge(clt.getAge());
                }
                if(clt.getPassword()!=null){
                    consulta.get().setPassword(clt.getPassword());
                }
                if(clt.getEmail()!=null){
                    consulta.get().setEmail(clt.getEmail());
                }
                clientRepository.save(consulta.get());
                return consulta.get();
            }else{
                return clt;
            }
        }else{
            return clt;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean cBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return cBoolean;
    }
}

package co.edu.usa.miproyectog35.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import co.edu.usa.miproyectog35.demo.model.Message;
import co.edu.usa.miproyectog35.demo.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message msg) {
        if (msg.getIdMessage() == null) {
            return messageRepository.save(msg);
        } else {
            Optional<Message> consulta = messageRepository.getMessage(msg.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(msg);
            } else {
                return msg;

            }
        }
    }

    public Message update(Message msg){
        if(msg.getIdMessage()!=null){
            Optional<Message> consulta = messageRepository.getMessage(msg.getIdMessage());
            if(!consulta.isEmpty()){
                if(msg.getMessageText()!=null){
                   consulta.get().setMessageText(msg.getMessageText());
                }
                messageRepository.save(consulta.get());
                return consulta.get();
            }else{
                return msg;
            }
        }else{
            return msg;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean mBoolean = getMessage(messageId).map(message -> {
           messageRepository.delete(message);
            return true;
        }).orElse(false);
        return mBoolean;
    }


}

package co.edu.usa.miproyectog35.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import co.edu.usa.miproyectog35.demo.model.Client;
import co.edu.usa.miproyectog35.demo.model.CountClient;
import co.edu.usa.miproyectog35.demo.model.Reservation;
import co.edu.usa.miproyectog35.demo.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
        
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save (Reservation rsvt){
        return reservationCrudRepository.save(rsvt);
    }

    public void delete(Reservation rsvt){
        reservationCrudRepository.delete(rsvt);
      }
  
      public List<Reservation> ReservacionStatusRepositorio (String status){
          return reservationCrudRepository.findAllByStatus(status);
      }
      
      public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
          return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
      
      }
      
      public List<CountClient> getClientesRepositorio(){
          List<CountClient> res = new ArrayList<>();
          List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
          for(int i=0; i<report.size(); i++){
          res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
  
          }
          return res;
      }
  
}

package co.edu.usa.miproyectog35.demo.repository.crud;

import java.util.Date;
import java.util.List;
import co.edu.usa.miproyectog35.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationCrudRepository extends CrudRepository <Reservation,Integer>{
    
    public List<Reservation> findAllByStatus (String status); 
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();


}

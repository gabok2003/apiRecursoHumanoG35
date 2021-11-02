package co.edu.usa.miproyectog35.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import co.edu.usa.miproyectog35.demo.model.Audience;
import co.edu.usa.miproyectog35.demo.service.AudienceService;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class AudienceControlador {
    
    @Autowired
    private AudienceService audienceService;
        
    @GetMapping("/all")
    public List<Audience> getAudience() {
        return audienceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Audience> getAudience(@PathVariable("id") int id) {
        return audienceService.getAudience(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody  Audience audi) {
        return audienceService.save(audi);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience audi) {
        return audienceService.update(audi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int audienceId) {
        return audienceService.deleteAudience(audienceId);
    }

}

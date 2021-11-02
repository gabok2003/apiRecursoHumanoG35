package co.edu.usa.miproyectog35.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.miproyectog35.demo.model.Category;
import co.edu.usa.miproyectog35.demo.repository.crud.CategoryCrudRepository;


@Repository
public class CategoryRepository {
    @Autowired
    CategoryCrudRepository categoryCrudRepository;
    
    public List<Category>getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save (Category catd){
        return categoryCrudRepository.save(catd);
    }

    public void delete(Category catd){
        categoryCrudRepository.delete(catd);
    }
}

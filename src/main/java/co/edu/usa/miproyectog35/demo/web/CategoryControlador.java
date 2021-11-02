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

import co.edu.usa.miproyectog35.demo.model.Category;
import co.edu.usa.miproyectog35.demo.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class CategoryControlador {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getcategory(@PathVariable("id") int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody  Category catg) {
        return categoryService.save(catg);
    }

        
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category catg) {
        return categoryService.update(catg);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}

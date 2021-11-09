package hu.clubsWebService.services;

import hu.clubsWebService.domain.Category;
import hu.clubsWebService.domain.Club;
import hu.clubsWebService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getCategory(int id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()){
            return category.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Club> getClubsInCategory(int id) {
        Optional<Category> category = repository.findById(id);
        if(category.isPresent()) {
            return category.get().getClubs();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Category addCategory(Category category) {
        return repository.save(category);
    }
}

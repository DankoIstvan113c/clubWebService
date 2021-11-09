package hu.clubsWebService.services;

import hu.clubsWebService.domain.Club;
import hu.clubsWebService.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    public List<Club> getClubs() {
        return repository.findAllByOrderByName();
    }

}

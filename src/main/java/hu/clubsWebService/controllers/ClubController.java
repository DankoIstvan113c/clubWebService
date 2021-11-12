package hu.clubsWebService.controllers;

import hu.clubsWebService.domain.Category;
import hu.clubsWebService.domain.Club;
import hu.clubsWebService.services.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    private ClubService service;

    public ClubController(ClubService service) {
        this.service = service;
    }

    @GetMapping("/clubs")
    public List<Club> getClubs(){
        return service.getClubs();
    }

    @GetMapping("/clubs/{id}")
    public Club getClubs(@PathVariable("id") Long id){
        return service.getClub(id);
    }

    @PostMapping("club")
    @ResponseStatus(HttpStatus.CREATED)
    public Club addClub(@RequestBody Club club){
        return service.addClub(club);
    }
}

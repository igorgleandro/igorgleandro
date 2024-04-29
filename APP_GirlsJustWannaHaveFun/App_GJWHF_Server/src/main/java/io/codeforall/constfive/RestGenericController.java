package io.codeforall.constfive;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestGenericController {

    private Type checkType(String type){
        if(type.equals("notype")){
            return null;
        }
            return Type.valueOf(type.toUpperCase());
    }

    private City checkCity(String city){
        if(city.equals("nocity")){
            return null;
        }
        return City.valueOf(city.toUpperCase());
    }

    private Genre checkGenre(String genre){
        if(genre.equals("nogenre")){
            return null;
        }
        return Genre.valueOf(genre.toUpperCase());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{type}/{city}/{genre}/")
    public ResponseEntity<Club> responseClub(@PathVariable String type, @PathVariable String city, @PathVariable String genre) {

        Club club = ClubList.getClub(checkType(type), checkCity(city), checkGenre(genre));

        if (club == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(club, HttpStatus.OK);
    }

}

package dev.apoi2.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies") // This will be the DNS request for accessing the request on this class
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return new ResponseEntity<List<MovieModel>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}") // This is for redirect to a new
    public ResponseEntity<Optional<MovieModel>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<MovieModel>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }
}

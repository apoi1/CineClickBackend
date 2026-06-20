package dev.apoi2.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired //This is for the framework to auto intanciate an object
    private MovieRepository movieRepository;
    public List<MovieModel> allMovies(){
        return movieRepository.findAll(); // finAll method come from the mongodbrepository which come from the movie repository
    }

    public Optional<MovieModel> getSingleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}


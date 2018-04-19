package com.yq.controller;

import com.yq.domain.Movie;
;
import com.yq.repository.CustomizedMovieRepositoryImpl;
import com.yq.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository  movieRepository;

    @GetMapping("/all")
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/findByReveueGT")
    public Iterable<Movie> findByRevenueGT(@RequestParam Integer revenue) {
        return movieRepository.findByRevenueGreaterThan(revenue);
    }

    @GetMapping("/customized")
    public Iterable<Movie> findCustomized() {
        return movieRepository.someCustomMethod();

    }

}

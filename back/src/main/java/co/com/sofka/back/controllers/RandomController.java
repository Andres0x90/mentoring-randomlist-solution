package co.com.sofka.back.controllers;

import co.com.sofka.back.dtos.RandomListNumberDTO;
import co.com.sofka.back.services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/r")
@CrossOrigin("http://localhost:3000")
public class RandomController {

    @Autowired
    private RandomService randomService;

    @PostMapping("")
    public Mono<RandomListNumberDTO> generateRandomNumbers(
            @RequestBody RandomListNumberDTO randomListNumberDTO)
    {
        return randomService.randomList(randomListNumberDTO);
    }
}

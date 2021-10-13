package co.com.sofka.back.services;

import co.com.sofka.back.dtos.RandomListNumberDTO;
import co.com.sofka.back.entities.RandomListNumber;
import co.com.sofka.back.mappers.RandomMapper;
import co.com.sofka.back.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RandomService {

    @Autowired
    RandomRepository randomRepository;

    RandomMapper randomMapper = new RandomMapper();

    public Mono<RandomListNumberDTO> randomList(RandomListNumberDTO randomListNumberDTO)
    {
        return  Mono.just(randomMapper.fromDTO(randomListNumberDTO))
                .map(randomListNumber -> {
                    Flux.range(randomListNumber.getStartRange(),
                            randomListNumber.getEndRange() - randomListNumber.getStartRange() + 1)
                            .map(Objects::toString)
                            .collect(Collectors.joining(","))
                            .subscribe(randomListNumber::setOriginalList);

                    return randomListNumber;
                })
                .map(randomListNumber ->
                {
                    var randomNumbers = Stream.of(randomListNumber.getOriginalList().split(","))
                            .collect(Collectors.toList());
                    Collections.shuffle(randomNumbers);
                    randomListNumber.setRandomList(randomNumbers.stream()
                            .collect(Collectors.joining(",")));

                    return randomListNumber;
                })
                .flatMap(randomRepository::save)
                .map(randomMapper::fromEntity);

    }
}

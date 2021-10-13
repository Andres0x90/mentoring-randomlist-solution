package co.com.sofka.back.repositories;

import co.com.sofka.back.entities.RandomListNumber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomRepository extends ReactiveCrudRepository<RandomListNumber, String> {
}

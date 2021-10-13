package co.com.sofka.back.mappers;

import co.com.sofka.back.dtos.RandomListNumberDTO;
import co.com.sofka.back.entities.RandomListNumber;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RandomMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public RandomListNumberDTO fromEntity(RandomListNumber randomListNumber)
    {
        return modelMapper.map(randomListNumber, RandomListNumberDTO.class);
    }
    public RandomListNumber fromDTO(RandomListNumberDTO randomListNumberDTO)
    {

        return modelMapper.map(randomListNumberDTO, RandomListNumber.class);
    }

    public List<RandomListNumberDTO> fromEntityList(List<RandomListNumber> randomListNumbers)
    {
        return randomListNumbers.stream().map(randomListNumber -> fromEntity(randomListNumber)).toList();
    }
}

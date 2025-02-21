package com.pracazaliczeniowa.pracazaliczeniowa.model.Mapper;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import com.pracazaliczeniowa.pracazaliczeniowa.model.DTO.AnimalDTO;

public class AnimalEntityToDtoMapper {

    public static AnimalDTO mapEntityToDto(Animal animal){
        AnimalDTO dto=new AnimalDTO();
        dto.setId(animal.getId());
        dto.setImie(animal.getImie());
        dto.setRasa(animal.getRasa());
        dto.setGatunek(animal.getGatunek());
        dto.setIdKlienta(animal.getKlient().getId());
        dto.setWiek(animal.getWiek());
    return dto;
    }
}

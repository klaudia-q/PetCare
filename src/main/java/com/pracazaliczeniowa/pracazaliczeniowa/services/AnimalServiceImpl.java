package com.pracazaliczeniowa.pracazaliczeniowa.services;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.model.DTO.AnimalDTO;
import com.pracazaliczeniowa.pracazaliczeniowa.model.Mapper.AnimalEntityToDtoMapper;

import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final ClientRepository clientRepository;
    @Override
    @Transactional
    public AnimalDTO getAnimalById(Long animalId) {
        Optional<Animal> animal= animalRepository.findById(animalId);
        if(animal.isPresent()){
            return AnimalEntityToDtoMapper.mapEntityToDto(animal.get());
        }
        return null;
    }

    @Override
    @Transactional
    public AnimalDTO createNewAnimal(AnimalDTO animalDTO) {
        Optional<Client> client=clientRepository.findById(animalDTO.getIdKlienta());
        if(client.isPresent()) {
            Animal animal=new Animal();
            animal.setRasa(animalDTO.getRasa());
            animal.setImie(animalDTO.getImie());
            animal.setWiek(animalDTO.getWiek());
            animal.setGatunek(animalDTO.getGatunek());
            animal.setKlient(client.get());
            Animal saved=animalRepository.save(animal);
            return AnimalEntityToDtoMapper.mapEntityToDto(saved);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean updateAnimal(AnimalDTO animalDTO) {
        Optional<Client> client=clientRepository.findById(animalDTO.getIdKlienta());
        if(client.isPresent()) {
            Animal animal=new Animal();
            animal.setRasa(animalDTO.getRasa());
            animal.setImie(animalDTO.getImie());
            animal.setWiek(animalDTO.getWiek());
            animal.setGatunek(animalDTO.getGatunek());
            animal.setKlient(client.get());
            Animal saved=animalRepository.save(animal);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<AnimalDTO> findOtherAnimalsWithSameOwner(Long animalId) {
        Set<Animal> animals=animalRepository.findOtherAnimalsWithSameOwner(animalId);
        return animals.stream().map(AnimalEntityToDtoMapper::mapEntityToDto).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Set<AnimalDTO> getAnimalsByClient(Long clientId) {
        Set<Animal> animals=animalRepository.getAnimalsByClientNative(clientId);
        return animals.stream().map(AnimalEntityToDtoMapper::mapEntityToDto).collect(Collectors.toSet());
    }
}

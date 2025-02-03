package com.pracazaliczeniowa.pracazaliczeniowa.bootstrap;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.AnimalRepository;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ClientRepository;
import com.pracazaliczeniowa.pracazaliczeniowa.services.AnimalService;
import com.pracazaliczeniowa.pracazaliczeniowa.services.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final AnimalRepository animalRepository;

    @Override
    public void run(String... args) throws Exception {
       createDefaultData();

    }

    @Transactional
    private void createDefaultData() {
        Client client= new Client();
        client.setEmail("ww@wp.pl");
        client.setImie("Wiktoria");
        client.setNazwisko("Wolska");
        Client savedClient=clientRepository.save(client);

        Animal animal1=new Animal();
        animal1.setImie("Figa");
        animal1.setGatunek("pies");
        animal1.setRasa("kundelek");
        animal1.setWiek(3);
        animal1.setKlient(savedClient);

        Animal animal2=new Animal();
        animal2.setImie("Klara");
        animal2.setGatunek("kot");
        animal2.setRasa("dachowiec");
        animal2.setWiek(1);
        animal2.setKlient(savedClient);

        Animal animal1saved=animalRepository.save(animal1);
        Animal animal2saved=animalRepository.save(animal2);

        savedClient.setZwierzeta(Arrays.asList(animal1saved,animal2saved));

        Client client2= new Client();
        client2.setEmail("ww@wp.pl");
        client2.setImie("Weronika");
        client2.setNazwisko("Wolska");
        Client savedClient2=clientRepository.save(client);

        Animal animal12=new Animal();
        animal12.setImie("Figut");
        animal12.setGatunek("pies");
        animal12.setRasa("kundelek");
        animal12.setWiek(3);
        animal12.setKlient(savedClient);

        Animal animal22=new Animal();
        animal22.setImie("Klarut");
        animal22.setGatunek("kot");
        animal22.setRasa("dachowiec");
        animal22.setWiek(1);
        animal22.setKlient(savedClient);

        Animal animal12saved=animalRepository.save(animal12);
        Animal animal22saved=animalRepository.save(animal22);

        savedClient2.setZwierzeta(Arrays.asList(animal12saved,animal22saved));

    }
}

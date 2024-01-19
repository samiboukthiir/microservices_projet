package org.ms.deviseservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.ms.deviseservice.entities.Devise;
import org.ms.deviseservice.repository.DeviseRepository;

@SpringBootApplication
public class DeviseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviseServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(DeviseRepository deviseRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Devise.class);
        return args -> {
            // Insérer des devises de test dans la base de données
            deviseRepository.save(new Devise(null, "USD", "Dollar américain"));
            deviseRepository.save(new Devise(null, "EUR", "Euro"));
            deviseRepository.save(new Devise(null, "JPY", "Yen japonais"));

            // Afficher les devises existantes dans la base de données
            for (Devise devise : deviseRepository.findAll()) {
                System.out.println(devise.toString());
            }
        };
    }
}

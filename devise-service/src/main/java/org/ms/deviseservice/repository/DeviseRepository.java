package org.ms.deviseservice.repository;

import org.ms.deviseservice.entities.Devise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestController
public interface DeviseRepository extends JpaRepository<Devise,Long> {}

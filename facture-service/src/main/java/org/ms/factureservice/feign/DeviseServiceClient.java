package org.ms.factureservice.feign;
import org.ms.factureservice.model.Devise;
import org.ms.factureservice.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="Devise-SERVICE")
public interface DeviseServiceClient {
 @GetMapping(path="/devises")
 PagedModel<Devise> getAllDevises();
 @GetMapping(path="/devises/{id}")
 Produit findProductById(@PathVariable(name="id") Long id);
}

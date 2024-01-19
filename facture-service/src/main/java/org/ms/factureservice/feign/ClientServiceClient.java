package org.ms.factureservice.feign;
import org.ms.factureservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="CLIENT-SERVICE")
public interface ClientServiceClient {
 @GetMapping(path="/clients/{id}")
 Client findClientById(@PathVariable(name="id") Long id);
}


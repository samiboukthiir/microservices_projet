package org.ms.factureservice.web;
import org.ms.factureservice.entities.Facture;
import org.ms.factureservice.feign.ClientServiceClient;
import org.ms.factureservice.feign.DeviseServiceClient;
import org.ms.factureservice.feign.ProduitServiceClient;
import org.ms.factureservice.model.Client;
import org.ms.factureservice.model.Devise;
import org.ms.factureservice.model.Produit;
import org.ms.factureservice.repository.FactureLigneRepository;
import org.ms.factureservice.repository.FactureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FactureRestController {
 private FactureRepository factureRepository;
 private FactureLigneRepository factureLigneRepository;
 private ClientServiceClient clientServiceClient;
 private ProduitServiceClient produitServiceClient;
 private DeviseServiceClient deviseServiceClient;
 public FactureRestController(FactureRepository factureRepository,
 FactureLigneRepository 
factureLigneRepository,
 ClientServiceClient clientServiceClient,
ProduitServiceClient produitServiceClient,
DeviseServiceClient deviseServiceClient) {
 this.factureRepository = factureRepository;
 this.factureLigneRepository = factureLigneRepository;
 this.clientServiceClient = clientServiceClient;
 this.produitServiceClient = produitServiceClient;
 this.deviseServiceClient = deviseServiceClient;
 }
 @GetMapping (path="/full-facture/{id}")
 public Facture getFacture(@PathVariable(name = "id") Long id)
 {
 Facture facture= factureRepository.findById(id).get();
 Client client = 
clientServiceClient.findClientById(facture.getClientID());
 facture.setClient(client);
 facture.getFacturekignes().forEach(fl-> {
 Produit product 
=produitServiceClient.findProductById(fl.getProduitID());
 fl.setProduit(product);
 
 
 
 });
 return facture;
 }
}
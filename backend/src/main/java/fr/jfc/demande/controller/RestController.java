package fr.jfc.demande.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import fr.jfc.demande.dao.DemandeRepository;
import fr.jfc.demande.dao.AdministrateurRepository;
import fr.jfc.demande.dto.DemandeForm;

import fr.jfc.demande.entity.Administrateur;
import fr.jfc.demande.entity.Demande;
import fr.jfc.demande.enume.Categorie;
import fr.jfc.demande.enume.Profession;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /rest (after Application path)
@Slf4j
public class RestController {

	@Autowired
	private AdministrateurRepository adminDao;

	@Autowired
	private DemandeRepository demandeDao;

	
/*mettre quels getMapping?
	@GetMapping(path = "InfirmierSoignerMedicament/{id}")
	public @ResponseBody List<DemandeDetails> DemandesDetails(@PathVariable int id) {
		log.info("Détails demande");
		return demandeDao.DemandeDetails(id);
	}*/

	/*private Date datecreation;
    private String nom;
     String prenom;
     String adressemail;
     String objet;
     Categorie categorie;
     Profession profession;
     String pb;
     img piecejointe;*/

	@PostMapping(path = "saveDemande")
	public @ResponseBody void enregistreUneDemande(@RequestBody DemandeForm formData) {
		log.info("Reçu: {}", formData);
		List<Demande> allDemandes = demandeDao.findAll();
		Demande demande=null;
		for (Demande d : allDemandes) {
			if (d.getNom_demandeur().equals(formData.getNom())) {
				demande = d;
			}	
			log.info("Enregistré: {}", formData.getNom());
		}
		
		
	}


	@GetMapping(path = "DemandeByObjet")
	public @ResponseBody List<Demande> DemandeByObjet(String mot) {
		List<Demande> allDemande = this.demandeDao.findAll();
		List<Demande> searchDemande = new ArrayList<>();
		for (Demande d : allDemande) {
			log.info(d.getObjet());
			if (d.getObjet().toLowerCase().contains(mot.toLowerCase())) {
				searchDemande.add(d);
			}
		}
		log.info(searchDemande.toString());

		return searchDemande;
	}

	@GetMapping(path = "allDemande")
	public @ResponseBody List<Demande> allDemandes() {
		log.info("Renvoie la liste des demandes");
		return demandeDao.findAll();
	}

	
	  @GetMapping(path = "allAdministrateur")
	  public @ResponseBody List<Administrateur> allAdmin() {
	  log.info("Renvoie la liste des administrateur");
	 return adminDao.findAll();
	  }

	  @GetMapping(path = "allCategories")
	public @ResponseBody List<Categorie> allCategorie() {
		log.info("Renvoie la liste des catégories");
		List<Categorie> lesCategories= new ArrayList<>();
		for (Categorie cat : Categorie.values()) {
			lesCategories.add(cat);
		}
		return lesCategories;
	}
	@GetMapping(path = "allProfessions")
	public @ResponseBody List<Profession> allProfessions() {
		log.info("Renvoie la liste des professions");
		List<Profession> lesProfessions= new ArrayList<>();
		for (Profession prof : Profession.values()) {
			lesProfessions.add(prof);
		}
		return lesProfessions;
	}

}

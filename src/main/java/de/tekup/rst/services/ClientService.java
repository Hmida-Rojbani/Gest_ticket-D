package de.tekup.rst.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientReqDTO;
import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.entities.Client;
import de.tekup.rst.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public ClientResDTO saveToDB(ClientReqDTO clientReqDTO) {
		ModelMapper mapper = new ModelMapper();
		/*
		 * Client entity = new Client(); entity.setNom(clientReqDTO.getNom());
		 * entity.setPrenom(clientReqDTO.getPrenom());
		 * entity.setDateDeNaissance(clientReqDTO.getDateDeNaissance());
		 * entity.setCourriel(clientReqDTO.getCourriel());
		 * entity.setTelephone(clientReqDTO.getTelephone());
		 */
		Client entity = mapper.map(clientReqDTO, Client.class);
		clientRepository.save(entity);
		/*
		 * ClientResDTO clientResDTO = new ClientResDTO();
		 * clientResDTO.setId(entity.getId());
		 * clientResDTO.setNomComplet(entity.getPrenom() + " " + entity.getNom());
		 * clientResDTO.setAge((int)ChronoUnit.YEARS
		 * .between(entity.getDateDeNaissance(), LocalDate.now()));
		 */
		ClientResDTO clientResDTO = mapper.map(entity, ClientResDTO.class);
		return clientResDTO;
	}

}

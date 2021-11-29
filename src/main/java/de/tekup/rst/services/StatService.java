package de.tekup.rst.services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientResDTO;
import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.dto.models.TableDTO;
import de.tekup.rst.entities.Client;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {
	
	private MetRepository metRepository;
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private ModelMapper  mapper;

	public MetDTO platPlusAchetee(LocalDate debut, LocalDate fin) {
		List<MetEntity> metEntities = metRepository.findAll();
		metEntities.removeIf(met -> !(met instanceof Plat));
		
		for (MetEntity metEntity : metEntities) {
			metEntity.getTickets()
			.removeIf(t-> !(t.getDateTime().toLocalDate().isAfter(debut) && 
					t.getDateTime().toLocalDate().isBefore(fin)));
		}
		
		int max = -1;
		MetEntity entity = null;
		
		for (MetEntity metEntity : metEntities) {
			if(metEntity.getTickets().size()>max) {
				max = metEntity.getTickets().size();
				entity  = metEntity;
			}
		}
		MetDTO dto = mapper.map(entity, MetDTO.class);
		dto.setType("Plat");
		return dto;
	}
	
	public ClientResDTO fidele() {
		List<Client> clients = clientRepository.findAll();
		
		int max = -1;
		Client clientFidele = null;
		
		for (Client client : clients) {
			if(client.getTickets().size()> max) {
				max = client.getTickets().size();
				clientFidele = client;
			}
		}
		
		return mapper.map(clientFidele, ClientResDTO.class);
	}
	
	
	public TableDTO plusReservee() {
		
		TableEntity table = tableRepository.findAll().stream()
								.max(Comparator.comparing(t->t.getTickets().size()))
								.get();
		
		return mapper.map(table, TableDTO.class);
	}
}

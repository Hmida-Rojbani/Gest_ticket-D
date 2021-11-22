package de.tekup.rst.services;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.repositories.MetRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {
	
	private MetRepository metRepository;
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
}

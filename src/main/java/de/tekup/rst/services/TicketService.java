package de.tekup.rst.services;

import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TicketDTO;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import de.tekup.rst.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private MetRepository metRepository;
	private TicketRepository ticketRepository;
	
	public double createTicket(TicketDTO ticketDTO) {
		
		return 0;
	}

}

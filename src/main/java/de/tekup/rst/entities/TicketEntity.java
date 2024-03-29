package de.tekup.rst.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	private LocalDateTime dateTime;
	
	private int nbCoverts;
	
	private double addition;
	
	@ManyToOne
	private TableEntity table;
	
	@ManyToOne
	private Client client;
	
	@ManyToMany
	private List<MetEntity> mets = new ArrayList<>();
}

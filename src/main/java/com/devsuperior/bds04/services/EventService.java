package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private EventRepository repository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable){
		Page<Event> events = repository.findAll(pageable);
		return events.map(e -> new EventDTO(e));
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = copyDtoToEntity(dto);
		entity = repository.save(entity);
		return new EventDTO(entity);
	}
	
	private Event copyDtoToEntity(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		City city = cityRepository.getOne(dto.getCityId());
		entity.setCity(city);
		return entity;
	}	
	
}

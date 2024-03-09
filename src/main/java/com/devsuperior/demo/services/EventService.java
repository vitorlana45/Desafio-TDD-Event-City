package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.ScatteringByteChannel;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;


    public EventDTO update(Long id, EventDTO eventDTO) {
        try {
            Event eventEntity = repository.getReferenceById(id);
            updateData(eventDTO, eventEntity);
            eventEntity = repository.save(eventEntity);
            return new EventDTO(eventEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Evento não encontrado!");
        }
    }

    private Event updateData(EventDTO eventDTO, Event entity) {
        entity.setName(eventDTO.getName());
        entity.setDate(eventDTO.getDate());
        entity.setUrl(eventDTO.getUrl());
        entity.setCity(new City(eventDTO.getCityId(), null));
        return entity;
    }

}

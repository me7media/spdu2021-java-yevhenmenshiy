package org.spdu2021.registry.web.service;

import org.spdu2021.registry.web.entity.Event;
import org.spdu2021.registry.web.repository.EventRepository;
import org.spdu2021.registry.web.exception.EntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event getById(Long id){
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()){
            return event.get();
        }
        throw new EntityException("Event with "+id+" does not exists!");
    }
    public Event createOrUpdate(Event event) {
        eventRepository.save(event);
        return event;
    }

    public boolean delete(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.delete(event.get());
            return true;
        }
        throw new EntityException("Event with " + id + " does not exists!");
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}

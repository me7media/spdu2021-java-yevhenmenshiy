package org.spdu2021.registry.web.service;

import org.spdu2021.registry.web.entity.Sale;
import org.spdu2021.registry.web.exception.EntityException;
import org.spdu2021.registry.web.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private EventService eventService;

    public Sale getById(Long id){
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent()){
            return sale.get();
        }
        throw new EntityException("Sale with "+id+" does not exists!");
    }
    public Sale createOrUpdate(Sale sale) {
        if(sale.getEvent_id() != null && sale.getEvent() == null){
            sale.setEvent(eventService.getById(sale.getEvent_id()));
        }
        saleRepository.save(sale);
        return sale;
    }

    public boolean delete(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            saleRepository.delete(sale.get());
            return true;
        }
        throw new EntityException("Sale with " + id + " does not exists!");
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }
}

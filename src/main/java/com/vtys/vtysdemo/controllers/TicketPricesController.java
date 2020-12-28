package com.vtys.vtysdemo.controllers;

import com.vtys.vtysdemo.models.TicketPrice;
import com.vtys.vtysdemo.repositories.TicketPriceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",
             allowedHeaders = "*",
             methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/api/ticket_price")
public class TicketPricesController {

    private TicketPriceRepository _ticketPriceRepository;

    public TicketPricesController(TicketPriceRepository ticketPriceRepository) {
        _ticketPriceRepository = ticketPriceRepository;
    }

    @GetMapping
    public List<TicketPrice> list(){
        return _ticketPriceRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public TicketPrice get(@PathVariable Long id )
    {
        return _ticketPriceRepository.getOne(id);
    }

    @PostMapping
    public TicketPrice create(@RequestBody final TicketPrice ticketPrice){
        return  _ticketPriceRepository.saveAndFlush(ticketPrice);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        _ticketPriceRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public TicketPrice update(@PathVariable Long id, @RequestBody TicketPrice ticketPrice){
        TicketPrice model = _ticketPriceRepository.getOne(id);
        BeanUtils.copyProperties(ticketPrice, model, "id");
        return _ticketPriceRepository.saveAndFlush(model);
    }


}

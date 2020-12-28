package com.vtys.vtysdemo.controllers;

import com.vtys.vtysdemo.models.Attendee;
import com.vtys.vtysdemo.repositories.AttendeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",
             allowedHeaders = "*",
             methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/api/attendee")
public class AttendeesController {

    @Autowired
    private AttendeeRepository _attendeeRepository;

    public AttendeesController(AttendeeRepository attendeeRepository) {
        _attendeeRepository = attendeeRepository;
    }

    @GetMapping
    public List<Attendee> get(){
        return  _attendeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Attendee get(@PathVariable Long id){
        return _attendeeRepository.getOne(id);
    }

    @PostMapping
    public Attendee create(@RequestBody final Attendee attendee){
        return  _attendeeRepository.saveAndFlush(attendee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        _attendeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Attendee update(@PathVariable Long id, @RequestBody Attendee attendee){
        Attendee model = _attendeeRepository.getOne(id);
        BeanUtils.copyProperties(attendee, model, "id");
        return _attendeeRepository.saveAndFlush(attendee);
    }

    @GetMapping("/getws")
    public List<Attendee> findAttendeesWithByWorkShop(){
        return _attendeeRepository.findAttendeesByWorkshop();
    }
}

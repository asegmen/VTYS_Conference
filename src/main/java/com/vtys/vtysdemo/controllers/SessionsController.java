package com.vtys.vtysdemo.controllers;

import com.vtys.vtysdemo.models.Session;
import com.vtys.vtysdemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionsController {
    private final SessionRepository _sessionRepository;

    public SessionsController(SessionRepository sessionRepository) {
        _sessionRepository = sessionRepository;
    }
    @GetMapping
    public List<Session> list(){

        return _sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return _sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return _sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        _sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session model = _sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, model, "id");
        return _sessionRepository.saveAndFlush(model);
    }

}

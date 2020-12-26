package com.vtys.vtysdemo.controllers;

import com.vtys.vtysdemo.models.Speaker;
import com.vtys.vtysdemo.repositories.SpeakerRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speakers")
public class SpeakersController {
    private final SpeakerRepository _speakerRepository;

    public SpeakersController(SpeakerRepository speakerRepository) {
        _speakerRepository = speakerRepository;
    }

    @GetMapping
    public List<Speaker> list(){
        return _speakerRepository.findAll();
    }

    @GetMapping()
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return _speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return _speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        _speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker)
    {
        Speaker model = _speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, model, "id");
        return _speakerRepository.saveAndFlush(model);
    }



}

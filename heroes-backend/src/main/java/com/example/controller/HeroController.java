package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hero;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

//    private List<Hero> l = List.of(
//            new Hero(1, "Ken"),
//            new Hero(2, "Yannick"),
//            new Hero(3, "Pieter"));

	private List<Hero> l = new ArrayList();
	
	public HeroController() {
		
		l.add(new Hero(1, "Ken"));
		l.add(new Hero(2, "Yannick"));
		l.add(new Hero(3, "Pieter"));
		
	}

	
    @GetMapping
    @RolesAllowed("stn-user")
    //@RolesAllowed({"stn-admin, stn-user"})
    public List<Hero> heroes() {
        return l;
    }

    @GetMapping("/{id}")
    @RolesAllowed("stn-admin")
    public Hero hero(@PathVariable("id") String id) {
        return l.stream()
                .filter(h -> Integer.toString(h.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @RolesAllowed("stn-admin")
    public Hero add(Hero o) {
    	System.out.println("Add " + o);
    	
    	o.setId(l.size());
    	l.add(o);
    	return o;
    }
    
    
    @DeleteMapping("/{id}")
    @RolesAllowed("stn-admin")
    public void delete(@PathVariable("id") String id) {
    	System.out.println(id);
    }
    
    
}


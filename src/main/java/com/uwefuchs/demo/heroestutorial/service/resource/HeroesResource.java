package com.uwefuchs.demo.heroestutorial.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;

import com.uwefuchs.demo.heroestutorial.service.model.Hero;

@Path("heroes")
public class HeroesResource {

    private final Map<Integer, Hero> heroes = new LinkedHashMap<>(10);

    public HeroesResource() {
        buildHeroesMap();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Hero> getAllHeroes() {
        return heroes.values();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Hero findHero(@PathParam("id") Integer id) {
        return heroes.get(id);
    }

    private void buildHeroesMap() {
        heroes.put(11, new Hero(11, "Mr. Nice"));
        heroes.put(12, new Hero(12, "Narco"));
        heroes.put(13, new Hero(13, "Bombasto"));
        heroes.put(14, new Hero(14, "Celeritas"));
        heroes.put(15, new Hero(15, "Magneta"));
        heroes.put(16, new Hero(16, "RubberMan"));
        heroes.put(17, new Hero(17, "Dynama"));
        heroes.put(18, new Hero(18, "Dr IQ"));
        heroes.put(19, new Hero(19, "Magma"));
        heroes.put(20, new Hero(20, "Tornado"));
    }
}

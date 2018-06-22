package com.uwefuchs.demo.heroestutorial.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uwefuchs.demo.heroestutorial.service.model.Hero;

@Path("heroes")
public class HeroesResource {

    private static final Map<Integer, Hero> HEROES_MAP = new LinkedHashMap<>();    
    private static final Logger LOG = LoggerFactory.getLogger(Hero.class);

    static {
        buildHeroesMap();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Hero> getAllHeroes() {
        LOG.debug("delivering all heroes...");
        return HEROES_MAP.values();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hero findHero(@PathParam("id") Integer id) {
    	if (!HEROES_MAP.containsKey(id)) {
    		throw new WebApplicationException(String.format("no hero found with id [%d]", id), 404);
    	}
    	
        LOG.debug("delivering hero with id [{}]...", id);
        return HEROES_MAP.get(id);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateHero(Hero hero, @PathParam("id") Integer id) {
    	if (!HEROES_MAP.containsKey(id)) {
    		throw new WebApplicationException(String.format("no hero found with id [%d]", id), 404);
    	}
    	
        LOG.debug("updating hero with id [{}]...", id);        
        HEROES_MAP.put(id, hero);
        LOG.info("hero with id [{}] updated.", id);
        
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteHero(@PathParam("id") Integer id) {
    	if (!HEROES_MAP.containsKey(id)) {
    		throw new WebApplicationException(String.format("no hero found with id [%d]", id), 404);
    	}
    	
        LOG.debug("deleting hero with id [{}]...", id);        
        HEROES_MAP.remove(id);
        LOG.info("hero with id [{}] deleted.", id);
        
        return Response.ok().build();
    }

    private static void buildHeroesMap() {
        LOG.debug("building heroes-map...");
        HEROES_MAP.put(11, new Hero(11, "Mr. Nice"));
        HEROES_MAP.put(12, new Hero(12, "Narco"));
        HEROES_MAP.put(13, new Hero(13, "Bombasto"));
        HEROES_MAP.put(14, new Hero(14, "Celeritas"));
        HEROES_MAP.put(15, new Hero(15, "Magneta"));
        HEROES_MAP.put(16, new Hero(16, "RubberMan"));
        HEROES_MAP.put(17, new Hero(17, "Dynama"));
        HEROES_MAP.put(18, new Hero(18, "Dr IQ"));
        HEROES_MAP.put(19, new Hero(19, "Magma"));
        HEROES_MAP.put(20, new Hero(20, "Tornado"));
        LOG.debug("... finished!");
    }
}

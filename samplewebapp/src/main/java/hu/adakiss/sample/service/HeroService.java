package hu.adakiss.sample.service;

import java.util.List;
import java.util.Optional;

import hu.adakiss.sample.dalmock.Hero;

public interface HeroService {

  List<Hero> listHeroesByOwner(String ownerUsername);

  List<Hero> listAllHeroes();

  Hero saveHero(Hero hero);

  Optional<Hero> findHeroByName(String name);
}

package hu.adakiss.sample.service;

import java.util.List;
import java.util.Optional;

import hu.adakiss.sample.dalmock.DaoMock;
import hu.adakiss.sample.dalmock.Hero;

public class HeroServiceImpl implements HeroService {

  @Override
  public List<Hero> listHeroesByOwner(final String ownerUsername) {
    return DaoMock.findHeroesByOwner(ownerUsername);
  }

  @Override
  public List<Hero> listAllHeroes() {
    return DaoMock.fetchAllHeroes();
  }

  @Override
  public Hero saveHero(final Hero hero) {
    return DaoMock.saveHero(hero);
  }

  @Override
  public Optional<Hero> findHeroByName(final String name) {
    return DaoMock.findHeroByName(name);
  }
}

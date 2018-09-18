package hu.adakiss.sample.service;

import java.util.List;
import java.util.Optional;

import hu.adakiss.sample.dalmock.DaoMock;
import hu.adakiss.sample.dalmock.Race;

public class RaceServiceImpl implements RaceService {

  @Override
  public List<Race> fetchAllRaces() {
    return DaoMock.fetchAllRaces();
  }

  @Override
  public Optional<Race> findRaceByName(final String name) {
    return DaoMock.findRaceByName(name);
  }
}

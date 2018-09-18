package hu.adakiss.sample.service;

import java.util.List;
import java.util.Optional;

import hu.adakiss.sample.dalmock.Race;

public interface RaceService {

  List<Race> fetchAllRaces();

  Optional<Race> findRaceByName(String name);
}

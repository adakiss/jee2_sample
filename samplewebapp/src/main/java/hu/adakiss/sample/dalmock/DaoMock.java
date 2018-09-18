package hu.adakiss.sample.dalmock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoMock {

  private static final List<User> users = Arrays.asList(new User("admin", "admin"), new User("johndoe", "123456"));
  private static final List<Race> races =
      Arrays.asList(new Race("human", "Race of humans"), new Race("elf", "Race of elves"), new Race("khajit", "Race of khajits"));
  private static final List<Hero> heroes = new ArrayList<>();

  public static Optional<User> findUserByUsername(final String username) {
    return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
  }

  public static List<Race> fetchAllRaces() {
    return races;
  }

  public static Optional<Race> findRaceByName(final String name) {
    return races.stream().filter(race -> race.getName().equals(name)).findFirst();
  }

  public static Hero saveHero(final Hero hero) {
    heroes.add(hero);
    return heroes.get(heroes.size() - 1);
  }

  public static List<Hero> fetchAllHeroes() {
    return heroes;
  }

  public static List<Hero> findHeroesByOwner(final String owner) {
    return heroes.stream().filter(hero -> hero.getOwner().getUsername().equals(owner)).collect(Collectors.toList());
  }

  public static Optional<Hero> findHeroByName(final String heroName) {
    return heroes.stream().filter(hero -> hero.getName().equals(heroName)).findFirst();
  }

  public static User addUser(final User user) {
    users.add(user);
    return users.get(users.size() - 1);
  }
}

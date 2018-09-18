package hu.adakiss.sample.dalmock;

import java.util.ArrayList;
import java.util.List;

public class User {

  private String username;
  private String password;
  private final List<Hero> heroes = new ArrayList<>();

  public User(final String username, final String password) {
    this.password = password;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public List<Hero> getHeroes() {
    return heroes;
  }
}

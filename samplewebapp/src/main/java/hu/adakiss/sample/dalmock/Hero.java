package hu.adakiss.sample.dalmock;

public class Hero {

  private final String name;
  private final String description;
  private final Race race1;
  private final Race race2;
  private final int race1Percentage;
  private final User owner;

  public Hero(final String name, final String description, final Race race1, final Race race2, final User owner, final int race1Percentage) {
    super();
    this.name = name;
    this.description = description;
    this.race1 = race1;
    this.race2 = race2;
    this.owner = owner;
    this.race1Percentage = race1Percentage;
  }

  public int getRace1Percentage() {
    return race1Percentage;
  }

  public User getOwner() {
    return owner;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Race getRace1() {
    return race1;
  }

  public Race getRace2() {
    return race2;
  }
}

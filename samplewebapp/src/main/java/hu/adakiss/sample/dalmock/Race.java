package hu.adakiss.sample.dalmock;

public class Race {

  private String name;
  private String description;

  public Race(final String name, final String description) {
    super();
    this.name = name;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

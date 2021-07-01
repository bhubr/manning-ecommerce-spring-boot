package me.benoithubert.mngecom;

public class Pastry {
  private Long id;
  private String title;
  private Double price;

  // Question: if I store price as DECIMAL(10, 2), how would that translate here?
  // Should I use Double or sth else?
  public Pastry(Long id, String title, Double price) {
    this.id = id;
    this.title = title;
    this.price = price;
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public Double getPrice() {
    return this.price;
  }
}

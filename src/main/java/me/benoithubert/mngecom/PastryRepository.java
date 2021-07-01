package me.benoithubert.mngecom;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class PastryRepository implements IPastryRepository {

  public List<Pastry> findAll() {
    List<Pastry> pastries = Arrays.asList(
      new Pastry(1l, "Croissant", 1.19),
      new Pastry(2l, "Chocolatine", 1.29),
      new Pastry(3l, "Pain aux raisins", 1.39),
      new Pastry(4l, "Chausson aux pommes", 1.69),
      new Pastry(5l, "Croissant aux amandes", 2.19),
      new Pastry(6l, "Chocolatine aux amandes", 2.19)
    );
    return pastries;
  }
}

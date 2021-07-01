package me.benoithubert.mngecom;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PastryService implements IPastryService {
  private IPastryRepository pastryRepository;

  PastryService(IPastryRepository pastryRepository) {
    this.pastryRepository = pastryRepository;
  }

  public List<Pastry> getAllPastries() {
    return this.pastryRepository.findAll();
  }
}

package me.benoithubert.mngecom;

import java.util.List;
// import org.springframework.data.repository.CrudRepository;

interface IPastryRepository { // extends CrudRepository<Pastry, Long> {
  List<Pastry> findAll();
}

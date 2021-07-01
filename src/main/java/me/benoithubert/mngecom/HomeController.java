package me.benoithubert.mngecom;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  private IPastryService pastryService;

  HomeController(IPastryService pastryService) {
    this.pastryService = pastryService;
  }

  @GetMapping("/")
  public ModelAndView home(Map<String, Object> model) {
    List<Pastry> pastries = this.pastryService.getAllPastries();

    model.put("pastries", pastries);

    return new ModelAndView("home", model);
  }
}

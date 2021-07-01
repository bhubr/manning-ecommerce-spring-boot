package me.benoithubert.mngecom;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

  @MockBean
  PastryService pastryService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHomePage() throws Exception {
    // Arrange
    Pastry pastry1 = new Pastry(1L, "Croissant", 1.19);
    Pastry pastry2 = new Pastry(2L, "Chocolatine", 1.29);
    List<Pastry> mockPastries = Arrays.asList(pastry1, pastry2);

    when(pastryService.getAllPastries()).thenReturn(mockPastries);
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home"))
        .andExpect(content().string(containsString("Cake Factory")))
        .andExpect(content().string(containsString("Croissant")))
        .andExpect(content().string(containsString("Chocolatine")));
  }

}

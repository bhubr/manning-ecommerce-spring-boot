package me.benoithubert.mngecom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class PastryServiceTest {

	@InjectMocks
	private PastryService pastryService;

	@Mock
	private IPastryRepository pastryRepositoryMock;

    @Test
    public void testReadPastries() {
      // Arrange
      Pastry pastry1 = new Pastry(1L, "Croissant", 1.19);
      Pastry pastry2 = new Pastry(2L, "Chocolatine", 1.29);
      List<Pastry> mockPastries = Arrays.asList(pastry1, pastry2);

      when(pastryRepositoryMock.findAll()).thenReturn(mockPastries);

      // Act
      List<Pastry> fetchedPastries = pastryService.getAllPastries();

      // Assert
      assertEquals("pastryService.getAllPastries() should return 2 items", 2, fetchedPastries.size());
    }
}
package me.benoithubert.mngecom;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = MngecomApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class EndToEndTest {

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void testHomePage() throws Exception {
      WebClient webClient = MockMvcWebClientBuilder
          .webAppContextSetup(wac).build();
        final HtmlPage page = webClient.getPage("http://localhost:8080");

        // Get list of all card titles
        final DomNodeList<DomNode> pastryTitleElems = page.querySelectorAll("h4.card-title");
        int i = 0;
        // Expected pastry names (probably not a good idea, since it won't be resilient to change)
        String[] pastryTitles = {"Croissant", "Chocolatine", "Pain aux raisins", "Chausson aux pommes", "Croissant aux amandes", "Chocolatine aux amandes"};

        assertEquals("Home page should display 6 items", 6, pastryTitleElems.getLength());
        for (DomNode titleElem : pastryTitleElems) {
          assertEquals("Item at index " + i + " should have title '" + pastryTitles[i] + "'", pastryTitles[i], titleElem.getTextContent());
          i += 1;
        }
  }
}
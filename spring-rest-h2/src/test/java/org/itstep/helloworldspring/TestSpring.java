package org.itstep.helloworldspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itstep.helloworldspring.Model.Car;
import org.itstep.helloworldspring.Model.Country;
import org.itstep.helloworldspring.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSpring {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCars() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}

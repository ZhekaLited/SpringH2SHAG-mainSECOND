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
    @Oreder(1)
    public void getCars() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
     @Test
    @Order(2)
    public void postCars() throws Exception {
        mvc.perform(

                        MockMvcRequestBuilders.post

                                        ("/cars")
                                .content(asJsonString(new Car(1L,"Mazda","White","e856")))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
          @Test
    @Order(3)
    public void putCars() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.put
                                        ("/cars/2")
                                .content(asJsonString(new Car(4L, "Tiguan", "Black", "e29")))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(status().isOk());
    }
}

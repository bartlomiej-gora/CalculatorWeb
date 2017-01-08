import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.bgora.calculator.web.Main;
import pl.bgora.calculator.web.rest.RestCalculatorController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class RestCalculatorControllerTest {

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new RestCalculatorController()).build();
    }

    @Test
    public void testCalculate() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/1+1")).andExpect(status().isOk()).andExpect(content().string("{\"input\":\"1+1\",\"result\":\"2\"}"));
    }

    @Test
    public void testCalculate0() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/0")).andExpect(status().isOk()).andExpect(content().string("{\"input\":\"0\",\"result\":\"0\"}"));
    }

}
@SpringBootTest
@AutoConfigureMockMvc
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterDoctor() throws Exception {
        mockMvc.perform(post("/registerDoctor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"regNo\":\"D200\",\"name\":\"Dr Test\",\"speciality\":\"Gyn\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchDoctor() throws Exception {
        mockMvc.perform(get("/searchDoctor/Dr%20Test"))
                .andExpect(status().isOk());
    }
}

package ma.najid.demojwtspringboot.controller;

import ma.najid.demojwtspringboot.entities.AppUser;
import ma.najid.demojwtspringboot.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.main.allow-circular-references=true")
public class AccountRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    @WithMockUser
    public void shouldReturnListOfUsers() throws Exception {
        // Given
        List<AppUser> users = new ArrayList<>();
        users.add(new AppUser(1L, "user1", "pass1", new ArrayList<>()));
        users.add(new AppUser(2L, "user2", "pass2", new ArrayList<>()));
        when(accountService.listUsers()).thenReturn(users);

        // When & Then
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }
}

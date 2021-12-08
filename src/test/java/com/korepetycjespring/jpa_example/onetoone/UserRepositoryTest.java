package com.korepetycjespring.jpa_example.onetoone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        //given
        Address address = Address.builder()
                .city("poznan")
                .build();
        User user = User
                .builder()
                .login("quaz")
                .address(address)
                .build();
        //when
        userRepository.save(user);
        //then
        assertThat(userRepository.findById(user.getId()).get()).isNotNull();
    }
}

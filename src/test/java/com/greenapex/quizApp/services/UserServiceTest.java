package com.greenapex.quizApp.services;

import com.greenapex.quizApp.entities.User;
import com.greenapex.quizApp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(dummyUser());
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyUser()));
        Mockito.when(userRepository.findAll()).thenReturn(dummyUserList());
    }

    @Test
    public void addAndUpdateUser() {
        User user = userService.addAndUpdateUser(dummyUser());
        assertEquals("Soumya47",user.getUserName());
        assertEquals("abc124",user.getPassword());
        assertEquals("soumya@email.com",user.getEmail());
    }

    @Test
    public void getUserById() {
        User user = userService.getSpecificUser(1);
        assertEquals("Soumya47",user.getUserName());
        assertEquals("abc124",user.getPassword());
        assertEquals("soumya@email.com",user.getEmail());
    }

    @Test
    public void getAllUser() {
        List<User> users = userService.getAllUser();
        assertEquals(4,users.size());
        assertEquals("abc125",users.get(3).getPassword());
    }

    private static User dummyUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Soumya47");
        user.setPassword("abc124");
        user.setEmail("soumya@email.com");
        return user;
    }

    private static List<User> dummyUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Soumya47","soumya@email.com","abc124"));
        userList.add(new User("Saurav56","saura@email.com","abc129"));
        userList.add(new User("Gauri89","gauri@email.com","abc126"));
        userList.add(new User("Hritik20","hritik@email.com","abc125"));
        return userList;
    }

}
package hu.adakiss.sample.service;

import java.util.Optional;

import hu.adakiss.sample.dalmock.User;

public interface UserService {

  Optional<User> findUserByUsername(String username);

  User addUser(User user);
}

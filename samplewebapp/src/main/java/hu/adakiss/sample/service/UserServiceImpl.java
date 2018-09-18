package hu.adakiss.sample.service;

import java.util.Optional;

import hu.adakiss.sample.dalmock.DaoMock;
import hu.adakiss.sample.dalmock.User;
import hu.adakiss.sample.exception.SampleAppException;

public class UserServiceImpl implements UserService {

  @Override
  public Optional<User> findUserByUsername(final String username) {
    return DaoMock.findUserByUsername(username);
  }

  @Override
  public User addUser(final User user) {
    if (findUserByUsername(user.getUsername()).isPresent()) {
      throw new SampleAppException("Given username is already taken");
    }
    return DaoMock.addUser(user);
  }
}

package org.leme.z00.components.dao.user;

import java.util.Collection;
import java.util.List;

import org.leme.z00.components.domain.user.PasswordHash;
import org.leme.z00.components.domain.user.User;

public class UserDaoFileImpl implements UserDao
{

  @Override
  public PasswordHash loadPasswordHash(User user) {
    return null;
  }

  @Override
  public void updatePasswordHash(PasswordHash passwordHash) {

  }

  @Override
  public List<User> loadAll() {
    return null;
  }

  @Override
  public User loadById(Integer integer) {
    return null;
  }

  @Override
  public User findByNameTopOne(String s) {
    return null;
  }

  @Override
  public List<User> findByNameAll(String s) {
    return null;
  }

  @Override
  public User save(User user) {
    return null;
  }

  @Override
  public void save(Collection<User> collection) {

  }

  @Override
  public User delete(User user) {
    return null;
  }

  @Override
  public void delete(Collection<User> collection) {

  }

  @Override
  public void dropTable(String s) {

  }
}

package org.leme.z00.components.dao.user;

import java.util.List;

import org.leme.hibernate.base.dao.EntityDao;
import org.leme.z00.components.domain.user.PasswordHash;
import org.leme.z00.components.domain.user.User;

public interface UserDao extends EntityDao<User, Integer>
{
  PasswordHash loadPasswordHash(User user);
  void updatePasswordHash(PasswordHash passwordHash);
}

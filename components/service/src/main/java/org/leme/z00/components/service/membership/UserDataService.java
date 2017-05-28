package org.leme.z00.components.service.membership;

import java.util.List;

import org.leme.z00.components.domain.Z00CustomException;
import org.leme.z00.components.domain.user.User;
import org.leme.z00.components.domain.user.report.RoleUserReport;

public interface UserDataService
{
  
  public User loadById(Integer id);
  public User findByName(String name);
  public User save(User user);
  public void updatePassword(User user, String password, boolean isTemp) throws Z00CustomException;
  public boolean validatePassword(User user, String password) throws Z00CustomException;
  public List<User> getAllUsers();
  public void delete(User user);
  public RoleUserReport getRoleUserReport();
}

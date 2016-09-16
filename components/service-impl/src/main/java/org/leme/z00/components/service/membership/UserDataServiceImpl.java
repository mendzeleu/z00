package org.leme.z00.components.service.membership;

import java.util.List;

import org.leme.z00.components.dao.user.UserDao;
import org.leme.z00.components.domain.Z00CustomException;
import org.leme.z00.components.domain.user.PasswordHash;
import org.leme.z00.components.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDataServiceImpl implements UserDataService
{
  
  @Autowired
  private UserDao userDao;
  
  public UserDataServiceImpl()
  {
  }

  public User loadById(Integer id){
    return userDao.loadById(id);
  }

  public User findByName(String name)
  {
    return userDao.findByNameTopOne(name);
  }

  public User save(User user)
  {
    return userDao.save(user);
  }

  public void updatePassword(User user, String password, boolean isTemp) throws Z00CustomException
  {
    try
    {    
      PasswordHash ph_old = userDao.loadPasswordHash(user);
      PasswordHash ph;
      ph = PasswordHash.generateHash(user, password);
      if(ph_old != null){
        ph.setId(ph_old.getId());
        ph.setIsTemp(isTemp);
      }    
      userDao.updatePasswordHash(ph);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new Z00CustomException("Error updating user password", e);
    }
  }

  public boolean validatePassword(User user, String password) throws Z00CustomException
  {
    PasswordHash ph = userDao.loadPasswordHash(user);
    if(ph != null){
      try
      {       
        return ph.validate(password);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        throw new Z00CustomException("System error. Password can't be validated", e);
      }
    }
    return false;
  }

  public List<User> getAllUsers(){
    return userDao.loadAll();
  }
  
  public void delete(User user){
    userDao.delete(user);
  }
}

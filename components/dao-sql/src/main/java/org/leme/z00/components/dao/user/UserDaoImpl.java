package org.leme.z00.components.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.leme.hibernate.base.dao.DbCommonEntityDao;
import org.leme.z00.components.domain.user.PasswordHash;
import org.leme.z00.components.domain.user.User;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl extends DbCommonEntityDao<User, Integer> implements UserDao
{

  @Autowired
  private SessionFactory sessionFactory;  

  public PasswordHash loadPasswordHash(User user)
  {
    Session session = sessionFactory.openSession();
    Criteria criteria = session.createCriteria(PasswordHash.class);
    PasswordHash ph = (PasswordHash) criteria.add(Restrictions.eq("user", user)).uniqueResult();
    return ph;
    
  }

  @Transactional(readOnly = false)  
  public void updatePasswordHash(PasswordHash passwordHash)
  {
    Session session = sessionFactory.openSession();   
    session.saveOrUpdate(passwordHash);  
    session.flush();
  }

}

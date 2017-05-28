package org.leme.z00.components.dao.user;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.leme.hibernate.base.dao.DbCommonEntityDao;
import org.leme.z00.components.domain.user.PasswordHash;
import org.leme.z00.components.domain.user.User;
import org.leme.z00.components.domain.user.report.RoleUserReport;
import org.leme.z00.components.domain.user.report.RoleUserReportItem;
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

  @Override
  public RoleUserReport loadRoleUserReport() {
    Session session = sessionFactory.openSession();
    SQLQuery sql = session.createSQLQuery(
            "SELECT r.ID as ROLE_ID, r.NAME as ROLE_NAME, ur.ID as USER_ROLE_ID, u.ID as USER_ID, u.NAME as USER_NAME, " +
            "u.FIRST_NAME as USER_FIRST_NAME, u.LAST_NAME as USER_LAST_NAME, u.EMAIL as  USER_EMAIL, u.CREATED_DATE as CREATED_DATE " +
            "FROM SEC_ROLE r " +
            "INNER JOIN  SEC_USER_ROLE ur ON r.ID = ur.ROLE_ID " +
            "INNER JOIN  SEC_USER u ON ur.USER_ID = u.ID " +
            "ORDER BY r.NAME, u.NAME ").addEntity(RoleUserReportItem.class);
    List<RoleUserReportItem> list = sql.list();
    RoleUserReport report = new RoleUserReport(list);
    return report;
  }
}

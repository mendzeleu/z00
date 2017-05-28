package org.leme.z00.web.z00web.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
@Component
public class DBConstructUtils{

 @Autowired
 private DataSource dataSource;
 
 @PostConstruct
 public void initialize(){
  try {
   Connection connection = dataSource.getConnection();
   Statement statement = connection.createStatement();

   statement.executeUpdate(
     "CREATE TABLE IF NOT EXISTS SEC_USER(" +
     "ID INTEGER Primary key, " +
     "NAME varchar(50) not null, " +
     "FIRST_NAME varchar(50) not null, " +
     "LAST_NAME varchar(50) not null, " +
     "EMAIL varchar(50) not null, " +
     "CREATED_DATE DATETIME NOT NULL)"
   );

   statement.executeUpdate(
       "CREATE TABLE IF NOT EXISTS SEC_USER_PASSWORD(" +
       "ID INTEGER Primary key, " +
       "USER_ID INTEGER not null, " +
       "IS_TEMP INTEGER not null, " +
       "SULT varchar(500) not null, " +
       "PASSWORD_HASH varchar(500) not null)"
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_ROLE(" +
                   "ID INTEGER Primary key, " +
                   "NAME varchar(50) not null)"
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_USER_ROLE(" +
                   "ID INTEGER Primary key, " +
                   "USER_ID INTEGER not null, " +
                   "ROLE_ID INTEGER not null)"
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_FEATURE(" +
                   "ID INTEGER Primary key, " +
                   "NAME varchar(50) not null)"
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_FEATURE_ROLE(" +
                   "ID INTEGER Primary key, " +
                   "FEATURE_ID INTEGER not null, " +
                   "ROLE_ID INTEGER not null, " +
                   "TYPE_READ INTEGER not null, " +
                   "TYPE_ADD INTEGER not null, " +
                   "TYPE_EDIT INTEGER not null, " +
                   "TYPE_DELETE INTEGER not null) "
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_URL(" +
                   "ID INTEGER Primary key, " +
                   "URL varchar(1000) not null, " +
                   "METHOD varchar(50) not null, " +
                   "TYPE_READ INTEGER not null, " +
                   "TYPE_ADD INTEGER not null, " +
                   "TYPE_EDIT INTEGER not null, " +
                   "TYPE_DELETE INTEGER not null) "
   );

   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS SEC_FEATURE_URL(" +
                   "ID INTEGER Primary key, " +
                   "FEATURE_ID INTEGER not null, " +
                   "URL_ID INTEGER not null)"
   );


   statement.executeUpdate(
          "INSERT INTO SEC_USER(ID,NAME,FIRST_NAME,LAST_NAME,EMAIL, CREATED_DATE) "+
          "SELECT 1, 'ADMIN' ,'ADMIN_FIRST_NAME','ADMIN_LAST_NAME','ADMIN@EMAIL.COM', '2016-01-01' "+
          "WHERE NOT EXISTS(SELECT 1 FROM SEC_USER WHERE id = 1); "+

          "INSERT INTO SEC_USER(ID,NAME,FIRST_NAME,LAST_NAME,EMAIL, CREATED_DATE) "+
          "SELECT 2, 'USER' ,'USER_FIRST_NAME','USER_LAST_NAME','USER@EMAIL.COM', '2016-01-01' "+
          "WHERE NOT EXISTS(SELECT 1 FROM SEC_USER WHERE id = 2); "+

          "INSERT INTO SEC_USER(ID,NAME,FIRST_NAME,LAST_NAME,EMAIL, CREATED_DATE) "+
          "SELECT 3, 'MANAGER' ,'MANAGER_FIRST_NAME','MANAGER_LAST_NAME','MANAGER@EMAIL.COM', '2016-01-01' "+
          "WHERE NOT EXISTS(SELECT 1 FROM SEC_USER WHERE id = 3); "
   );

   statement.executeUpdate(
      "INSERT INTO SEC_ROLE(ID,NAME)  SELECT 1, 'ROLE_ADMIN'  WHERE NOT EXISTS(SELECT 1 FROM SEC_ROLE WHERE id = 1); " +
      "INSERT INTO SEC_ROLE(ID,NAME)  SELECT 2, 'ROLE_SIMPLE_USER'  WHERE NOT EXISTS(SELECT 1 FROM SEC_ROLE WHERE id = 2); " +

      "INSERT INTO SEC_USER_ROLE(ID,USER_ID,ROLE_ID)  SELECT 1,1,1  WHERE NOT EXISTS(SELECT 1 FROM SEC_USER_ROLE WHERE id = 1); " +
      "INSERT INTO SEC_USER_ROLE(ID,USER_ID,ROLE_ID)  SELECT 2,3,1  WHERE NOT EXISTS(SELECT 1 FROM SEC_USER_ROLE WHERE id = 2); " +
      "INSERT INTO SEC_USER_ROLE(ID,USER_ID,ROLE_ID)  SELECT 3,2,2  WHERE NOT EXISTS(SELECT 1 FROM SEC_USER_ROLE WHERE id = 3); "
   );



   statement.executeUpdate(
           "CREATE TABLE IF NOT EXISTS TERMS(" +
                   "ID INTEGER Primary key, " +
                   "KEY VARCHAR(255) not null, " +
                   "VALUE VARCHAR(1000) not null)"
   );

   statement.executeUpdate(
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 1,'acct_trm','Account'  WHERE NOT EXISTS(SELECT 1 FROM TERMS WHERE id = 1); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 2,'fn_trm','First Name'  WHERE NOT EXISTS(SELECT 2 FROM TERMS WHERE id = 2); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 3,'fn_trm_prfx','FN: '  WHERE NOT EXISTS(SELECT 3 FROM TERMS WHERE id = 3); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 4,'urid_trm','User Role Id'  WHERE NOT EXISTS(SELECT 4 FROM TERMS WHERE id = 4); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 5,'rid_trm','Role Id'  WHERE NOT EXISTS(SELECT 5 FROM TERMS WHERE id = 5); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 6,'uid_trm','User Id'  WHERE NOT EXISTS(SELECT 6 FROM TERMS WHERE id = 6); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 7,'un_trm','User Name'  WHERE NOT EXISTS(SELECT 7 FROM TERMS WHERE id = 7); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 8,'ln_trm','Last Name'  WHERE NOT EXISTS(SELECT 8 FROM TERMS WHERE id = 8); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 9,'eml_trm','Email'  WHERE NOT EXISTS(SELECT 9 FROM TERMS WHERE id = 9); " +
           "INSERT INTO TERMS(ID,KEY,VALUE)  SELECT 10,'role_trm','Role'  WHERE NOT EXISTS(SELECT 10 FROM TERMS WHERE id = 10);"
   );


   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }
 }
}
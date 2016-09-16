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
     "CREATE TABLE IF NOT EXISTS USER(" +
     "ID INTEGER Primary key, " +
     "NAME varchar(50) not null, " +
     "FIRST_NAME varchar(50) not null, " +
     "LAST_NAME varchar(50) not null, " +
     "EMAIL varchar(50) not null)"
     );

   statement.executeUpdate(
       "CREATE TABLE IF NOT EXISTS USER_PASSWORD(" +
       "ID INTEGER Primary key, " +
       "USER_ID INTEGER not null, " +
       "IS_TEMP INTEGER not null, " +
       "SULT varchar(500) not null, " +
       "PASSWORD_HASH varchar(500) not null)"
       );
   
   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }
 }
}
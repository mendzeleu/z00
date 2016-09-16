package org.leme.z00.components.domain.user;

import org.leme.hibernate.base.entity.DbEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends DbEntity<Integer>
{
  
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "FIRST_NAME")    
    private String firstName;

    @Column(name = "LAST_NAME")    
    private String lastName;

    @Column(name = "EMAIL")    
    private String email;
        
    
    public User()
    {
      // TODO Auto-generated constructor stub
    }

    public String getName()
    {
      return name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public String getFirstName()
    {
      return firstName;
    }

    public void setFirstName(String firstName)
    {
      this.firstName = firstName;
    }

    public String getLastName()
    {
      return lastName;
    }

    public void setLastName(String lastName)
    {
      this.lastName = lastName;
    }

    public String getEmail()
    {
      return email;
    }

    public void setEmail(String email)
    {
      this.email = email;
    }

    @Override
    public int hashCode()
    {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result
          + ((firstName == null) ? 0 : firstName.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj)
    {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      User other = (User) obj;
      if (email == null)
      {
        if (other.email != null)
          return false;
      }
      else if (!email.equals(other.email))
        return false;
      if (firstName == null)
      {
        if (other.firstName != null)
          return false;
      }
      else if (!firstName.equals(other.firstName))
        return false;
      if (id == null)
      {
        if (other.id != null)
          return false;
      }
      else if (!id.equals(other.id))
        return false;
      if (lastName == null)
      {
        if (other.lastName != null)
          return false;
      }
      else if (!lastName.equals(other.lastName))
        return false;
      if (name == null)
      {
        if (other.name != null)
          return false;
      }
      else if (!name.equals(other.name))
        return false;
      return true;
    }

    @Override
    public String toString()
    {
      return "User [id=" + id + ", name=" + name + ", firstName=" + firstName
          + ", lastName=" + lastName + ", email=" + email + "]";
    }
    
    

}

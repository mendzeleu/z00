package org.leme.z00.components.domain.user;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
@Table(name = "USER_PASSWORD")
public class PasswordHash
{
  
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Integer id;
    
  @Column(name = "PASSWORD_HASH")
  private String passwordHash;
  
  @Column(name = "SULT")
  private String passwordSult;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "IS_TEMP", columnDefinition = "INTEGER")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean isTemp;  
  
  public PasswordHash()
  {
  }

  public PasswordHash(String passwordHash, String passwordSult)
  {
    super();
    this.passwordHash = passwordHash;
    this.passwordSult = passwordSult;
    this.isTemp = false;
  }  
  
  public PasswordHash(String passwordHash, String passwordSult, Boolean isTemp)
  {
    super();
    this.passwordHash = passwordHash;
    this.passwordSult = passwordSult;
    this.isTemp = isTemp;
  }
  
  public String getPasswordHash()
  {
    return passwordHash;
  }
  public void setPasswordHash(String passwordHash)
  {
    this.passwordHash = passwordHash;
  }
  public String getPasswordSult()
  {
    return passwordSult;
  }
  public void setPasswordSult(String passwordSult)
  {
    this.passwordSult = passwordSult;
  }
  
  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }
  
  public boolean getIsTemp()
  {
    return isTemp;
  }

  public void setIsTemp(boolean isTemp)
  {
    this.isTemp = isTemp;
  }

  public static PasswordHash generateHash(User user, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    
    SecureRandom rnd = new SecureRandom();
    byte saltB[] = rnd.generateSeed(128);
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(saltB);
    md.update(password.getBytes("UTF-8")); 
    byte[] digest = md.digest();    
    String hash = bytesToHex(digest);
    String salt = bytesToHex(saltB);
    PasswordHash ph = new PasswordHash(hash, salt);
    ph.setUser(user);
    return ph;
  }

  public boolean validate(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    byte saltB[] = hexStringToByteArray(this.passwordSult);
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(saltB);
    md.update(password.getBytes("UTF-8"));
    byte[] digest = md.digest();    
    String hash = bytesToHex(digest);
    if((hash != null) && (hash.equals(this.passwordHash))){
      return true;
    }
    return false;
  }
  
  private static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
  }

  private static String bytesToHex(byte[] bytes) {
    final char[] hexArray = "0123456789ABCDEF".toCharArray();    
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
  }




  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + (isTemp ? 1231 : 1237);
    result = prime * result
        + ((passwordHash == null) ? 0 : passwordHash.hashCode());
    result = prime * result
        + ((passwordSult == null) ? 0 : passwordSult.hashCode());
    result = prime * result + ((user == null) ? 0 : user.hashCode());
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
    PasswordHash other = (PasswordHash) obj;
    if (id == null)
    {
      if (other.id != null)
        return false;
    }
    else if (!id.equals(other.id))
      return false;
    if (isTemp != other.isTemp)
      return false;
    if (passwordHash == null)
    {
      if (other.passwordHash != null)
        return false;
    }
    else if (!passwordHash.equals(other.passwordHash))
      return false;
    if (passwordSult == null)
    {
      if (other.passwordSult != null)
        return false;
    }
    else if (!passwordSult.equals(other.passwordSult))
      return false;
    if (user == null)
    {
      if (other.user != null)
        return false;
    }
    else if (!user.equals(other.user))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "PasswordHash [id=" + id + ", passwordHash=" + passwordHash
        + ", passwordSult=" + passwordSult + ", user=" + user + ", isTemp=" + isTemp + "]";
  }
  
  
  
}

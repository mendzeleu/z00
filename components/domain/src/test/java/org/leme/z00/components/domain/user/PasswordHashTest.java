package org.leme.z00.components.domain.user;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

public class PasswordHashTest
{

  @Before
  public void setUp() throws Exception
  {
  }

  @Test
  public void test() throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    User u = new User();
    PasswordHash h = PasswordHash.generateHash(u, "qwerty");
    System.out.println(h.getPasswordSult());
    System.out.println(h.getPasswordHash());
    
    assertTrue(h.validate("qwerty"));
    assertFalse(h.validate("qwerty6"));
    
    PasswordHash h2 = new PasswordHash();
    h2.setUser(u);
    h2.setPasswordSult("85E09951B4CA97A89910D74333EFC8DA8E1EAE19C5C4B76BFAEB79BBB6A012ADF4BFE74978DAB0CE96D518E3033B7D4229BAE1583016F5B54F57199C3AE027F490352C3B5FC14916369DD6652CA69EFBEAEF70C01220772E8B18626A59DF3A522BEFDCCE85D365B0AE3AABE4CBDF9645726896069EFAB8429A3670B5A9651BF1");
    h2.setPasswordHash("E2F4D8BCC5F414DA533BEED8BE75520E1CAF429AF446B99A1376FC61255705EF");

    assertTrue(h2.validate("qwerty"));
    assertFalse(h2.validate("qswerty6"));    
  }

}

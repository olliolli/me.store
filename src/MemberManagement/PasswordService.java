/**@author Grunewald Stephanie
 * @version 1.0
 */
package MemberManagement;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.naming.ServiceUnavailableException;
import sun.misc.BASE64Encoder;

public class PasswordService
{
  private static PasswordService instance;
  
  public PasswordService()
  {
  }
  
  public synchronized String Encrypt(String plaintext) throws ServiceUnavailableException
  {
    MessageDigest md = null;
    try
    {
      md = MessageDigest.getInstance("SHA"); 
/* Step 2: We are asking Java security API to obtain an instance of a 
 * message digest object using the algorithm supplied 
 * (in this case, SHA-1 message digest algorithm will be used. 
 * Both SHA and SHA-1 refer to the same thing, a revised SHA algorithm). 
 */
    }
    catch(NoSuchAlgorithmException e)
    {
      throw new ServiceUnavailableException(e.getMessage());
    }
    try
    {
      md.update(plaintext.getBytes("UTF-8"));
/*Step 3: Feed the data:
 * a) convert the plaintext password (eg, "jsmith") into a byte-representation using UTF-8 encoding format
 * b) apply this array to the message digest object created earlier. This array will be used as a source for the message digest object to operate on. 
 */
    }
    catch(UnsupportedEncodingException e)
    {
      throw new ServiceUnavailableException(e.getMessage());
    }
    byte raw[] = md.digest();
    /*Step 4: Do the transformation: generate an array of bytes that 
     * represent the digested (encrypted) password value.
     */
    String hash = (new BASE64Encoder()).encode(raw); 
    /*Step 5: Create a String representation of the byte array 
     * representing the digested password value. 
     * This is needed to be able to store the password in the database. 
     * At this point, the hash value of the plaintext "jsmith" 
     * is "5yfRRkrhJDbomacm2lsvEdg4GyY=". 
     */

    return hash; 
    /*Step 6: Return the String representation of the 
     * newly generated hash back to our registration 
     * servlet so that it can be stored in the database. 
     * The user.getPassword() method now returns "5yfRRkrhJDbomacm2lsvEdg4GyY=" 
     */


  }
  public static synchronized PasswordService getInstance() 
  /*Step 1: The registration servlet will interface with our 
   * PasswordService class using this static getInstance() method. 
   * Whenever it is invoked, a check will be made to see if an instance 
   * of this service class already exists. If so, it will be returned 
   * back to the caller (registration servlet). Otherwise, a new instance 
   * will be created. 
   */
  {
    if(instance == null)
    {
      return new PasswordService();
    } 
    else    
    {
      return instance;
    }
  }
}


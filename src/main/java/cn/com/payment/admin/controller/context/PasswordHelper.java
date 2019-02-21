package cn.com.payment.admin.controller.context;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.com.payment.admin.model.Admin;

public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static final String algorithmName = "md5";
    private static final int hashIterations = 2;
    
    /**
     * 验证密码
     * @param user
     * @return
     */
    public static boolean validatePwd(Admin user,String pwd) {
        String newPassword = new SimpleHash(
                algorithmName,
                pwd,
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();
       return user.getPswd().equals(newPassword);
    }
    
    public void encryptPasswor(Admin admin) {
    	admin.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                 algorithmName,
                 admin.getPswd(),
                 ByteSource.Util.bytes(admin.getSalt()),
                 hashIterations).toHex();
        admin.setPswd(newPassword);
    }
    
    public static void main(String[] args) {
    	Admin u = new Admin();
		u.setName("admin");
		u.setPswd("123");
		new PasswordHelper().encryptPasswor(u);
		
		System.out.println(u.getPswd() + " "+u.getSalt());
	}
}
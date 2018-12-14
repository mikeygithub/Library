package com.mikey.eas.Utils;
import com.mikey.eas.Pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/11/4 10:14
 * @Version 1.0
 */
public class MD5 {
    public static final int DEFAULT_HASHINTERATIONS=1024;//默认进行1024此散列加密
    public static final String HASHALGORITHMNAME="MD5";//默认进行MD5加密
    /**
     * 进行默认MD5盐值加密
     * 采用默认散列加密次数
     * @param user
     * @return
     */
    public static User MD5PWD(User user){
        ByteSource sait= ByteSource.Util.bytes(user.getUserid());
        user.setPassword(new SimpleHash(HASHALGORITHMNAME,user.getPassword(),sait,DEFAULT_HASHINTERATIONS ).toString());
        return user;
    }
    /**
     * 自定义散列加密次数
     * 自定义加密类型
     * @param hashAlgorithmName
     * @param user
     * @param hashInterations
     * @return
     */
    public static User MD5PWD(String hashAlgorithmName,User user,int hashInterations){
        ByteSource sait= ByteSource.Util.bytes(user.getUserid());
        user.setPassword(new SimpleHash(hashAlgorithmName,user.getPassword(),sait,hashInterations).toString());
        return user;
    }
    public static void main(String[] args){//68ddd345a7a2023494e15fa67616ee09
        User user=new User();
        user.setPassword("admin");
        user.setUserid("admin");
        System.out.println("Message="+MD5PWD(user).getPassword());//f8bcc5b55f1052fd647d610d5c3a5b17
    }
}

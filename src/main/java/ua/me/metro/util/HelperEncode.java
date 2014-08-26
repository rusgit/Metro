package ua.me.metro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

@Named("helperEncode")
public class HelperEncode implements PasswordEncoder {

    private MessageDigest md;

    public HelperEncode () {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {

        if(md==null) {
            return rawPassword.toString();
        }

        md.update(rawPassword.toString().getBytes());

        byte byteDate[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i<byteDate.length; i++) {
            String hex = Integer.toHexString(0xff & byteDate[i]);
            if (hex.length()==1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encode(rawPassword).equals(encodedPassword);
    }


}

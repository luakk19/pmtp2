package ar.edu.unnoba.mp2026.courses.util;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class PasswordEncoder {

    private final BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);

    public String encode(String rawPassword) {
        return Password.hash(rawPassword).with(bcrypt).getResult();
    }

    public boolean verify(String rawPassword, String encodedPassword) {
        return Password.check(rawPassword, encodedPassword).with(bcrypt);
    }
}

package uz.pdp.services.auth;

import org.springframework.stereotype.Service;
import uz.pdp.dao.AuthUserDao;
import uz.pdp.models.Auth;

import java.util.List;

@Service
public class AuthService {

    private final AuthUserDao authUserDao;

    public AuthService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    public List<Auth> getAll() {
        return authUserDao.getAll();
    }

    public Boolean isAdmin(Auth auth) {
        List<Auth> users = getAll();
        for (Auth user : users) {
            if (user.getUsername().equals(auth.getUsername()) && user.getPassword().equals(auth.getPassword())
                    && user.getRole().equalsIgnoreCase("admin")) {
                return true;
            }
        }
        return false;
    }
}

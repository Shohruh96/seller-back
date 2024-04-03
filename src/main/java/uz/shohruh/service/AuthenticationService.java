package uz.shohruh.service;

import uz.shohruh.model.User;

public interface AuthenticationService {

    User signInAndReturnJWT(User signInRequest);
}

package uz.pdp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Auth {
    private String username;
    private String password;
    private String role;

}

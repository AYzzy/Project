package africaSemicolon.contact4.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    public boolean isLogin ;
    private String username;
    private String password;

}

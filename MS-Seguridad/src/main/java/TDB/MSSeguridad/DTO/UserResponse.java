package TDB.MSSeguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private final String token;
    private final String userName;
    private final String accessTokenExpiracion;
}

package TDB.MSSeguridad.jwt;



import java.security.Key;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import TDB.MSSeguridad.models.UsuarioModel;
import TDB.MSSeguridad.parametrizacion.menssages;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;

@Component//obligatorio si no no corre el jwt
@NoArgsConstructor
public class jwtToken extends menssages{
    
    @Value("${jwt.secreto}")
    private String secreto;


    public String GeneracionToken(UsuarioModel usuarioEntity){
        Key hamcKey = new SecretKeySpec(secreto.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Instant Ahora  = Instant.now();

        String jwtToken = Jwts.builder().claim("Usuario1d: ", usuarioEntity.getCorreo()).setSubject(usuarioEntity.getCorreo())
                                .setId(UUID.randomUUID().toString())
                                .setIssuedAt(Date.from(Ahora))
                                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_ONE_DAY_VALIDATION * MILISEGUNDOS))
                                .signWith(hamcKey)
                                .compact();


        return jwtToken;
    }
}

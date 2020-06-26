package cm.ubuea.covider.profile_module.util;

import cm.ubuea.covider.profile_module.models.UserProfile;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenUtility {

    @Value("${jwt.signing.key.secret}")
    private String secret;

    @Value("${jwt.token.expiration.in.seconds}")
    private Long expiration;


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
       JwtParser p =  Jwts.parserBuilder().setSigningKey(secret).build();

        return p.parseClaimsJws(token).getBody();
    }
    private boolean isTokenExpired(String token) {
        final  Date expiration = getExpirationDateFromToken(token);
        return  expiration.before(Date.from(Instant.now()));
    }
    private boolean ignoreTokenExpiration(String token) {
        return false;
    }
    public String generateToken(org.springframework.security.core.userdetails.UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return generator(claims, userDetails.getUsername());
    }
    private String generator(Map<String, Object> claims, String subject) {
        final Date createdDate = Date.from(Instant.now());
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
//                .signWith(secret, SignatureAlgorithm.HS512)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public boolean canBeRefreshed(String token) {
        return (!isTokenExpired(token)|| ignoreTokenExpiration(token));
    }
    public String refreshToken(String token) {
        final Date createdDate = Date.from(Instant.now());//clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public boolean validateToken(String token, org.springframework.security.core.userdetails.UserDetails userDetails) {
        UserProfile user = (UserProfile)userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime()+expiration*1000);
    }
}

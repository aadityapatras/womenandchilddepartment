package womenandchilddepartment.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import womenandchilddepartment.model.Admin;
import womenandchilddepartment.model.User;
import womenandchilddepartment.service.UsersService;

import java.util.*;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

    @Autowired
    private UsersService usersService;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;


    private String secret = "jwtTokenKey";

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
//public Role getRoleFromToken(String token)
//{
//    return
//}
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

   // generate token for user
     public String generateToken(UserDetails userDetails) {
                                                                    Map<String, Object> claims = new HashMap<>();
                                                                    return doGenerateToken(claims, userDetails.getUsername());
                                                                }


    public String generateToken(Admin admin) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", admin.getAuthorities()); // Use authorities from Admin model
        return doGenerateToken(claims, admin.getUsername());
    }


    public String generateToken(User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", getRolesFromDatabase(userDetails.getUserConfId()));
        return doGenerateToken(claims, userDetails.getUserConfId());
    }

        // ... (other methods and properties)

        // generate token for user with roles from the database
//        public String generateToken(UserDetails userDetails) {
//            Map<String, Object> claims = new HashMap<>();
//             // Fetch roles from the database
//            return doGenerateToken(claims, userDetails.getUsername());
//        }

        // Fetch user roles from the database based on username
        private Object getRolesFromDatabase(String UserConfId) {
            // Implement your database query to fetch roles for the given username
            // For example, you can use a UserDetailsService to fetch roles from the database
            // Here, we assume you have a method called "getRolesByUsername" in your service or repository
            User user = usersService.findByUsername(UserConfId);
            if (user != null) {
                return user.getRole(); // Return the roles associated with the user
            }
            return Collections.emptyList(); // Return an empty list if the user is not found
        }

        // ... (other methods)


    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))

                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

//    return Jwts.builder()
//            .setSubject(subject) // Typically, this is the username or user ID
//                .claim("roles", roles)
//                .setIssuedAt(now)
//                .setExpiration(expiration)
//                .signWith(SECRET_KEY)
//                .compact();
//}

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}

	


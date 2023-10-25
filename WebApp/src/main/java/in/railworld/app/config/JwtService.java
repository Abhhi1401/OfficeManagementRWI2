     
package in.railworld.app.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	private final String SECERT ="8dTAvN5z53bEdCx7h3aW6gahj9zIAb0xWTS95slt0rRUn1GJSjHNgd/DOuN40kH5TA/IiCVGWXmIl/xQGjCKOOs92qbLJqa/l4RvH7cICHXRgHrj318d/GMCcMJMV7jDUyd9L/cTztClKXe6hiitHVANI6xCt2kgUJs9d+aiIPXMSJSch7Kz6/Lrpj6MIlMYhnvD779rCNP8hYR9mkHse6EnLG0ssGyzo3XLZpQ/wniG85T8Dm7qlPaTEV0sP/GXnz4twHEExPj5DNhJVGOmebq+cjtDv9g484suHfRjWDmrLNykUYAfsId3GsnvbY6w5K5XqY1QbVffNDKum4/dNg==";
	
	public String generateToken(String username) {
		Map<String ,Object> claims= new HashMap();
		return createToken(username ,claims);
	}
	
	

	private String createToken(String username, Map<String, Object> claims) {
		// TODO Auto-generated method stub
		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date (System.currentTimeMillis()+1000*60*10))
                .signWith( getSignKey(),SignatureAlgorithm.HS256)
                .compact();
				
	}



	private Key getSignKey() {
		byte[] keyCodes = Decoders.BASE64.decode(SECERT);
		return Keys.hmacShaKeyFor(keyCodes);
	}



	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	private<T> T extractClaim(String token,Function<Claims,T> claimResolver) {
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	
	public Boolean validateToken(String token,UserDetails userDetails) {
		final String username=extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}



    public String refreshToken(String token) {
        final Claims claims = extractAllClaims(token);

        // Check if the token is close to expiration (adjust the threshold as needed)
        if (isTokenExpiringSoon(token)) {
            // Extend the expiration time (e.g., 30 more minutes from the current time)
            claims.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

            // Build a new token with the updated expiration time
            return Jwts.builder()
                    .setClaims(claims)
                    .signWith(getSignKey(), SignatureAlgorithm.HS256)
                    .compact();
        }

        // If the token is not close to expiration, return the original token
        return token;
    }

    // Other methods...

    public Boolean isTokenExpiringSoon(String token) {
        final Claims claims = extractAllClaims(token);
        Date expiration = claims.getExpiration();
        Date now = new Date();
        // Check if the token will expire in less than 5 minutes (adjust this threshold as needed)
        return expiration != null && expiration.before(new Date(now.getTime() + 1000 * 60 * 5));
    }

	



	

}
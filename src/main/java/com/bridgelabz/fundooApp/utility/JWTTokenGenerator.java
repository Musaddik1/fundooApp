package com.bridgelabz.fundooApp.utility;


import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JWTTokenGenerator implements ITokenGenerator {

    String secret_token="fundoo9823139449";

	@Override
	public String generateToken(String id) {
		String token = Jwts.builder()
				  .setSubject("fundooNotes")
				  .setExpiration(new Date(System.currentTimeMillis() + 17777000))
				  .setId(id)
				  .signWith(SignatureAlgorithm.HS256, secret_token)
				  .compact();
		return token;
	}

	@Override
	public String verifyToken(String token) {
		Jws<Claims> claims = Jwts.parser()
		  .setSigningKey(secret_token)
		  .parseClaimsJws(token);
		String userId = claims.getBody().getId();
		return userId;
	}
	
	
	
	
//	static final String secret_token="fundoo9823139449";
//	public static String generateToken(String userid) throws IllegalArgumentException, UnsupportedEncodingException
//	{ 
//		Algorithm algorithm=Algorithm.HMAC256(secret_token);
//		String token=JWT.create().withClaim("userid", userid).sign(algorithm);
//		return token;
//		
//		
//	}
//	public static String verifyToken(String token ) throws IllegalArgumentException, UnsupportedEncodingException
//	{
//		String userid;
//		Verification verification=JWT.require(Algorithm.HMAC256(TokenUtil.secret_token));
//		JWTVerifier jwtVerifier=verification.build();
//		DecodedJWT decodedJWT=jwtVerifier.verify(token);
//		Claim claim=decodedJWT.getClaim("USERID");
//		userid=claim.asString();
//				return userid;
//	}
	
	
}

package com.bridgelabz.fundooApp.utility;


import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;



@Component
public class TokenUtil {
	static final String secret_token="fundoo9823139449";
	public static String generateToken(String userid) throws IllegalArgumentException, UnsupportedEncodingException
	{ 
		Algorithm algorithm=Algorithm.HMAC256(secret_token);
		String token=JWT.create().withClaim("userid", userid).sign(algorithm);
		return token;
		
		
	}
	public static String verifyToken(String token ) throws IllegalArgumentException, UnsupportedEncodingException
	{
		String userid;
		Verification verification=JWT.require(Algorithm.HMAC256(TokenUtil.secret_token));
		JWTVerifier jwtVerifier=verification.build();
		DecodedJWT decodedJWT=jwtVerifier.verify(token);
		Claim claim=decodedJWT.getClaim("USERID");
		userid=claim.asString();
				return userid;
	}
}

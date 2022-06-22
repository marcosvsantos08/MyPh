package sc.senai.sa.myphsa.seguranca;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sc.senai.sa.myphsa.model.usuario.entity.Usuario;



	@Component
	public class JWTHelper {
		
		@Value("${jwt.secret}")
		private String tokenSecret;
		
		@Value("${jwt.tempo.vida}")
		private Long tempoVida;
		
		public Boolean validarToken(String token) {
			if (isTokenExpirado(token) && getUsuarioDoToken(token).isEmpty()) {
				return false;
			}
			
			return true;
			
		}
		
		public String getUsuarioDoToken(String token) {
			return (String) buscarPayloadDoToken(token).get("usuario");
		}
		private Boolean isTokenExpirado(String token) {
			Date dataValidade = buscarPayloadDoToken(token).getExpiration();
			return dataValidade.before(new Date());
		}
		
		private Claims buscarPayloadDoToken(String token) {
			return Jwts.parser()
					.setSigningKey(tokenSecret)
					.parseClaimsJws(token).getBody();
		}

		public String gerarToken(Usuario usuario) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("usuario", usuario.getEmail());
			return Jwts.builder()
				.setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + (tempoVida * 1000)))
				.signWith(SignatureAlgorithm.HS512, tokenSecret)
				.compact();
		}
	}


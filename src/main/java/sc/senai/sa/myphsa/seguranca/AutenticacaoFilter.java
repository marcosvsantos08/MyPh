package sc.senai.sa.myphsa.seguranca;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


	@Component
	public class AutenticacaoFilter extends OncePerRequestFilter {
		
		@Autowired
		private JWTHelper jwtHelper;

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			String token = request.getHeader("Authorization");
			
			if (request.getRequestURI().contains("/usuario/login")||request.getRequestURI().endsWith("/usuario")|| request.getMethod().equals("OPTIONS")) {
				filterChain.doFilter(request, response);
				return;
			}
			
			if (token == null || !token.startsWith("Bearer")) {
				throw new ServletException("Token Inexistente");
			}
			
			token = token.substring(7);
			if (!jwtHelper.validarToken(token)) {
				throw new ServletException("Token Inválido ou Expirado");
			}
			
			//autenticarUsuario(token);
			
			System.out.println("Passou pelo Filtro");
			filterChain.doFilter(request, response);
		}
}

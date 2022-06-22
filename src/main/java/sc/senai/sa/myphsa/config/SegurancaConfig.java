package sc.senai.sa.myphsa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import sc.senai.sa.myphsa.seguranca.AutenticacaoFilter;



@EnableWebSecurity

public class SegurancaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoFilter autenticacaoFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.anyRequest().permitAll();
	
	http.addFilterBefore(autenticacaoFilter, UsernamePasswordAuthenticationFilter.class);
}
	

}

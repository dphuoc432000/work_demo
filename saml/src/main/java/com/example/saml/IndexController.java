package com.example.saml;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class IndexController {

	@GetMapping("/greeting")
	public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
		System.out.println("vao");
		return "index.html";
	}
}

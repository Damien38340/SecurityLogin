package security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import security.demo.dto.TokenDTO;
import security.demo.dto.UserCredentialsDto;
import security.demo.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/signup")
    public String signup(@RequestBody UserCredentialsDto userCredentialsDto) {
        return "success";
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody UserCredentialsDto userCredentialsDto) {
        final Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userCredentialsDto.username(), userCredentialsDto.password()
                        )
                );
        String token = jwtUtil.generateToken(userCredentialsDto.username());
        return new TokenDTO(token, userCredentialsDto.username());
    }
}


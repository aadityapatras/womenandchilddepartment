package womenandchilddepartment.security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import womenandchilddepartment.dto.Login;
import womenandchilddepartment.exception.ApiException;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.model.User;
import womenandchilddepartment.repo.UserRepo;
import womenandchilddepartment.service.UsersService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);

        try {

            this.authenticationManager.authenticate(authenticationToken);

        } catch (BadCredentialsException e) {
            System.out.println("Invalid Detials !!");
            throw new ApiException("Invalid username or password !!");
        }

    }

//    @PostMapping("/login")
//    public ResponseEntity<JwtAuthResponse> createDepartmentToken(@RequestBody JwtAuthRequest request) throws Exception {
//        this.authenticate(request.getUsername(), request.getPassword());
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
//        String token = this.jwtTokenHelper.generateToken(userDetails);
//
//        JwtAuthResponse response = new JwtAuthResponse();
//        response.setToken(token);
//
//        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
//    }
    
    // register new user api
    @PostMapping("/login555")
    public Object login555(@RequestBody Login loginRequest) {
        String userConfId = loginRequest.getUserConfId();
        String password = loginRequest.getPassword();
        LocalDate dateOfBirth = loginRequest.getDateOfBirth();
//        System.out.println(email);
//        System.out.println(password);
//        LocalDate dateOfBirth = loginRequest.getDateOfBirth();

        boolean isAuthenticated = usersService.authenticateUser(userConfId, password, dateOfBirth );

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Check your credentials.");
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<String> createUserData(@Valid @RequestBody UserDto UserDTO) {

                String createUser= usersService.createUserData(UserDTO);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);}


    // get loggedin user data
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/current-user/")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        User user = this.userRepo.findByEmail(principal.getName()).get();
        return new ResponseEntity<UserDto>(this.mapper.map(user, UserDto.class), HttpStatus.ACCEPTED);
    }

}

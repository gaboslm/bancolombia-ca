package co.com.bancolombia.api;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final UserUseCase userUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userUseCase.getUser(id));
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userUseCase.saveUser(user));
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userUseCase.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userUseCase.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
}

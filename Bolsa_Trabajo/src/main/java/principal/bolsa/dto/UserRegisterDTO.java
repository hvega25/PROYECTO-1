package principal.bolsa.dto;

/*
Ejemplo del json para registrarse
{
    "username": "espinoza",
    "email": "espinoza@correo.com",
    "password": "admin",
    "password2": "admin"
}
 */
public record UserRegisterDTO(String username, String email, String password, String password2) {
}
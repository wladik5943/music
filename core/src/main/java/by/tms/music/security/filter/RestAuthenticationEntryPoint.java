package by.tms.music.security.filter;

import by.tms.music.exception.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;

import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ExceptionResponse responseError = createResponseError(authException.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, responseError);
        out.flush();
    }

    private ExceptionResponse createResponseError(String message) {
        ExceptionResponse errorNoClient = new ExceptionResponse();
        errorNoClient.setCode(401);
        errorNoClient.setMessage(message);
        return errorNoClient;
    }

}

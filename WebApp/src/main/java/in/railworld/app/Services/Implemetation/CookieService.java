package in.railworld.app.Services.Implemetation;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {

    public void setPermanentCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(Integer.MAX_VALUE); 
        cookie.setPath("/"); 
        response.addCookie(cookie);
    }
}

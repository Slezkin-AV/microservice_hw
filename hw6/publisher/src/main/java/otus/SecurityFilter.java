package otus;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;
import java.io.IOException;

//@Component
@Slf4j
@RequiredArgsConstructor
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter extends OncePerRequestFilter {
//    private final UserDetailsService userDetailsService;

//    public SecurityFilter(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        log.info("request headers: {}", request.getContextPath()); // all requests are logging including `/generate/a` or `/validate/1`
//        log.info("request path: {}", request.getQueryString());
//        String username = request.getHeader("X-Username");

//        log.info("request {} : {}",
//                request.getMethod(),
//                request.getRequestURI());
//        request.getHeaderNames().asIterator().forEachRemaining(s -> log.info(s, request.getHeader(s)));
//        log.info("request token: {}",request.getHeader("Authorization"));
//        log.info("request user: {}",request.getRemoteUser());
//        log.info("request headers: {}",request.getHeaderNames());
//        log.info("request Principal: {}",request.getUserPrincipal());
        filterChain.doFilter(request, response);
    }

}
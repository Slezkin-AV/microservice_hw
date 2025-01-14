package otus.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        log.info("{} : {}, Principal: {}, Auth: {}",
                request.getMethod(),
                request.getRequestURI(),
                request.getUserPrincipal(),
                request.getHeader("Authorization"));

        filterChain.doFilter(request, response);
    }

}
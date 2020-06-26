package cm.ubuea.covider.profile_module.util;

import cm.ubuea.covider.profile_module.services.UserProfileService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OneTimeAuthPerReqFilter extends OncePerRequestFilter {

    private static final Logger lg = LoggerFactory.getLogger(OneTimeAuthPerReqFilter.class);

    private TokenUtility tokenUtil;
    private UserProfileService userProfileService;

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    public OneTimeAuthPerReqFilter(UserProfileService userProfileService, TokenUtility tokenUtil) {
        this.tokenUtil = tokenUtil;
        this.userProfileService = userProfileService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String reqTokenHeader = request.getHeader(this.tokenHeader);

        String username = null;
        String token = null;

        if(reqTokenHeader != null && reqTokenHeader.startsWith("Bearer ")) {
            token = reqTokenHeader.substring(7);
            try {
                username = tokenUtil.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                lg.error("Unable to get username", e);
            } catch (ExpiredJwtException ex) {
                logger.warn("Token expired", ex);
            }
        } else { //token is present and starts with 'Bearer '
            lg.warn("Token does not start with 'bearer'");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
            UserDetails userDetails = this.userProfileService.loadUserByUsername(username);

            if(tokenUtil.validateToken(token,userDetails)) {
                UsernamePasswordAuthenticationToken upAuthToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                upAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(upAuthToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

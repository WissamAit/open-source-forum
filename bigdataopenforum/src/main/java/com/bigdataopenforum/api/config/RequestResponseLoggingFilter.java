package com.bigdataopenforum.api.config;

import com.bigdataopenforum.api.repositories.user.UserMetadataRepository;
import com.bigdataopenforum.api.repositories.user.entities.UserMetadata;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
@Slf4j
@AllArgsConstructor
public class RequestResponseLoggingFilter implements Filter {

    private static final String USERNAME = "username";
    private final UserMetadataRepository metadataRepository;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        log.info("Request called from {}", req.getRequestURI());
        log.info("POST ID {}", req.getParameter("postId"));
        log.info("HEADER USERNAME {}", req.getHeader(USERNAME));
        log.info("HEADER AGENT {}", req.getHeader("User-Agent"));

        UserMetadata userMetadata = UserMetadata.builder()
                .id(UUID.randomUUID().toString())
                .action(req.getMethod())
                .navigator(req.getRequestURI())
                .username(req.getHeader(USERNAME))
                .location(req.getHeader("User-Agent"))
                .build();

        metadataRepository.save(userMetadata);

        chain.doFilter(request, response);

    }
}

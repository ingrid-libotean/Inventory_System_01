package com.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Prefixul pentru mesajele care pleacă de la server spre client
        config.enableSimpleBroker("/topic");
        // Prefixul pentru mesajele care vin de la client spre server
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Punctul de conectare (socket-ul)
        registry.addEndpoint("/ws-inventory").setAllowedOriginPatterns("*").withSockJS();
    }
}
package com.hiroshi.spring_api.configurations;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class UserInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (accessor != null && accessor.getCommand() != null) {
            if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                String terminalId = accessor.getFirstNativeHeader("terminal-id");
                if(terminalId == null) {
                    throw new RuntimeException("Terminal ID is required");
                }
                    accessor.setUser(new StompPrincipal(terminalId));
            }
        }
        return message;
    }

    private record StompPrincipal(String name) implements Principal {

        @Override
            public String getName() {
                return name;
            }
        }
}

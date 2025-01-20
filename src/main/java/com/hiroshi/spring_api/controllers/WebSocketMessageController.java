package com.hiroshi.spring_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketMessageController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketMessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/startTransaction")
    public ResponseEntity<String> startTransaction(@RequestParam String terminalId, @RequestBody String payload) {
        System.out.println(terminalId);
        System.out.println(payload);
        // Envia a mensagem para o terminal especificado
        messagingTemplate.convertAndSend("/queue/transactions", "adsadlfkjhsdlkf");
        messagingTemplate.convertAndSendToUser(
                "terminal123",                  // Terminal ID do usuário destino
                "/queue/transactions",       // Rota onde o terminal escuta
                payload                      // Mensagem que será enviada
        );
        return ResponseEntity.ok("Transação iniciada com sucesso!");
    }
}
package com.springboot.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @Author Jaune
 * @Date 2018/8/8.
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handlerChat(Principal principal,String msg){
        if(principal.getName().equals("liuyaorong")){
            messagingTemplate.convertAndSendToUser("Siri","/queue/notifications",principal.getName()+"-send:"+msg);
        }else{
            messagingTemplate.convertAndSendToUser("liuyaorong","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }
}

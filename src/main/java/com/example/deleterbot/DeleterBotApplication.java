package com.example.deleterbot;

import com.example.deleterbot.bot.HRBot;
import com.example.deleterbot.repository.GroupRepository;
import com.example.deleterbot.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

@SpringBootApplication
public class DeleterBotApplication {
final UserRepository userRepository;
final GroupRepository groupRepository;

    public DeleterBotApplication(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public static void main(String[] args) {
        new Update(842737441, new Message(558,new User(843227327l,"OYBEK_8770", false, null, "OYBEK_8770", "uz", null, null, null),1654460854,new Chat(843227327l,"private",null,"OYBEK_8770", null, "OYBEK_8770", null,null,null,null,null,null,null,null,null,null,null,null,null,null),null,null,null,"📩Barcha Guruhlarga Reklama Jo'natish📩",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null),null,null,null,null,null,null,null,null,null,null,null,null,null);
//        HRBot hrBot = new HRBot()
        LocalDateTime time = LocalDateTime.now();
        int minute = time.getMinute();
        if (minute==12||minute==13||minute==14||minute==8){
            System.out.println("Oxshadi");
        }
        SpringApplication.run(DeleterBotApplication.class, args);
//        while (true){
//            for (int i = 0; i <= i; i++) {
//                System.out.println("Qalesan "+ i);
//            }
//        }
    }



    }

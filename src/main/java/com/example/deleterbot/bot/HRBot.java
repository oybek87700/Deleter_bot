package com.example.deleterbot.bot;

import com.example.deleterbot.entity.Groups;
import com.example.deleterbot.entity.Users;
import com.example.deleterbot.repository.GroupRepository;
import com.example.deleterbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HRBot extends TelegramLongPollingBot {

    final UserRepository userRepository;
    final GroupRepository groupRepository;

    @Override
    public String getBotUsername() {
        return "join_delete_by_Oybek_bot";
    }

    @Override
    public String getBotToken() {
        return "5310129749:AAGgj3mp1u-EgWf3YOU43_Z1QEKEh-yeee0";
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        LocalDateTime time = LocalDateTime.now();
        int minute = time.getMinute();
        if (minute==12||minute==13||minute==14||minute==8){
        sendMessage.setText("Qalesan");
        sendMessage.setChatId(String.valueOf(2070376998));
            execute(sendMessage);
        }
        System.out.println(update);
        Integer messageId = update.getMessage().getMessageId();
        String chatId1 = String.valueOf(update.getMessage().getChatId());

        String chatId = String.valueOf(update.getMessage().getChatId());
        String userName = update.getMessage().getFrom().getUserName();
        String firstName = update.getMessage().getFrom().getFirstName();
        String groupName = update.getMessage().getChat().getTitle();
        String groupId = String.valueOf(update.getMessage().getChat().getId());
        String groupUserName = update.getMessage().getChat().getUserName();
        Optional<Users> byChatId = userRepository.findByChatId(chatId);
        Optional<Groups> byGroupId = groupRepository.findByGroupId(groupId);

//        date.atTime(LocalTime.from(date));
//        if ()

if (update.getMessage().hasText()){
        if (update.getMessage().hasText() && update.getMessage().getText().equals("/start")&&update.getMessage().hasText() && update.getMessage().getText().equals("/start")&& chatId.equals("843227327") || update.getMessage().getText().equals("📩Barcha Guruhlarga Reklama Jo'natish📩")|| update.getMessage().getText().startsWith("Reklama")|| update.getMessage().getText().equals("👥Guruhlar sonini bilish👥")|| update.getMessage().getText().equals("👤A'zolar sonini bilish👤")) {
            if (chatId.equals("843227327") && !update.getMessage().getText().equals("📩Barcha Guruhlarga Reklama Jo'natish📩")&& !update.getMessage().getText().startsWith("Reklama")&& !update.getMessage().getText().startsWith("👥Guruhlar sonini bilish👥")&& !update.getMessage().getText().startsWith("👤A'zolar sonini bilish👤")) {
                sendMessage.setText("Tanlang");
                sendMessage.setChatId(chatId);
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setResizeKeyboard(true);
                List<KeyboardRow> keyboardRowList = new ArrayList<>();
                KeyboardRow keyboardRow = new KeyboardRow();
                KeyboardRow keyboardRow1 = new KeyboardRow();
                KeyboardRow keyboardRow2 = new KeyboardRow();
                KeyboardButton keyboardButton = new KeyboardButton();
                KeyboardButton keyboardButton1 = new KeyboardButton();
                KeyboardButton keyboardButton2 = new KeyboardButton();
                keyboardButton.setText("📩Barcha Guruhlarga Reklama Jo'natish📩");
                keyboardButton1.setText("👥Guruhlar sonini bilish👥");
                keyboardButton2.setText("👤A'zolar sonini bilish👤");
                keyboardRow.add(keyboardButton);
                keyboardRow1.add(keyboardButton1);
                keyboardRow2.add(keyboardButton2);
                keyboardRowList.add(keyboardRow);
                keyboardRowList.add(keyboardRow1);
                keyboardRowList.add(keyboardRow2);
                replyKeyboardMarkup.setKeyboard(keyboardRowList);
                sendMessage.setReplyMarkup(replyKeyboardMarkup);
                execute(sendMessage);
            } else if (update.getMessage().getText().equals("📩Barcha Guruhlarga Reklama Jo'natish📩")) {
                sendMessage.setText("Reklamani Tashlang");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
            }else if (update.getMessage().getText().equals("👥Guruhlar sonini bilish👥")) {
                sendMessage.setText(String.valueOf(groupRepository.getMax())+ " ta guruh mavjud");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
            }else if (update.getMessage().getText().equals("👤A'zolar sonini bilish👤")) {
                sendMessage.setText(String.valueOf(userRepository.getMax())+ " ta A'zo mavjud");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
            }else if (update.getMessage().getText().startsWith("Reklama")) {

                for (Integer i = 1; i <= groupRepository.getMax(); i++) {

                Optional<Groups> byName = groupRepository.findById(Long.valueOf(i));

                Groups groups = byName.get();
                    String substring = update.getMessage().getText().substring(8);
                    sendMessage.setText(substring);
                    sendMessage.setChatId(groups.getGroupId());
                    execute(sendMessage);

//                SendAudio sendAudio = new SendAudio();
//                sendAudio.setAudio(new InputFile(musics.getMusicCode()));
//                sendAudio.setCaption(i + "-musiqa " + musics.getTitle());
//                sendAudio.setChatId(chatId);
//                try {
//                    execute(sendAudio);
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
            }
                sendMessage.setText(update.getMessage().getText());
                sendMessage.setChatId(chatId);
                execute(sendMessage);
            } else if (byChatId.isEmpty()) {
                userRepository.save(new Users(chatId,firstName, userName));
            } else {
                sendMessage.setText("Salom Men Guruhga Kirgani Yoki Chiqgani Haqidagi Ma'lumotlarni O'chiraman \n Meni Huruhingizga Qo'shing");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
            }
        }} else if (!update.getMessage().getNewChatMembers().isEmpty() || !update.getMessage().getLeftChatMember().getIsBot()) {
            if (byGroupId.isEmpty()) {
                groupRepository.save(new Groups(groupId, groupName, groupUserName));
            }
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId1);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


    }
}
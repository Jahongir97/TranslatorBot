import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main extends TelegramLongPollingBot {
    String lang = "";


    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new Main());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public String getBotToken() {
        return "1670238505:AAE0S7XfXZ2A5EHjk-M3BPWeYGfeC6iOyWQ";
    }

    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = send(update.getMessage());
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(keyboardMarkup);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);
        keyboardMarkup.setSelective(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton engToRu = new KeyboardButton("Eng -> Rus");
        KeyboardButton ruToEng = new KeyboardButton("Rus -> Eng");
        KeyboardButton rusToTurk = new KeyboardButton("Rus -> Turk");
        KeyboardButton turkToRus = new KeyboardButton("Turk -> Rus");
        KeyboardButton turkToEn = new KeyboardButton("Turk -> Eng");
        KeyboardButton enToTurk = new KeyboardButton("Eng -> Turk");
        row1.add(engToRu);
        row1.add(ruToEng);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(rusToTurk);
        row2.add(turkToRus);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(turkToEn);
        row3.add(enToTurk);
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);

        keyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage send(Message message) {
        SendMessage sendMessage = new SendMessage();
        Long chatId = message.getChatId();
        String text = message.getText();
        sendMessage.setChatId(chatId);

        switch (text) {
            case "/start":
                sendMessage.setText("Hush kelibsiz!\nMenyudan tarjima qilish tilini tanlang.");
                break;
            case "Eng -> Rus":
                lang = "en-ru";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            case "Rus -> Eng":
                lang = "ru-en";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            case "Rus -> Turk":
                lang = "ru-tr";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            case "Turk -> Rus":
                lang = "tr-ru";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            case "Turk -> Eng":
                lang = "tr-en";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            case "Eng -> Turk":
                lang = "en-tr";
                sendMessage.setText("Iltimos biror bir so'z kiriting");
                break;
            default:
                sendMessage.setText(yandexDict(lang, text));
                break;
        }
        return sendMessage;
    }

    public String getBotUsername() {
        return "translator3lang_bot";
    }

    private static String yandexDict(String lang, String text) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = "";

        try {
            URL url = new URL("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20210423T061132Z.5aa164d850834577.79e70eb5fc1e85e5f3a9c7fe49c63b5beb33d7e5&lang=" + lang + "&text=" + text);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Response response = gson.fromJson(reader, Response.class);
            result = response.getDef().get(0).getTr().get(0).getText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}

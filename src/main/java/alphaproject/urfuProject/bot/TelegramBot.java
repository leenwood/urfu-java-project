package alphaproject.urfuProject.bot;

import alphaproject.urfuProject.Security.Role;
import alphaproject.urfuProject.Services.SessionsService.Session;
import alphaproject.urfuProject.Services.SessionsService.SessionsService;
import alphaproject.urfuProject.Services.VideoCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j

public class TelegramBot extends TelegramLongPollingBot {
    private Message requestMessage = new Message();
    private final SendMessage response = new SendMessage();
    private final VideoCardService videoCardService;

    private final SessionsService sessionsService;

    public TelegramBot(VideoCardService videoCardService) throws TelegramApiException {
        this.videoCardService = videoCardService;
        this.sessionsService = new SessionsService();
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return "gpu_serv_bot";
    }

    @Override
    public String getBotToken() {
        return "6156605664:AAEGmJ0TY-c7NTt0MGLk1iiyTqYsPKUTxXU";
    }

    @Override
    public void onUpdateReceived(Update request) {
        requestMessage = request.getMessage();
        response.setChatId(requestMessage.getChatId().toString());

        try {
            Session session = this.sessionsService.getSessionById(requestMessage.getChatId().toString());
        } catch (Throwable excaption) {
            this.sessionsService.addSession(new Session(
                    requestMessage.getChatId().toString(),
                    "N/A"
            ));
        }

        Session session = this.sessionsService.getSessionById(requestMessage.getChatId().toString());


        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);


        try {
            if (request.hasMessage() && requestMessage.hasText()) {
                log.info("Working onUpdateReceived, request text[{}]", request.getMessage().getText());
            }
            if (requestMessage.getText().equals("/start") || requestMessage.getText().equals("Назад")) {

                var keyboard = createFullKeyboard(sendMessage);


                sendMessage.setChatId(requestMessage.getChatId().toString());
                sendMessage.setText("Для начала работы выберите раздел");
            } else if (requestMessage.getText().equals("Информация о боте")) {
                var keyboard = createButtonBack(sendMessage);

                sendMessage.setChatId(requestMessage.getChatId().toString());
                sendMessage.setText("Добро пожаловать в нашего бота по подбору видеокарт! Наш бот создан с целью помочь вам выбрать наиболее подходящую видеокарту для ваших потребностей.\n" +
                        "\n" +
                        "Наши разработчики уверены в том, что каждый покупатель заслуживает наилучшего опыта покупки, и поэтому мы разработали этого бота, чтобы сделать выбор более легким и простым.\n" +
                        "\n" +
                        "Наш бот использует передовые алгоритмы, чтобы предложить вам наиболее подходящие видеокарты с учетом ваших предпочтений и желаемой ценовой категории. Вы можете задавать вопросы и получать рекомендации и советы от нашего бота.\n" +
                        "\n" +
                        "Благодаря нашему боту, выбор вашей новой видеокарты становится более легким и приятным процессом. Безопасность ваших данных всегда на нашем первом месте, поэтому мы гарантируем, что ваши данные всегда находятся в безопасности.\n" +
                        "\n" +
                        "Наш бот доступен на разных языках, что делает его еще более удобным для использования. Мы уверены, что наш бот поможет вам выбрать лучшую видеокарту и сделать каждую покупку более удачной! Добро пожаловать!\n" +
                        "```Номер вашего чата: " + requestMessage.getChatId().toString() + " " + session.getName() + "``` ");

            } else if (requestMessage.getText().equals("Топ самых актуальных")) {
                var keyboard = createButtonBack(sendMessage);
                sendMessage.setChatId(requestMessage.getChatId().toString());
                sendMessage.setText(videoCardService.getAllVideoCardsString());
            } else if (requestMessage.getText().equals("Удалить переписку")) {
                var keyboard = createButtonBack(sendMessage);
                sendMessage.setChatId(requestMessage.getChatId().toString());
                sendMessage.setText("Скоро добавим такую функцию");
            } else if (requestMessage.getText().equals("Найти видеокарту")) {
                var keyboard = createButtonBack(sendMessage);
                sendMessage.setChatId(requestMessage.getChatId().toString());
                sendMessage.setText("Просто введите название видеокарты");
            } else
            {

            }
            execute(sendMessage);
        } catch (
                Throwable e) {
            log.warn(e.getMessage());
        }

        log.info("Working, text[{}]", requestMessage.getText());
    }

    private ReplyKeyboardMarkup createFullKeyboard(SendMessage sendMessage) {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Найти видеокарту");
        keyboardFirstRow.add("Топ самых актуальных");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("Информация о боте");
        keyboardSecondRow.add("Удалить переписку");

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанавливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }


    private ReplyKeyboardMarkup createButtonBack(SendMessage sendMessage)
    {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Назад");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }


    private void defaultMsg(SendMessage response, String msg) throws TelegramApiException {
        response.setText(msg);
        execute(response);
    }
}

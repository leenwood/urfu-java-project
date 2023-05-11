package alphaproject.urfuProject.bot;

import alphaproject.urfuProject.Services.VideoCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@Slf4j

public class TelegramBot extends TelegramLongPollingBot {
    private Message requestMessage = new Message();
    private final SendMessage response = new SendMessage();
    private final VideoCardService videoCardService;

    public TelegramBot(VideoCardService videoCardService) throws TelegramApiException {
        this.videoCardService = videoCardService;
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
            if (request.hasMessage() && requestMessage.hasText())
                log.info("Working onUpdateReceived, request text[{}]", request.getMessage().getText());

            if (requestMessage.getText().equals("/start"))
                defaultMsg(response, videoCardService.getAllVideoCardsString());
            else
                defaultMsg(response, ".) \n ");
        } catch (Throwable e) {
            log.warn(e.getMessage());
        }

        log.info("Working, text[{}]", requestMessage.getText());

    }

    private void defaultMsg(SendMessage response, String msg) throws TelegramApiException {
        response.setText(msg);
        execute(response);
    }
}

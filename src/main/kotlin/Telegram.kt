import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
final class Bot: TelegramLongPollingBot( TOKEN) {
    companion object {
        private const val TOKEN: String = "8488953991:AAHhZ9WW6x7kwm8Ylh-Pd-XCPA9V9q8akvg"
        private const val BOT_NAME: String = "Valvyn(VN)"
    }

    override fun getBotUsername() = BOT_NAME

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() and update.message.hasText()) {
            val messageText: String = update.message.text
            val chatId: String = update.message.chatId.toString()

            if (messageText == "/start"){
                sendMessage(chatId, "HIII")
            }
            if (messageText == "HDXD"){
                sendMessage(chatId, "HII!11 CreatorR")
            }
        }
    }

    private final fun sendMessage(chatId: String, text: String) {
        val message = SendMessage()
        message.chatId = chatId
        message.text = text
        try {
            execute(message)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

}
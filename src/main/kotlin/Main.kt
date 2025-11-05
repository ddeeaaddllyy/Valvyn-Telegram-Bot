import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Component
private final class Bot: TelegramLongPollingBot() {
    companion object {
        const val TOKEN: String = "8488953991:AAHhZ9WW6x7kwm8Ylh-Pd-XCPA9V9q8akvg"
        const val BOT_NAME: String = "Valvyn(VN)"
    }

    override fun getBotToken() = TOKEN
    override fun getBotUsername() = BOT_NAME

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() and update.message.hasText()) {
            val messageText: String = update.message.text
            val chatId: String = update.message.chatId.toString()

            if (messageText == "/start"){
                sendMessage(chatId, "HIII")
            }
            if (messageText == "HIII"){
                sendMessage(chatId, "HII!11I1")
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

fun main() {
    val bot = Bot()
    try {
        val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
        botsApi.registerBot(bot)
        println("Бот запущен.")
    } catch (e: TelegramApiException) {
        e.printStackTrace()
    }

}
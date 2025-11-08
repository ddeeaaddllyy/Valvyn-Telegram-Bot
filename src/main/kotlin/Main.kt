import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Entity(tableName = "difficulty_levels")
data class DifficultyLevelsDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "difficulty_name") val difficultyName: String
)

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
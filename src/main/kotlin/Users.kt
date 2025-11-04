public interface IUserRepository{
    fun getUsers(): List<User>
    fun getUserById(id: Int): User?
}

public final data class User(
    val id: Int,
    val name: String
)

class LocalUserRepository: IUserRepository {
    override fun getUsers(): List<User> {
        println("Use local data")
        return listOf(
            User(1, "Alice"),
            User(2, "Alex"),
            User(3, "Steeve")
        )
    }

    override fun getUserById(id: Int): User? {
        return getUsers().find { it.id == id }
    }
}


class RemoteUserRepository(private val apiUrl: String): IUserRepository{
    override fun getUsers(): List<User> {
        println("get net URL request ")

        return listOf(
            User(101, "API"),
            User(102, "Server")
        )
    }

    override fun getUserById(id: Int): User? {
        println("Request User")
        return if (id == 101) User(101, "API") else null
    }
}

fun printUserName(repository: IUserRepository){
    val users = repository.getUsers()
    println("list of users")
    users.forEach { users ->
        println("ID: ${users.id}\nName: ${users.name}")
    }
}
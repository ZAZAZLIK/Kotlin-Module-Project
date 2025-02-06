import java.util.Scanner

class Menu(private val title: String, private val options: List<Pair<String, () -> Unit>>) {

    private val scanner = Scanner(System.`in`)

    fun display() {
        while (true) {
            println("$title:")
            options.forEachIndexed { index, option ->
                println("$index. ${option.first}")
            }
            println("${options.size}. Выход")

            val choice = scanner.nextLine()

            if (choice.isEmpty() || !choice.all { it.isDigit() }) {
                println("Пожалуйста, вводите только цифры.")
                continue
            }

            when (val index = choice.toInt()) {
                in options.indices -> options[index].second() // Выполняем действие для выбранного пункта
                options.size -> return // Выход из меню
                else -> println("Такого пункта нет. Повторите попытку.")
            }
        }
    }
}
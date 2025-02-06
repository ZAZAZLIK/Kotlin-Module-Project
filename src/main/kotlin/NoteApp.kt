import java.util.Scanner

class NoteApp {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun start() {
        val mainMenu = Menu("Список архивов", listOf(
            Pair("Создать архив") { createArchive() },
            Pair("Показать архивы") { showArchives() }
        ))

        mainMenu.display()
    }

    private fun createArchive() {
        println("Введите имя архива:")
        val name = scanner.nextLine()
        if (name.isBlank()) {
            println("Имя архива не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    private fun showArchives() {
        if (archives.isEmpty()) {
            println("Архивов нет.")
            return
        }
        val archiveMenu = Menu("Выбор архива", archives.map { archive ->
            Pair(archive.getName()) {
                selectArchive(archive)
            }
        })
        archiveMenu.display()
    }

    private fun selectArchive(archive: Archive) {
        val noteMenu = Menu("Заметки в архиве '${archive.getName()}'", listOf(
            Pair("Создать заметку") { createNote(archive) },
            Pair("Показать заметки") { archive.displayNotes() }
        ))

        noteMenu.display()
    }

    private fun createNote(archive: Archive) {
        println("Введите заголовок заметки:")
        val title = scanner.nextLine()
        if (title.isBlank()) {
            println("Заголовок не может быть пустым.")
            return
        }

        println("Введите текст заметки:")
        val content = scanner.nextLine()
        if (content.isBlank()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        archive.addNote(Note(title, content))
        println("Заметка '$title' добавлена в архив '${archive.getName()}'.")
    }
}
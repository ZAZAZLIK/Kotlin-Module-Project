class Archive(private val archiveName: String) {
    private val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun displayNotes() {
        if (notes.isEmpty()) {
            println("Заметок нет.")
        } else {
            println("Заметки в архиве '$archiveName':")
            notes.forEachIndexed { index, note -> println("$index. ${note.title}") }
        }
    }

    fun getName(): String {
        return archiveName
    }

    // fun getNotes(): List<Note> = notes
}
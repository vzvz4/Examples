def out = new File('File1.txt')
// если файл не существует, то создаем файл
if(!out.exists()) {
    out.createNewFile()
    out << "aaa\nbbb\nccc" // пишем текст в файл
}

list = [] // создаем список для строк
out.eachLine { list<< it } // и заполняем его
println list.size() // выводим размер списка строк
println out.text // выводим весь текст
out.write('\nnew string') // пишем текст в файл
out.eachLine { println it}
out.append('\nappend string') // добавляем текст в файл

//выводим информацию о файле
println out.name
println out.isAbsolute()
println out.path
println out.parent
println out.absolutePath
println out.absoluteFile.toString()
println out.canonicalPath
println out.canonicalFile.toString()
println out.toURI().toString()

// Создаем директории
def dir= new File('Directory1')
dir.mkdir() //make directory, if it doesn't already exist
def dir2= new File('Directory2/SubDir1')
dir2.mkdirs()
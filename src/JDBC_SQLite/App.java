package JDBC_SQLite;

public class App {
    public static void main(String[] args) {
//        CREATE
//        CREATE TABLE [имя таблицы] (
//                [имя колонки] [тип данных],
//                  [имя колонки] [тип данных],
//                              ... );
//
//
//        Пример запроса:
//        CREATE TABLE IF NOT EXISTS Students
//        (
//                StudID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
//        Name TEXT NOT NULL,
//        GroupName TEXT NOT NULL,
//        Score INTEGER NOT NULL );
//
//              SELECT
//        Операция чтения данных из таблицы называется SELECT.
//                SELECT [список полей] FROM [имя таблицы] WHERE [условие];

//        Примеры запросов:
//        SELECT * FROM Students;
//        SELECT * FROM Students WHERE ID > 3
//        SELECT GroupName FROM Students WHERE ID = 2
//
//        Символ «*» означает, что мы хотим получить все поля таблицы.
//        Иначе можно через запятую перечислить необходимые поля.
//        Выражение WHERE не обязательно, но помогает извлекать только интересные для нас данные.
//
//
//          INSERT
//        Добавление новых данных:
//        INSERT INTO [имя таблицы] ([список полей через запятую]) VALUES ([список значений через запятую]);
//
//          UPDATE
//        Это операция изменения уже присутствующих в таблице данных или добавления новых.

//        Изменение:
//        UPDATE [имя таблицы] SET [имя колонки]=[новое значение], [имя колонки]=[новое значение],.. WHERE [условие];
//
//        Примеры запросов:
//        INSERT INTO Students (Name, GroupName, Score) VALUES ("Bob", "Tbz11", 80);
//        UPDATE Students SET Score = 90 WHERE Name = "Bob";
//
//           DELETE
//        Удаление данных из таблицы:
//        DELETE FROM [имя таблицы] WHERE [условие];

//        Пример запроса:
//        DELETE FROM ACCOUNTS WHERE ID='0';

        DataBaseHandler db = new DataBaseHandler("users");
        db.connect();
        db.statementExecutor(Query.SELECT,"*");
        System.out.println(db.getDbData());
        db.close();
    }
}

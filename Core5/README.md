# Практическая работа №5. Spring, работа с БД

Четвертая практическая работа по дисциплине — Разработка корпоративных информационных систем.

## Цель работы

Ознакомиться шаблоном MVC в Spring и тем, как он используется при создании web-приложений.

## Задачи

Изменить практическую работу №4 таким образом, чтобы она представляла собой web-приложение.

Web-приложение должно иметь следующие страницы:

- Главная страница содержит приветствие и ссылки на другие, которые дублируют по функционалу пункты меню из работы №4.
- Страница просмотра таблицы записей.
- Страница добавления новой записи в таблицу.
- Страница редактирования записи.
- Страница удаления записи.
- Страница просмотра записей согласно некоторому критерию (аналогично пункту из практической работы №4).

### Вариант №11

Мебель.

## Инструкция по установке и настройке PostgreSQL

### 1. Установите PostgreSQL:

Убедитесь, что на Вашем компьютере установлен [PostgreSQL](https://www.postgresql.org/download/).
Для установки PostgreSQL на Linux Ubuntu / Debian, можно воспользоваться менеджером пакетов:

```
sudo apt-get update
sudo apt-get install postgresql postgresql-contrib
```

### 2. Инициализация базы данных:

Запустите скрипт ```init.sql``` с помощью следующей команды:

```
psql -U postgres -h localhost -f init.sql
```

В этом скрипте:
- Создается таблица furniture с полями id, name, type, price, и quantity, если она не существует.
- Вставляются некоторые образцовые данные в таблицу furniture.

## Инструкция по сборке и запуску Java-проекта из командной строки

### 1. Установите JDK и Maven:

Убедитесь, что на Вашем компьютере
установлены [JDK](https://www.oracle.com/java/technologies/downloads/)
и [Maven — фреймворк для автоматизации сборки проектов](https://maven.apache.org/). Вы можете проверить это,
выполнив в командной строке следующую команду:

```
java -version
mvn -version
```

### 2. Компиляция и запуск:

Откройте терминал и перейдите в директорию вашего проекта, затем выполните следующие команды:

```
mvnw clean package
java -jar target/lab5-0.0.1-SNAPSHOT.jar
```
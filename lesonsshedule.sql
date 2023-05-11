-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 11 2023 г., 02:40
-- Версия сервера: 10.4.28-MariaDB
-- Версия PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `lesonsshedule`
--

-- --------------------------------------------------------

--
-- Структура таблицы `discipline`
--

CREATE TABLE `discipline` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `discipline`
--

INSERT INTO `discipline` (`id`, `name`) VALUES
(1, 'Математика'),
(2, 'Програмування'),
(3, 'Історія'),
(4, 'Іноземна мова');

-- --------------------------------------------------------

--
-- Структура таблицы `discipline_teachers`
--

CREATE TABLE `discipline_teachers` (
  `discipline_id` int(11) NOT NULL,
  `teachers_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `discipline_teachers`
--

INSERT INTO `discipline_teachers` (`discipline_id`, `teachers_id`) VALUES
(1, 3),
(2, 2),
(3, 1),
(4, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `schedul`
--

CREATE TABLE `schedul` (
  `id` int(11) NOT NULL,
  `time` varchar(50) DEFAULT NULL,
  `group` int(11) DEFAULT NULL,
  `discipline` varchar(50) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `schedul`
--

INSERT INTO `schedul` (`id`, `time`, `group`, `discipline`, `teacher`) VALUES
(2, '9:40', 115, 'Математика', 'Дармосюк Наталія'),
(3, '10:50', 115, 'Програмування', 'Тицька Валентина'),
(4, '11:20', 115, 'Історія', 'Петрова Інна'),
(5, '12:30', 115, 'Іноземна мова', 'Правосуд Іван');

-- --------------------------------------------------------

--
-- Структура таблицы `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `mail`, `phone`) VALUES
(1, 'Петрова Інна', 'innavix123@gmail.com', 2147483647),
(2, 'Тицька Валентина', 'valya123@gmail.com', 2147483647),
(3, 'Дармосюк Наталія', 'natasha556@gmail.com', 2147483647),
(6, 'Правосуд Іван', 'tutut@gmail.com', 684651);

-- --------------------------------------------------------

--
-- Структура таблицы `teacher_scheduls`
--

CREATE TABLE `teacher_scheduls` (
  `teacher_id` int(11) NOT NULL,
  `scheduls_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `teacher_scheduls`
--

INSERT INTO `teacher_scheduls` (`teacher_id`, `scheduls_id`) VALUES
(1, 4),
(2, 3),
(3, 2),
(6, 5);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `discipline`
--
ALTER TABLE `discipline`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `discipline_teachers`
--
ALTER TABLE `discipline_teachers`
  ADD PRIMARY KEY (`discipline_id`,`teachers_id`),
  ADD KEY `FK7w22coli4iu6jr1jg0me55fbd` (`teachers_id`);

--
-- Индексы таблицы `schedul`
--
ALTER TABLE `schedul`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `teacher_scheduls`
--
ALTER TABLE `teacher_scheduls`
  ADD PRIMARY KEY (`teacher_id`,`scheduls_id`),
  ADD KEY `FKa0r7aav7eo27l2b4prol529uk` (`scheduls_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `discipline`
--
ALTER TABLE `discipline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `schedul`
--
ALTER TABLE `schedul`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `discipline_teachers`
--
ALTER TABLE `discipline_teachers`
  ADD CONSTRAINT `FK5l5uych01qoj4jcie5ssr3plt` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  ADD CONSTRAINT `FK7w22coli4iu6jr1jg0me55fbd` FOREIGN KEY (`teachers_id`) REFERENCES `teacher` (`id`);

--
-- Ограничения внешнего ключа таблицы `teacher_scheduls`
--
ALTER TABLE `teacher_scheduls`
  ADD CONSTRAINT `FKa0r7aav7eo27l2b4prol529uk` FOREIGN KEY (`scheduls_id`) REFERENCES `schedul` (`id`),
  ADD CONSTRAINT `FKssrtayjanov90g5npbeg2h0hk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

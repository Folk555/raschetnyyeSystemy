# raschetnyyeSystemy
Поиск строк с одинаковыми символами

Метод public static Map<String, List<Integer>> getDuplicates(final String[] args)
ищет пробегается по массиву строк и ищет дубликаты. Дубликатом являются строки с 
совпадающим набором символов. Метод возвращает мапу где key это строка (вернее
набор сомволов), а value это List с индексами дубликатов в родном массиве.

Добавлены просты автотесты которые берут запрашиваемые массивы и ожидаемые мапы
из заранее подготовленных файлов. Формат файлов захардкожет, свои файлы надо 
писать по аналогии с имеющимеся.

## Задание
"Написать функцию принимающую на вход String[]
Исходный массив менять нельзя!
Требуется найти строки содержащие одинаковый набор символов и вывести на консоль в виде: набор символов(в любом порядке) = индексы строк в исходном массиве через запятую(в любом порядке).
Если у строки нет парной с ней строки с одинаковым набором символов - то печать её не надо.
Пример (форматирование может быть любое):
подаём на вход: {"qwe","wqe","qwee","a","a"};
вывод на консоль: a = 3, 4 eqw = 0, 1 набор символов QQ и Q - разный
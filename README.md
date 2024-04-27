# Домашнее задание Java Core


## Общая постановка задачи

Представим, что у нас есть завод, который занимается производством игрушек разного типа. На заводе присутствует небольшой отдел по контролю качества (QA) произведённой продукции, куда попадают все игрушки. Также на заводе присутствует отдел снабжения, где хранятся некоторые комплектующие и там же располагается кладовщик, который заведует этими комплектующими и другой полезной информацией.

## При проверке решения задачи будет требоваться:

- Соблюдение конвенций названий пакетов, классов, методов, полей, переменных и их расположения
- Оптимальная структура файлов, классов и директорий (c точки зрения логики и удобства просмотра дерева проекта)
- Отсутствие дублирования кода

## Для решения данной задачи необходимо воспользоваться:

- Возможностью Maven-а создавать отдельные модули и выстраивать зависимости между ними
- Инкапсуляцией (модификаторами private protected public)
- Отношениями композиции и наследования
- this и super (различные варианты использования этих ключевых слов)
- static полями/методами и final полями/методами и их комбинацией
- Overloading и Overriding
- Inner и Nested классами
- Varargs
- Casting-ом(up и down) и оператором instanceof
- Exception-ами, их выбрасыванием и обработкой (try-catch-finally, re-throw, multi-catch)
- abstract -классами и abstract-методами
- Интерфейсами, в том числе возможностью множественной имплементации и default-методами


## Исходные данные:

1.	_Отдел QA_ и _Отдел снабжения_ – отдельные **модули** приложения
2.	В _отделе снабжения_ можно найти следующие комплектующие: радио-модуль, чип и батарейка
3.	Батарейки в _отделе снабжения_ бывают трёх типов: AAA, AA, Crona. Дополнительно каждой батарейки указан бренд. Каталог возможных брендов находится в _отделе снабжения_ и там указаны 4 вида брендов: ENERGIZER, DURACELL, VARTA, GP
4.	Батарейка Crona умеет показывать текущее напряжение, если на неё надавить
5.	Предположим, что батарейки разных брендов лежат в одной куче, поэтому, когда кладовщик берёт батарейку какого-то конкретного типа, то её бренд определяется случайно (т.е. примерно 25% вероятность выпадения каждого бренда)
6.	Каждая игрушка имеет бирку с артикулом (неким число-буквенным кодом) – артикул свой для каждого типа игрушек, но одинаковый для каждой игрушки одного типа
7.	Наш завод производит следующие типы игрушек:
  - Мягкие игрушки – медведя и корову
  - Обычную и радиоуправляемую машинки
  - Радиоуправляемый вертолёт
  - Игрушечное оружие – водный пистолет, муляж М16, муляж АК47
8.	У всех мягких игрушек также указан тип наполнителя. Каталог возможных наполнителей находится в _отделе снабжения_ и там указаны 4 вида наполнителей: синтепух, синтепон, вата, гранулят
9.	Также все мягкие игрушки умеют издавать звук – корова мычит, а медведь рычит
10.	В качестве наполнителя для медведей всегда используется синтепон, а для коров всегда синтепух
11.	Обычная машинка умеет моргать светом – т.е. фарами, а также умеет издавать звук - клаксон
12.	В комплекте с радиоуправляемой машинкой также идут антенна и пульт дистанционного управления, не подлежащие замене
13.	Каждая антенна имеет свой уникальный и постоянный серийный номер, а также умеет моргать светом – т.е. лампочкой
14.	Также, антенна умеет отсылать свой серийный номер. При этом, во время отсылки номера:
  - В 33%(примерно) случаев может произойти непредвиденная ситуация – серийный номер будет не найден по непонятным причинам
  - В 33%(примерно) случаев может произойти другая непредвиденная ситуация – серийный номер окажется дефектным
  - В 33%(примерно) случаев отправка будет успешна
15.	Пульт дистанционного управления радиоуправляемой машинки также включает в себя такие комплектующие, как радио-модуль и батарейку, которые подлежат замене в случае неисправности
16.	Пульт дистанционного управления радиоуправляемой машинки имеет универсальный разъём под батарейку – т.е. в него можно вставить батарейку любого типа, но по умолчанию пульт комплектуется батарейкой AAA
17.	Пульт дистанционного управления радиоуправляемой машинки умеет вибрировать и умеет отправлять широкополосный запрос, а также умеет проверять антенну, идущую в комплекте с радиоуправляемой машинкой, при чём во время проверки:
  - В 50%(примерно) случаев может произойти непредвиденная ситуация – окажется дефектной батарейка (дальнейшая проверка сигнала при этом не будет происходить)
  - Если же непредвиденная ситуация не возникла и батарейка нормальная, то:
    - Происходит отправка широкополосный запроса пультом
    - Далее антенна пытается отослать свой серийный номер
    - Если во время отсылки серийного номера произошла любая непредвиденная ситуация – то происходит повторная отправка широкополосный запроса пультом и далее повторная попытка антенны отослать свой серийный номер
(третей попытки не должно происходить независимо от того, произошла ли повторно любая непредвиденная ситуация или не произошла)
  -	После проверки пульт вибрирует - независимо от её успеха
18.	Для радиоуправляемой машинки присутствует возможность проверить сигнал – для этого нужно воспользоваться возможностью пульта (т.е. его возможностью проверить антенну)
19.	Радиоуправляемая машинка умеет моргать светом – т.е. моргать фарами аналогично обычной машинке, при этом дополнительно моргает лампочкой антенны, а также умеет издавать звук – звук двигателя
20.	В комплекте с радиоуправляемым вертолётом также идёт пульт дистанционного управления, не подлежащие замене
21.	Также, радиоуправляемый вертолёт умеет двигать лопастями. При этом, во время попытки подвигать лопастями:
  - В 25%(примерно) случаев может произойти непредвиденная ситуация – лопасти будут заблокированы
  - В 25%(примерно) случаев может произойти другая непредвиденная ситуация – ротор будет заблокирован 
  - В 25%(примерно) случаев может произойти другая непредвиденная ситуация – повреждён двигатель
  - В 25%(примерно) случаев лопасти будут успешно двигаться
22.	Пульт дистанционного управления радиоуправляемого вертолёта также включает в себя такие комплектующие, как чип и батарейку, которые подлежат замене в случае неисправности
23.	Пульт дистанционного управления радиоуправляемого вертолёта имеет универсальный разъём под батарейку – т.е. в него можно вставить батарейку любого типа, но по умолчанию пульт комплектуется батарейкой AA
24.	Пульт дистанционного управления радиоуправляемого вертолёта умеет вибрировать и умеет отправлять широкополосный запрос, а также умеет проверять встроенный радио-модуль вертолёта, при чём во время проверки:
  - В 50%(примерно) случаев может произойти непредвиденная ситуация – окажется дефектной батарейка (дальнейшая проверка радио-модуля вертолёта при этом не будет происходить)
  - Если же непредвиденная ситуация не возникла и батарейка нормальная, то:
    - Происходит отправка широкополосный запроса пультом
    - Далее вертолёт пытается двигать лопастями
    - Если во время попытки двигать лопастями заблокированы лопасти или ротор – то пульт вибрирует один раз
    - Если во время попытки двигать лопастями повреждён двигатель – то пульт вибрирует три раза
    - Для каждой из непредвиденных ситуаций (заблокированы лопасти или ротор, повреждён двигатель) пульт формирует ошибку общего вида, указывая в ней дополнительную техническую информацию и произошедшую ситуацию
25.	Для радиоуправляемого вертолёта присутствует возможность проверить сигнал – для этого нужно воспользоваться возможностью пульта (т.е. его возможностью проверить радио-модуль вертолёта)
26.	АК47 и М16 умеют издавать звук – звук АК47 и звук М16 соответственно, а также АК47 и М16 умеют моргать светом - АК47 моргает красным фонариком на конце, а М16 моргает белым фонариком на конце
27.	Всё игрушечное оружие умеет игрушечно стрелять – водный пистолет стреляет, пуская струю воды, а все муляжи стреляют всегда одинаково и не могут стрелять по-другому – т.е. только издавая звук и моргая светом
28.	Кладовщик умеет менять различные старые комплектующие на новые:
  - Если ему дать радио-модуль, то он может отдать новый радио-модуль
  - Если ему дать чип, то он может отдать новый чип
  - Если ему дать батарейку любого типа, то он может вернуть новую батарейку того же типа, что ему дали
29.	Также у нас существует специалист отдела QA – которому можно принести несколько игрушек любого типа, он сообщает (в консоль) полную информацию об игрушке (т.е. её название и все имеющие свойства) и должен проверить доступные возможности каждой игрушки – т.е. возможность издать звук, моргать светом, стрелять (при этому он не должен отдельно от стрельбы проверять возможность издать звук и моргать светом) и проверить сигнал для радиоуправляемых игрушек
30.	При этом, в случае если во время проверки сигнала произошла непредвиденная ситуация:
  - Оказалась дефектной батарейка в пульте дистанционного управления радиоуправляемой машинки или пульте дистанционного управления радиоуправляемого вертолёта – то в таком случае специалист QA обращается к кладовщику и меняет батарейку на новую и откладывает игрушку (т.е. повторной проверки сигнала с этой игрушкой после замены батарейки не производит). При этом сообщает (в консоль), что батарейка была заменена и также выводит в консоль полную информацию об игрушке (т.е. её название и все имеющие свойства)
  - Произошла любая ошибка при проверке сигнала радиоуправляемого вертолёта – сообщает (в консоль) дополнительную техническую информацию и произошедшую ситуацию
  - Произошла любая ошибка при проверке сигнала радиоуправляемой машинки – сообщает (в консоль) произошедшую ситуацию

Необходимо в основном классе приложения создать по одной игрушке каждого вида (медведя, корову, обычную машинку, радиоуправляемую машинку, радиоуправляемый вертолёт, водный пистолет, муляж М16, муляж АК47) и передать их всех специалисту QA на проверку.

Для упрощения задачи – некоторые простые совершаемые действия можно выполнять в виде вывода строки в консоль, которая содержит текст этого действия

Постарайтесь добавить некое форматирование вывода в консоль для лучшей читабельности результата – т.е. делайте отступы, например, в 2 пробела, при выводе каждого действия с игрушкой

Для имитации случайности использовать **Math.random()**

Для генерации уникального серийного номера использовать **UUID.randomUUID().toString()**
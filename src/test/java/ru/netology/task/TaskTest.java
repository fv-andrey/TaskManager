package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    Task simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Task epic = new Epic(55, subtasks);

    Task meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindSimpleTaskBySearchWithWholeWord() {

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTaskBySearchWithPartOfWord() {

        boolean expected = true;
        boolean actual = simpleTask.matches("звонить");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTaskBySearchWithOneCharacter() {

        boolean expected = true;
        boolean actual = simpleTask.matches("я");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void doNotShouldFindSimpleTaskBySearchWithWordWhichIsNot() {

        boolean expected = false;
        boolean actual = simpleTask.matches("Прийти");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicBySearchWithWholeWordATBeginningOfArray() {

        boolean expected = true;
        boolean actual = epic.matches("Молоко");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicBySearchWithWholeWordATAndOfArray() {

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicBySearchWithOneCharacter() {

        boolean expected = true;
        boolean actual = epic.matches("ц");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void doNotShouldFindEpicBySearchWithWordWhichIsNot() {

        boolean expected = false;
        boolean actual = epic.matches("Булка");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTopicInMeetingBySearchWithWholeWord() {

        boolean expected = true;
        boolean actual = meeting.matches("приложения");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTopicInMeetingBySearchWithPartWord() {

        boolean expected = true;
        boolean actual = meeting.matches("катка");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTopicInMeetingBySearchWithOneCharacter() {

        boolean expected = true;
        boolean actual = meeting.matches("и");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void doNotShouldFindTopicInMeetingBySearchWithWordWhichIsNot() {

        boolean expected = false;
        boolean actual = meeting.matches("докатка");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindProjectInMeetingBySearchWithWholeWord() {

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindProjectInMeetingBySearchWithPartOfWord() {

        boolean expected = true;
        boolean actual = meeting.matches("Прилож");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindProjectInMeetingBySearchWithOneCharacter() {

        boolean expected = true;
        boolean actual = meeting.matches("к");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void doNotShouldFindProjectInMeetingBySearchWithWordWhichIsNot() {

        boolean expected = false;
        boolean actual = meeting.matches("Вкладка");


        Assertions.assertEquals(expected, actual);
    }
}

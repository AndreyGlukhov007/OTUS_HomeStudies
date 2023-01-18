import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private static Scanner scanner = new Scanner(System.in);

    // этот метод отвечает за меню с командами add/list/exit
    private static String menuCommands () {
        System.out.println("Текущая программа работает по следующим командам:");
        System.out.println("ADD - команда для создания животного");
        System.out.println("LIST - команда для просмотра всех ранее созданных животных");
        System.out.println("EXIT - для завершения работы с программой");

        String commandMenu = null;
        boolean flag = true;
        while (flag) {
            commandMenu = scanner.next();
            commandMenu = commandMenu.toUpperCase(Locale.ROOT).trim();

            if ((commandMenu.equals(CommandsData.ADD.name())) ||
                    (commandMenu.equals(CommandsData.LIST.name())) ||
                    (commandMenu.equals(CommandsData.EXIT.name()))) {
                flag = false;

            } else {
                System.out.println("Вы ввели неверную команду. Напомню, команды могут быть либо ADD, либо LIST, либо EXIT");
            }

        }
        return commandMenu;
    }

    //с помощью этого метода происходит вызов команды из enum
    private static CommandsData сomparisonCommands (String str){
        switch (str) {
            case "ADD":
                return CommandsData.ADD;
            case "LIST":
                return CommandsData.LIST;
            case "EXIT":
                return CommandsData.EXIT;
        }
        return null;
    }

    //это меню отвечает за команды cat/dog/duck
    private static String menuAnimals () {
        System.out.println("Теперь необходимо выбрать какое именно животное вы хотите создать");
        System.out.println("Для создания доступны следующие животные:");
        System.out.println("Сat - Кот");
        System.out.println("Dog - Собака");
        System.out.println("Duck - Утка");

        String commandAnimal = null;
        boolean flag = true;
        while (flag) {
            commandAnimal = scanner.next();
            commandAnimal = commandAnimal.toUpperCase(Locale.ROOT).trim();

            if ((commandAnimal.equals(AnimalTypeData.CAT.name())) ||
                    (commandAnimal.equals(AnimalTypeData.DOG.name())) ||
                    (commandAnimal.equals(AnimalTypeData.DUCK.name()))) {
                flag = false;
            } else {
                System.out.println("Вы ввели неверное животное. Напомню, можно вводить следующих животных: Cat, Dog, Duck");
            }
        }
        return commandAnimal;
    }

    private static AbsAnimal fillAnimalData (AnimalTypeData animalTypeData){
        AnimalFactory animalFactory = new AnimalFactory();

        AbsAnimal animal = animalFactory.create(animalTypeData);
        System.out.println("Как зовут животное?");
        animal.setName(scanner.next());

        System.out.println("Какой цвет у животного?");
        animal.setColor(scanner.next());

        System.out.println("Какой возраст у животного?");

        String ageStr = scanner.next();

        while (!isNumber(ageStr)) {
            System.out.println("Введен неверный возраст");
            System.out.println("Повторинет ввод");
            ageStr = scanner.next();
        }

        animal.setAge(Integer.parseInt(ageStr));

        System.out.println("Какой вес у животного?");
        String weightStr = scanner.next();
        while (!isNumber(weightStr)) {
            System.out.println("Введен неверный вес");
            System.out.println("Повторинет ввод");
            weightStr = scanner.next();
        }
        animal.setWeight(Integer.parseInt(weightStr));

        System.out.println(animal.toString());
        System.out.println();

        return animal;

    }

    private static boolean isNumber (String str){
        try {

            int x = Integer.parseInt(str);
            if (x < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException ignoring) {
            return false;
        }
    }

    public static void main(String... args) {

        System.out.println("Здравствуйте. Вы запустили программу по созданию Котиков, Собачек или Уточек.");

        ArrayList<AbsAnimal> animalsArrayList = new ArrayList<AbsAnimal>();

        for (; ; ) {
            String enterCommand = menuCommands();
            CommandsData command = сomparisonCommands(enterCommand);
            switch (command) {
                case ADD: {
                    String enterAnimal = menuAnimals();
                    AnimalTypeData animal = AnimalTypeData.valueOf(enterAnimal);
                    animalsArrayList.add(fillAnimalData(animal));
                    break;
                }
                case LIST: {
                    System.out.println("Были созданы следующие животные:");
                    for (AbsAnimal a : animalsArrayList) {
                        System.out.println(a.toString());
                    }
                    System.out.println();
                    break;
                }
                case EXIT: {
                    break;
                }
            }
        }
    }
}

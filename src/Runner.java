import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {

        //CommandsData commandsData = CommandsData.ADD;
        //commandsData.name().toLowerCase(Locale.ROOT).trim(); //����� trim() �������� �������

        System.out.println("������������. �� ��������� ��������� �� �������� �������, ������� ��� ������.");

        ArrayList <AbsAnimal> animalsArrayList = new ArrayList<AbsAnimal>();

        for ( ; ; ) {
            String enterCommand = menuCommands();
            CommandsData command = �omparisonCommands(enterCommand);

            if (command == CommandsData.ADD) {
                String enterAnimal = menuAnimals();
                AnimalTypeData animal = �omparisonAnimalss(enterAnimal);
                animalsArrayList.add(fillAnimalData(animal));

            } else if (command == CommandsData.LIST) {
                System.out.println("���� ������� ��������� ��������:");
                for(AbsAnimal a : animalsArrayList){
                    System.out.println(a.toString());
                }
                System.out.println();

            } else if (command == CommandsData.EXIT) {
                break;
            }

        }
    }

    // � ������� ����� ������ ���������� ����� ��������� �� enum
    private static AnimalTypeData �omparisonAnimalss(String str){
        switch (str){
            case "CAT":
                return AnimalTypeData.CAT;
            case  "DOG":
                return AnimalTypeData.DOG;
            case "DUCK":
                return AnimalTypeData.DUCK;
        }
        return null;
    }

    //��� ���� �������� �� ������� cat/dog/duck
    private static String menuAnimals(){
        System.out.println("������ ���������� ������� ����� ������ �������� �� ������ �������");
        System.out.println("��� �������� �������� ��������� ��������:");
        System.out.println("�at - ���");
        System.out.println("Dog - ������");
        System.out.println("Duck - ����");

        String commandAnimal = null;
        boolean flag = true;
        while (flag) {
            commandAnimal = scanner.next();
            commandAnimal = commandAnimal.toUpperCase(Locale.ROOT).trim();

            if ( (commandAnimal.equals(AnimalTypeData.CAT.name()) ) ||
                    (commandAnimal.equals(AnimalTypeData.DOG.name()) ) ||
                        (commandAnimal.equals(AnimalTypeData.DUCK.name()) )  ){
                flag = false;
            } else {
                System.out.println("�� ����� �������� ��������. �������, ����� ������� ��������� ��������: Cat, Dog, Duck");
            }
        }
        return commandAnimal;
    }

    // ���� ����� �������� �� ���� � ��������� add/list/exit
    private static String menuCommands(){
        System.out.println("������� ��������� �������� �� ��������� ��������:");
        System.out.println("ADD - ������� ��� �������� ���������");
        System.out.println("LIST - ������� ��� ��������� ���� ����� ��������� ��������");
        System.out.println("EXIT - ��� ���������� ������ � ����������");

        String commandMenu = null;
        boolean flag = true;
        while (flag){
            commandMenu = scanner.next();
            commandMenu = commandMenu.toUpperCase(Locale.ROOT).trim();

            /* || (commandMenu != CommandsData.LIST.name()) || (commandMenu != CommandsData.EXIT.name()) ) */
            if ( (commandMenu.equals(CommandsData.ADD.name()) ) ||
                    (commandMenu.equals(CommandsData.LIST.name()) ) ||
                        (commandMenu.equals(CommandsData.EXIT.name()) ) ) {
                flag = false;

            } else {
                System.out.println("�� ����� �������� �������. �������, ������� ������ ���� ���� ADD, ���� LIST, ���� EXIT");
            }

        }

        return commandMenu;

    }

    //� ������� ����� ������ ���������� ����� ������� �� enum
    private static CommandsData �omparisonCommands(String str){
        switch (str){
            case "ADD":
                return CommandsData.ADD;
            case  "LIST":
                return CommandsData.LIST;
            case "EXIT":
                return CommandsData.EXIT;
        }
        return null;
    }

    private static AbsAnimal fillAnimalData(AnimalTypeData animalTypeData) {
        AnimalFactory animalFactory = new AnimalFactory();

        AbsAnimal animal = animalFactory.create(animalTypeData);
        System.out.println("��� ����� ��������?");
        animal.setName(scanner.next());

        System.out.println("���� ���� � ���������?");
        animal.setColor(scanner.next());

        System.out.println("����� ������� � ���������?");

        String ageStr = scanner.next();

        while (!isNumber(ageStr)){
            System.out.println("������ �������� �������");
            System.out.println("���������� ����");
            ageStr = scanner.next();
        }

        animal.setAge(Integer.parseInt(ageStr));

        System.out.println("����� ��� � ���������?");
        String weightStr = scanner.next();
        while (!isNumber(weightStr)){
            System.out.println("������ �������� ���");
            System.out.println("���������� ����");
            weightStr = scanner.next();
        }
        animal.setWeight(Integer.parseInt(weightStr));

        System.out.println(animal.toString());
        System.out.println();

        return animal;

    }

    private static boolean isNumber(String str){
        try {

            int x = Integer.parseInt(str);
            if(x < 0){
                return false;
            }
            return true;
        }
         catch (NumberFormatException ignoring){
            return false;
        }
    }

}

package animals;

public abstract class AbsAnimal {

    private String name;
    private int age;
    private int weight;
    private String color;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString(){   // это метод из класса Object. Он преобразует объект в строку.
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d, мой цвет - %s", name, age, getYearStringPadej(age), weight, color);
    }

    private String getYearStringPadej(int age){
        if (age % 10 == 0 || age % 10 >= 5 || age >= 10 && age <=19){
            return "лет";
        }

        if (age % 10 == 1){
            return "год";
        }

        return "года";
    }

}

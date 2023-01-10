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
        System.out.println("ß ãîâîğş");
    }

    public void go(){
        System.out.println("ß èäó");
    }

    public void drink(){
        System.out.println("ß ïüş");
    }

    public void eat(){
        System.out.println("ß åì");
    }

    @Override
    public String toString(){   // ıòî ìåòîä èç êëàññà Object. Îí ïğåîáğàçóåò îáúåêò â ñòğîêó.
        return String.format("Ïğèâåò! ìåíÿ çîâóò %s, ìíå %d %s, ÿ âåøó - %d, ìîé öâåò - %s", name, age, getYearStringPadej(age), weight, color);
    }

    private String getYearStringPadej(int age){
        if (age % 10 == 0 || age % 10 >= 5 || age >= 10 && age <=19){
            return "ëåò";
        }

        if (age % 10 == 1){
            return "ãîä";
        }

        return "ãîäà";
    }

}

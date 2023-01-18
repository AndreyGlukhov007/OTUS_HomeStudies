package animals.pets;

import animals.AbsAnimal;
import animals.birds.IFlying;

public class Dog extends AbsAnimal {

    @Override
    public void say(){
        System.out.println("Гав");
    }

}

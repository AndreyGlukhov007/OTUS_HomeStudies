package animals.birds;

import animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying {

    @Override
    public void say(){
        System.out.println("���");
    }

    @Override
    public void fly(){
        System.out.println("� ����");
    }

}

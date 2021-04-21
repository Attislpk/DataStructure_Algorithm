package 设计模式;

public class Factory {
}

class FoodFactory {
    public static Food getFood (int n) {
        return switch (n) {
            case 1 -> new Hamberger();
            case 2 -> new Noodle();
            default -> null;
        };
    }
}

interface Food {
    void kind();
}

//增加新的产品等级
interface Drink {
    void drink();
}

class Hamberger implements Food {
    @Override
    public void kind() {
        System.out.println("我是汉堡包");
    }
}

class Noodle implements Food {
    @Override
    public void kind() {
        System.out.println("我是面条~");
    }
}

//添加新的食物
class Bread implements Food {
    @Override
    public void kind() {
        System.out.println("我是面包");
    }
}


class water implements Drink {
    @Override
    public void drink() {
        System.out.println("白开水");
    }
}

class pepsl implements Drink {
    @Override
    public void drink() {
        System.out.println("可乐来一杯");
    }
}

interface AbstractFactory {
    //对于产品等级已经固定的情况而言，还可以，但是如果需要动态添加产品等级就要违反开闭原则了
    Food getFood();
    Drink getDrink();
}

class KFC implements AbstractFactory {
    @Override
    public Food getFood() {
        return new Hamberger();
    }
    @Override
    public Drink getDrink() {
        return new pepsl();
    }
}
//增加一个新的产品簇
class Mcdoload implements AbstractFactory {
    @Override
    public Food getFood() {
        return new Bread();
    }
    @Override
    public Drink getDrink() {
        return new water();
    }
}

//工厂方法模式的特点在于，工厂也是抽象的了，并且一个工厂只能生产一个
interface FactoryMethod {
    Food getFood();
}

class HambergerFactory implements FactoryMethod{
    @Override
    public Food getFood() {
        return new Hamberger();
    }
}

class NoodleFactory implements FactoryMethod {
    @Override
    public Food getFood() {
        return new Noodle();
    }
}

//只需要添加新的对象工厂就可以了
class BreadFactory implements FactoryMethod {
    @Override
    public Food getFood() {
        return new Bread();
    }
}

class TestFactory {
    public static void main(String[] args) {
        //简单工厂模式，将创建对象的工作交给工厂去完成，只需要和工厂耦合，工厂负责和各个对象进行耦合
        FoodFactory.getFood(1).kind();
        FoodFactory.getFood(2).kind();
        FoodFactory.getFood(3); //null

        //使用工厂方法创建对象
        HambergerFactory hambergerFactory = new HambergerFactory();
        hambergerFactory.getFood().kind();
        NoodleFactory noodleFactory = new NoodleFactory();
        noodleFactory.getFood().kind();
    }
}



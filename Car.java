import java.util.Vector;

/**
 * Created by huber on 23.10.2017.
 */


public class Car {

    public static double Discount = 0.00;

    public void addEquipment(equipment e){
        Equipment.add(e);
        Discount += 0.01;
    }
    public Vector<equipment> Equipment = new Vector<equipment>();
    public double getPriceOfEquipment(){
        double price = 0;
        for(equipment i : Equipment){
            price += i.price;
        }
        if(Discount!=0){
            price *= (1-Discount);
        }
        return price;
    }
    public void showEquipment(){
        for(equipment i : Equipment){
            System.out.println(i.toString());
        }
        System.out.println("Your discount is "+Discount*100+"%");
    }

    public static void main(String[] args) {
        Car car = new Car();
        airbags Airbags = new airbags();
        radio Radio = new radio();
        Airbags.setCount(6);
        car.addEquipment(Airbags);
        car.addEquipment(Radio);
        car.showEquipment();
        System.out.println("Price of equipment: "+car.getPriceOfEquipment());
    }
}

abstract class equipment{
    public equipment(){}
    public String type = "";
    public int count = 0;
    public int price = 0;
    public String toString(){
        return "Type: "+this.type+" Count: "+this.count+" Price: "+this.price;
    }
}


class airCondition extends equipment{
    public airCondition() {
        super();
        this.type = "AirCondition";
        this.count = 1;
        this.price = 1000;
    }
}

class airbags extends equipment{
    public airbags() {
        super();
        this.type = "Airbags";
    }
    public void setCount(int count){
        this.count = count;
        setPrice();
    }

    public void setPrice(){
        if(this.count==0){
            return;
        }
        else{
            this.price = this.count*250;
        }
    }
}

class radio extends equipment{
    public radio(){
        super();
        this.type = "Radio";
        this.count = 1;
        this.price = 600;
    }
}

class navigation extends equipment{
    public navigation(){
        super();
        this.type = "Navigation";
        this.count = 1;
        this.price = 700;
    }
}
package domain;

public class HouseOwner implements RentHouse{
    @Override
    public void rentHouse(int money){
        if(money>=3000){
            System.out.println("你出了"+money+"元，我很满意，出租给你，我是房主over");
        }else{
            System.out.println("我到手不到3000块，你个没钱的垃圾，我不出租了");
        }
    }
}

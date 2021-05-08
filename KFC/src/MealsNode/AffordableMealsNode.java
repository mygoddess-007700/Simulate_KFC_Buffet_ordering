package MealsNode;

public class AffordableMealsNode //套餐结点类
{
    public String meal;
    public int price;
    public String spiciness;
    public AffordableMealsNode pNode;
    public int num;
    public int term; //0表示在期限内，1表示过期

    public AffordableMealsNode(String meal, int price, String spiciness)
    {
        this.meal = meal;
        this.price = price;
        this.spiciness = spiciness;
        pNode = null;
        num = 0;
        term = 0;
    }
}

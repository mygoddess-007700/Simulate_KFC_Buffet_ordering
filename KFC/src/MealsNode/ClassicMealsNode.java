package MealsNode;

public class ClassicMealsNode //套餐结点类
{
    public String name;
    public String []Meals;
    public String remark;
    public String spiciness;
    public int price;
    public int num;
    public int term; //0表示在期限内，1表示过期
    public ClassicMealsNode pNode;

    public ClassicMealsNode(String name, String []Meals, String remark, int price, String spiciness)
    {
        this.name = name;
        this.Meals = Meals;
        this.remark = remark;
        this.price = price;
        this.spiciness = spiciness;
        num = 0;
        term = 0;
        pNode = null;
    }
}

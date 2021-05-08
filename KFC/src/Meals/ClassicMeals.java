package Meals;

import MealsNode.ClassicMealsNode;
import java.util.Scanner;

public class ClassicMeals //套餐类
{
    public static ClassicMealsNode Meals;
    public static int mealsLen = 0;

    public static void InitClassicMeals() //初始化套餐函数
    {
        mealsLen++;
        Meals = new ClassicMealsNode(null, null, null, 0, null);
        ClassicMealsNode pTail = Meals;
        AffordableMeals tempA = new AffordableMeals();
        String[] meals1 = new String[]{tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 4),
                         tempA.showMeal(AffordableMeals.staple, AffordableMeals.stapleLen, 3),
                         tempA.showMeal(AffordableMeals.staple, AffordableMeals.stapleLen, 6),
                         tempA.showMeal(AffordableMeals.drink, AffordableMeals.drinkLen, 1)};
        ClassicMealsNode pNew1 = new ClassicMealsNode("吮指堡卷套餐:", meals1, "强烈推荐！", 17, "微辣");
        pTail.pNode = pNew1;
        pTail = pNew1;

        mealsLen++;
        String[] meals2 = new String[]{tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 1),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 7),
                tempA.showMeal(AffordableMeals.staple, AffordableMeals.stapleLen, 7),
                tempA.showMeal(AffordableMeals.drink, AffordableMeals.drinkLen, 2)};
        ClassicMealsNode pNew2 = new ClassicMealsNode("剁手四件套:", meals2, "剁手必备！", 22, "微辣");
        pTail.pNode = pNew2;
        pTail = pNew2;

        mealsLen++;
        String[] meals3 = new String[]{tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 1),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 2),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 3),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 4),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 5),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 6),
                tempA.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, 7),};
        ClassicMealsNode pNew3 = new ClassicMealsNode("大吃盒:", meals3, "熬夜神器！", 30, "麻辣");
        pTail.pNode = pNew3;
    }

    public static void classicMealsShow(int judge) //套餐展示
    {
        System.out.printf("本店目前的经典套餐共有%d种，它们分别是：\n", mealsLen);
        for(int i = 0; i < mealsLen; ++i)
        {
            ClassicMealsNode p = Meals.pNode;
            for(int j = 0; j < i; ++j)
            {
                p = p.pNode;
            }
            System.out.printf("%d.%s\n", i+1, p.name);
            for(int j = 0; j < p.Meals.length; ++j)
            {
                System.out.printf("%s\n", p.Meals[j]);
            }
            System.out.printf("%s 共计%d元 %s\n", p.remark, p.price, p.spiciness);
        }
        if(0 == judge)
        {
            System.out.printf("如需返回菜单，请输入esc，你可以继续使用其他功能\n");
            Scanner input = new Scanner(System.in);
            while(true)
            {
                if(input.nextLine().equals("esc"))
                {
                    break;
                }
                else
                {
                    System.out.printf("您的输入不符合格式，请重新输入：\n");
                }
            }
        }
    }

    public static int showMealsPrice(int pos) //展示套餐价格
    {
        ClassicMealsNode p = Meals;
        for(int i = 0; i < pos; ++i)
        {
            p = p.pNode;
        }
        return p.price;
    }

    public static void addMeals() //添加套餐
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("请输入你要添加的套餐的名字：\n");
        String pName = input.nextLine();
        System.out.printf("请依次输入该套餐里面包含的小吃数量、主食数量、饮品数量！\n");
        int num[] = new int[3];
        for(int i = 0; i < 3; ++i)
        {
            num[i] = input.nextInt();
        }
        String pMeals[] = new String[num[0]+num[1]+num[2]];

        AffordableMeals a = new AffordableMeals();
        AffordableMeals.showAffordableMeals(1);
        System.out.printf("请依次输入%d个你要输入的小吃序号\n", num[0]);
        int snackOrder[] = new int[num[0]];
        for(int i = 0; i < num[0]; ++i)
        {
            snackOrder[i] = input.nextInt();
            pMeals[i] = a.showMeal(AffordableMeals.snack, AffordableMeals.snackLen, snackOrder[i]);
        }
        System.out.printf("请依次输入%d个你要输入的主食序号\n", num[1]);
        int stapleOrder[] = new int[num[1]];
        for(int i = 0; i < num[1]; ++i)
        {
            stapleOrder[i] = input.nextInt();
            pMeals[num[0]+i] = a.showMeal(AffordableMeals.staple, AffordableMeals.stapleLen, stapleOrder[i]);
        }
        System.out.printf("请依次输入%d个你要输入的饮品序号\n", num[2]);
        int drinkOrder[] = new int[num[2]];
        for(int i = 0; i < num[2]; ++i)
        {
            drinkOrder[i] = input.nextInt();
            pMeals[num[0]+num[1]+i] = a.showMeal(AffordableMeals.drink, AffordableMeals.drinkLen, drinkOrder[i]);
        }

        System.out.printf("请输入该套餐的备注\n");
        input.nextLine(); //原因nextLine方法不能放在nextInt后面，因为\n， 所以要加这行
        String pRemark = input.nextLine();
        System.out.printf("请输入这个套餐的价格\n");
        int pPrice = input.nextInt();
        System.out.printf("请输入这个套餐的口味\n");
        input.nextLine();
        String pSpi = input.nextLine();
        ClassicMealsNode pNew = new ClassicMealsNode(pName, pMeals, pRemark, pPrice, pSpi);
        ClassicMealsNode p = Meals;
        for(int i = 0; i < mealsLen; ++i)
        {
            p = p.pNode;
        }
        p.pNode = pNew;
        mealsLen++;
    }

    public static void deleteClassicMeals() //删除套餐
    {
        System.out.printf("请输入你要删除的套餐序号\n");
        Scanner input = new Scanner(System.in);
        int pos = input.nextInt();
        ClassicMealsNode p = Meals;
        for(int i = 0; i < pos-1; ++i)
        {
            p = p.pNode;
        }
        p.pNode = p.pNode.pNode;
        mealsLen--;
    }

    public static void modifyPrice() //修改套餐价格
    {
        System.out.printf("请输入你要修改的套餐序号\n");
        Scanner input = new Scanner(System.in);
        int pos = input.nextInt();
        System.out.printf("请输入修改后的价格\n");
        int nPrice = input.nextInt();
        ClassicMealsNode p = Meals;
        for(int i = 0; i < pos; ++i)
        {
            p = p.pNode;
        }
        p.price = nPrice;
    }

    public static void numAdd(int order) //本周套餐售卖数量加一
    {
        ClassicMealsNode p = Meals;
        for(int i = 0; i < order; ++i)
        {
            p = p.pNode;
        }
        p.num++;
    }
}

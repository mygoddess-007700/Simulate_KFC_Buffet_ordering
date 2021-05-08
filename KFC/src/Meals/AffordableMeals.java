package Meals;

import java.util.Scanner;
import MealsNode.AffordableMealsNode;

public class AffordableMeals //餐点类
{
    public static AffordableMealsNode snack = null; //小吃链表头结点
    public static int snackLen = 0; //小吃链表结点个数

    public static AffordableMealsNode staple = null; //主食链表头结点
    public static int stapleLen = 0; //主食链表结点个数

    public static AffordableMealsNode drink = null; //饮品链表头结点
    public static int drinkLen = 0; //饮品链表结点个数

    public static void initAffordableMeals() //初始化餐点类，即初始化各数据域
    {
        snack = new AffordableMealsNode("null", 0, null);
        AffordableMealsNode pTailSnack = snack;
        String []temSnack = new String[]{"薯条", "奶香蛋挞", "脆皮香蕉", "香辣翅根", "上校鸡块", "吮指大鸡排", "劲爆鸡米花"};
        int []temSnackPrice = new int[]{4, 3, 2, 5, 5, 8, 6};
        String []temSnackSpi = new String[]{"不辣", "不辣", "不辣", "麻辣", "不辣", "微辣", "微辣"};
        snackLen = 7; //必须放在括号外，否则不能定义多个初始对象
        for(int i = 0; i < 7; ++i)
        {
            AffordableMealsNode pNew = new AffordableMealsNode(temSnack[i], temSnackPrice[i], temSnackSpi[i]);
            pTailSnack.pNode = pNew;
            pTailSnack = pNew;
        }

        staple = new AffordableMealsNode("null", 0, null);
        AffordableMealsNode pTailStaple = staple;
        String []temStaple = new String[]{"迷你全鸡", "e蜜汁鸡", "香辣鸡腿堡", "深海鳕鱼堡", "原味板烧鸡腿堡", "老北京鸡肉卷", "不素之霸双层牛堡"};
        int []temStaplePrice = new int[]{10, 11, 6, 7, 6, 6, 14};
        String []temStapleSpi = new String[]{"微辣", "不辣", "麻辣", "不辣", "不辣", "不辣", "微辣"};
        stapleLen = 7;
        for(int i = 0; i < 7; ++i)
        {
            AffordableMealsNode pNew = new AffordableMealsNode(temStaple[i], temStaplePrice[i], temStapleSpi[i]);
            pTailStaple.pNode = pNew;
            pTailStaple = pNew;
        }

        drink = new AffordableMealsNode("null", 0, null);
        AffordableMealsNode pTailDrink = drink;
        String []temDrink = new String[]{"可乐", "雪碧", "原味奶茶", "缤纷四季春"};
        int []temDrinkPrice = new int[]{3, 3, 6, 6};
        String []temDrinkSpi = new String[]{"不辣", "不辣", "不辣", "不辣"};
        drinkLen = 4;
        for(int i = 0; i < 4; ++i)
        {
            AffordableMealsNode pNew = new AffordableMealsNode(temDrink[i], temDrinkPrice[i], temSnackSpi[i]);
            pTailDrink.pNode = pNew;
            pTailDrink = pNew;
        }
    }

    public String showMeal(AffordableMealsNode pHead, int len, int pos) //应该没用(好吧，写套餐化简) //展示餐点结点名字的函数
    {
        if(pos > 0 || pos < len)
        {
            AffordableMealsNode p = pHead;
            for(int i = 0; i < pos; ++i)
            {
                p = p.pNode;
            }
            return p.meal;
        }
        else
        {
            System.out.printf("你输入的数字不符合格式，请重新输入");
            return "error";
        }
    }

    public static int showMealPrice(AffordableMealsNode pHead, int len, int pos) //应该没用,除非写套餐把每个餐点价格写出来，不写了，懒 //展示餐点结点价格的函数
    {
        if(pos > 0 || pos < len)
        {
            AffordableMealsNode p = pHead;
            for(int i = 0; i < pos; ++i)
            {
                p = p.pNode;
            }
            return p.price;
        }
        else
        {
            System.out.printf("你输入的数字不符合格式，请重新输入");
            return -1;
        }
    }

    public static void showAffordableMeals(int judge) //0表示有返回菜单语句，1表示没有 //展示已有餐点函数
    {
        System.out.printf("本店的实惠餐点由三部分组成：\n");
        System.out.printf("一、精美小吃\n");
        AffordableMealsNode pSnack = snack.pNode;
        int tem = 0;
        while(pSnack != null)
        {
            tem++;
            System.out.printf("%d.%s %d元 %s\n", tem, pSnack.meal, pSnack.price, pSnack.spiciness);
            pSnack = pSnack.pNode;
        }
        tem = 0;

        System.out.printf("二、超值主食\n");
        AffordableMealsNode pStaple = staple.pNode;
        while(pStaple != null)
        {
            tem++;
            System.out.printf("%d.%s %d元 %s\n", tem, pStaple.meal, pStaple.price, pStaple.spiciness);
            pStaple = pStaple.pNode;
        }
        tem = 0;

        System.out.printf("三、冰霜饮品\n");
        AffordableMealsNode pDrink = drink.pNode;
        while(pDrink != null)
        {
            tem++;
            System.out.printf("%d.%s %d元 %s\n", tem, pDrink.meal, pDrink.price, pDrink.spiciness);
            pDrink = pDrink.pNode;
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

    public static void addAffordableMeals() //增加餐点函数
    {
        System.out.printf("请输入你要添加餐点的种类是小吃，主食还是饮品\n");
        String s;
        while(true)
        {
            Scanner inputSpecies = new Scanner(System.in);
            s = inputSpecies.nextLine();
            if(s.equals("小吃"))
            {
                System.out.printf("请输入你要添加的小吃的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                int len = num + snackLen;
                System.out.printf("请依次输入%d组名字、价钱与口味\n", num);
                for(int i = snackLen; i < len; ++i)
                {
                    AffordableMealsNode p = snack;
                    for(int j = 0; j < i; ++j)
                    {
                        p = p.pNode;
                    }
                    ++snackLen;
                    Scanner inputSnack = new Scanner(System.in);
                    Scanner inputSnackPrice = new Scanner(System.in);
                    Scanner inputSnackSpi = new Scanner(System.in);
                    p.pNode = new AffordableMealsNode(inputSnack.nextLine(), inputSnackPrice.nextInt(), inputSnackSpi.nextLine());
                }
                break;
            }
            else if(s.equals("主食"))
            {
                System.out.printf("请输入你要添加的主食的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                int len = stapleLen + num;
                System.out.printf("请依次输入%d组名字、价钱与口味\n", num);
                for(int i = stapleLen; i < len; ++i)
                {
                    AffordableMealsNode p = staple;
                    for(int j = 0; j < i; ++j)
                    {
                        p = p.pNode;
                    }
                    ++stapleLen;
                    Scanner inputStaple = new Scanner(System.in);
                    Scanner inputStaplePrice = new Scanner(System.in);
                    Scanner inputStapleSpi = new Scanner(System.in);
                    p.pNode = new AffordableMealsNode(inputStaple.nextLine(), inputStaplePrice.nextInt(), inputStapleSpi.nextLine());
                }
                break;
            }

            else if(s.equals("饮品"))
            {
                System.out.printf("请输入你要添加的饮品的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                int len = num + drinkLen;
                System.out.printf("请依次输入%d组名字、价钱与口味\n", num);
                for(int i = drinkLen; i < len; ++i)
                {
                    AffordableMealsNode p = drink;
                    for(int j = 0; j < i; ++j)
                    {
                        p = p.pNode;
                    }
                    ++drinkLen;
                    Scanner inputDrink = new Scanner(System.in);
                    Scanner inputDrinkPrice = new Scanner(System.in);
                    Scanner inputDrinkSpi = new Scanner(System.in);
                    p.pNode = new AffordableMealsNode(inputDrink.nextLine(), inputDrinkPrice.nextInt(), inputDrinkSpi.nextLine());
                }
                break;
            }

            else
            {
                System.out.printf("您输入的种类不符合格式，请重新输入！\n");
            }
        }
    }

    public static void deleteAffordableMeals() //删除结点函数
    {
        System.out.printf("请输入你要删除餐点的种类是小吃，主食还是饮品\n");
        while(true)
        {
            Scanner inputSpecies = new Scanner(System.in);
            String s = inputSpecies.nextLine();
            if(s.equals("小吃"))
            {
                System.out.printf("请输入删除的小吃的序号\n");
                Scanner inputOrder = new Scanner(System.in);
                int order = inputOrder.nextInt();
                AffordableMealsNode p = snack;
                for(int j = 0; j < order-1; ++j)
                {
                    p = p.pNode;
                }
                p = p.pNode.pNode;
                snackLen--;
                break;
            }
            else if(s.equals("主食"))
            {
                System.out.printf("请输入要删除的主食的序号\n");
                Scanner inputOrder = new Scanner(System.in);
                int order = inputOrder.nextInt();
                AffordableMealsNode p = staple;
                for(int j = 0; j < order-1; ++j)
                {
                    p = p.pNode;
                }
                stapleLen--;
                p = p.pNode.pNode;
                break;
            }
            else if(s.equals("饮品"))
            {
                System.out.printf("请输入要删除的饮品的序号\n");
                Scanner inputOrder = new Scanner(System.in);
                int order = inputOrder.nextInt();
                AffordableMealsNode p = drink;
                for(int j = 0; j < order-1; ++j)
                {
                    p = p.pNode;
                }
                drinkLen--;
                p = p.pNode.pNode;
                break;
            }
            else
            {
                System.out.printf("您输入的种类不符合格式，请重新输入！\n");
            }
        }
    }

    public static void modifyPrice() //改动餐点价格函数
    {
        System.out.printf("请输入你要改动价钱的餐点的种类是小吃，主食还是饮品\n");
        String s;
        while(true)
        {
            Scanner inputSpecies = new Scanner(System.in);
            s = inputSpecies.nextLine();
            if(s.equals("小吃"))
            {
                System.out.printf("请输入你要改动的小吃的价格的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                System.out.printf("请依次输入%d组序号与价钱\n", num);
                Scanner inputOrder = new Scanner(System.in);
                Scanner inputPrice = new Scanner(System.in);
                for(int i = 0; i < num; ++i)
                {
                    int order = inputOrder.nextInt();
                    int price = inputPrice.nextInt();
                    AffordableMealsNode p = snack;
                    for (int j = 0; j < order; ++j)
                    {
                        p = p.pNode;
                    }
                    p.price = price;
                }
                break;
            }
            else if(s.equals("主食"))
            {
                System.out.printf("请输入你要改动的主食的价格的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                System.out.printf("请依次输入%d组序号与价钱\n", num);
                Scanner input = new Scanner(System.in);
//                Scanner inputPrice = new Scanner(System.in);(千万记得只造一个input对象，否则会引发惨剧)
                for(int i = 0; i < num; ++i)
                {
                    int order = input.nextInt();
                    int price = input.nextInt();
                    AffordableMealsNode p = staple;
                    for (int j = 0; j < order; ++j)
                    {
                        p = p.pNode;
                    }
                    p.price = price;
                }
                break;
            }

            else if(s.equals("饮品"))
            {
                System.out.printf("请输入你要改动的饮品的价格的数量：\n");
                Scanner inputNum = new Scanner(System.in);
                int num = inputNum.nextInt();
                System.out.printf("请依次输入%d组序号与价钱\n", num);
                Scanner inputOrder = new Scanner(System.in);
                Scanner inputPrice = new Scanner(System.in);
                for(int i = 0; i < num; ++i)
                {
                    int order = inputOrder.nextInt();
                    int price = inputPrice.nextInt();
                    AffordableMealsNode p = drink;
                    for (int j = 0; j < order; ++j)
                    {
                        p = p.pNode;
                    }
                    p.price = price;
                }
                break;
            }

            else
            {
                System.out.printf("您输入的种类不符合格式，请重新输入！\n");
            }
        }
    }

    public static void addNum(AffordableMealsNode pHead, int order) //增加餐点结点本周销售数量函数
    {
        AffordableMealsNode p = pHead;
        for(int i = 0; i < order; ++i)
        {
            p = p.pNode;
        }
        p.num++;
    }
}
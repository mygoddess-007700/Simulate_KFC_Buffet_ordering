package Order;

import Meals.AffordableMeals;
import Meals.ClassicMeals;
import MembersNode.MembersNode;
import User.Member;

import java.util.Scanner;

public class Order //点餐类
{
    public static void showOrder() //点餐函数
    {
        while(true)
        {
            int customerPrice = 0;
            System.out.printf("您好，尊敬的顾客，请问您是会员吗\n");
            Scanner input = new Scanner(System.in);
            String whetherMem = input.nextLine();

            if( whetherMem.equals("是") || whetherMem.equals("不是"))
            {
                if(whetherMem.equals("不是"))
                {
                    ClassicMeals.classicMealsShow(1);
                    System.out.printf("套餐如上，请输入你要购买的套餐数\n");
                    int temClassicMealsNum = input.nextInt();
                    System.out.printf("请输入您要购买的%d个套餐的序号\n", temClassicMealsNum);
                    for(int i = 0; i < temClassicMealsNum; ++i)
                    {
                        int order = input.nextInt();
                        customerPrice = customerPrice + ClassicMeals.showMealsPrice(order);
                        ClassicMeals.numAdd(order);
                    }
                    AffordableMeals.showAffordableMeals(1);
                    System.out.printf("餐点如上，请依次输入您要购买的小吃餐点数，主食餐点数和饮品餐点数\n");
                    int temSnackNum = input.nextInt();
                    int temStapleNum = input.nextInt();
                    int temDrinkNum = input.nextInt();
                    if( temSnackNum != 0)
                    {
                        System.out.printf("请输入您要购买的%d个小吃的序号\n", temSnackNum);
                        for(int i = 0; i < temSnackNum; ++i)
                        {
                            int temOrder = input.nextInt();
                            customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.snack, AffordableMeals.snackLen, temOrder);
                            AffordableMeals.addNum(AffordableMeals.snack, temOrder);
                        }
                    }
                    if( temStapleNum != 0)
                    {
                        System.out.printf("请输入您要购买的%d个主食的序号\n", temStapleNum);
                        for(int i = 0; i < temStapleNum; ++i)
                        {
                            int temOrder = input.nextInt();
                            customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.staple, AffordableMeals.stapleLen, temOrder);
                            AffordableMeals.addNum(AffordableMeals.staple, temOrder);
                        }
                    }
                    if( temDrinkNum != 0)
                    {
                        System.out.printf("请输入您要购买的%d个饮品的序号\n", temDrinkNum);
                        for(int i = 0; i < temDrinkNum; ++i)
                        {
                            int temOrder = input.nextInt();
                            customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.drink, AffordableMeals.drinkLen, temOrder);
                            AffordableMeals.addNum(AffordableMeals.drink, temOrder);
                        }
                    }
                    System.out.printf("尊敬的顾客，您共购买了%d件套餐，%d件餐点，共计%d元，祝您用餐愉快\n", temClassicMealsNum, temSnackNum+temStapleNum+temDrinkNum, customerPrice);
                }
                else
                {
                    System.out.printf("请输入账号和密码或者输入返回\n");
                    String pNum = input.nextLine();
                    if(pNum.equals("返回"))
                    {
                        showOrder();
                    }
                    else
                    {
                        while (true)
                        {
                            String pKey = input.nextLine();
                            if(Member.whetherFindMember(pNum, pKey))
                            {
                                MembersNode pMember = Member.findMember(pNum);
                                int temPoint = 0;
                                ClassicMeals.classicMealsShow(1);
                                System.out.printf("尊敬的会员你好，套餐如上，请输入你要购买的套餐数\n");
                                int temClassicMealsNum = input.nextInt();
                                System.out.printf("请输入您要购买的%d个套餐的序号\n", temClassicMealsNum);
                                for (int i = 0; i < temClassicMealsNum; ++i)
                                {
                                    int order = input.nextInt();
                                    customerPrice = customerPrice + ClassicMeals.showMealsPrice(order);
                                    temPoint = temPoint + ClassicMeals.showMealsPrice(order);
                                    ClassicMeals.numAdd(order);
                                }
                                AffordableMeals.showAffordableMeals(1);
                                System.out.printf("餐点如上，请依次输入您要购买的小吃餐点数，主食餐点数和饮品餐点数\n");
                                int temSnackNum = input.nextInt();
                                int temStapleNum = input.nextInt();
                                int temDrinkNum = input.nextInt();
                                if (temSnackNum != 0) {
                                    System.out.printf("请输入您要购买的%d个小吃的序号\n", temSnackNum);
                                    for (int i = 0; i < temSnackNum; ++i) {
                                        int temOrder = input.nextInt();
                                        customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.snack, AffordableMeals.snackLen, temOrder);
                                        temPoint = temPoint + AffordableMeals.showMealPrice(AffordableMeals.snack, AffordableMeals.snackLen, temOrder);
                                        AffordableMeals.addNum(AffordableMeals.snack, temOrder);
                                    }
                                }
                                if (temStapleNum != 0) {
                                    System.out.printf("请输入您要购买的%d个主食的序号\n", temStapleNum);
                                    for (int i = 0; i < temStapleNum; ++i) {
                                        int temOrder = input.nextInt();
                                        customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.staple, AffordableMeals.stapleLen, temOrder);
                                        temPoint = temPoint + AffordableMeals.showMealPrice(AffordableMeals.staple, AffordableMeals.stapleLen, temOrder);
                                        AffordableMeals.addNum(AffordableMeals.staple, temOrder);
                                    }
                                }
                                if (temDrinkNum != 0) {
                                    System.out.printf("请输入您要购买的%d个饮品的序号\n", temDrinkNum);
                                    for (int i = 0; i < temDrinkNum; ++i) {
                                        int temOrder = input.nextInt();
                                        customerPrice = customerPrice + AffordableMeals.showMealPrice(AffordableMeals.drink, AffordableMeals.drinkLen, temOrder);
                                        temPoint = temPoint + AffordableMeals.showMealPrice(AffordableMeals.drink, AffordableMeals.drinkLen, temOrder);
                                        AffordableMeals.addNum(AffordableMeals.drink, temOrder);
                                    }
                                }
                                System.out.printf("尊敬的会员，您共购买了%d件套餐，%d件餐点，共计%.1f元，请问您是用现金支付还是积分支付\n", temClassicMealsNum, temSnackNum + temStapleNum + temDrinkNum, customerPrice * Member.discount);
                                input.nextLine();
                                Scanner cashOrPoint = new Scanner(System.in);
                                String s = cashOrPoint.nextLine();
                                while(true)
                                {
                                    if (s.equals("现金支付"))
                                    {
                                        System.out.printf("好的，祝您用餐愉快\n");
                                        break;
                                    }
                                    else if (s.equals("积分支付"))
                                    {
                                        assert pMember != null;
                                        if (pMember.point >= customerPrice * Member.discount)
                                        {
                                            pMember.point = pMember.point - customerPrice * Member.discount + customerPrice * Member.discount*0.1;
                                            System.out.printf("尊敬的会员，您成功用积分购买了%d件套餐，%d件餐点，共计%.1f元，共消耗积分%.1f，当前剩余积分为%.1f，祝您用餐愉快\n", temClassicMealsNum, temSnackNum + temStapleNum + temDrinkNum, customerPrice * Member.discount, customerPrice * Member.discount, pMember.point);
                                        }
                                        else
                                        {
                                            double pPrice = customerPrice * Member.discount - pMember.point;
                                            double pPoint = pMember.point;
                                            pMember.point = customerPrice * Member.discount*0.1;
                                            System.out.printf("尊敬的会员，您共购买了%d件套餐，%d件餐点，共计%.1f元，共消耗积分%.1f，现金%.1f元, 当前剩余积分为%.1f，祝您用餐愉快\n", temClassicMealsNum, temSnackNum + temStapleNum + temDrinkNum, customerPrice * Member.discount, pPoint, pPrice, pMember.point);
                                        }
                                        break;
                                    }
                                    else
                                    {
                                        System.out.printf("你输入的格式有误，请重新输入\n");
                                    }
                                }
                                break;
                            }
                            else
                            {
                                System.out.printf("您输入的账号和密码有误，请重新输入！\n");
                                pNum = input.nextLine();
                            }
                        }
                    }
                }
                break;
            }
            else
            {
                System.out.printf("您输入的格式错误，请重新输入\n");
            }
        }
        System.out.printf("如需回到主页面，请输入esc，欢迎您下次再来；如需继续点餐，请输入继续点餐\n");
        Scanner input = new Scanner(System.in);
        while(true)
        {
            String whether = input.nextLine();
            if(whether.equals("esc"))
            {
                break;
            }
            else if(whether.equals("继续点餐"))
            {
                showOrder();
                break;
            }
            else
            {
                System.out.printf("您输入的格式有误，请重新输入\n");
            }
        }
    }
}

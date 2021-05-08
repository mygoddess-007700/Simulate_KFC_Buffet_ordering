package User;

import Meals.*;
import MealsNode.*;
import Init.InitScreen;
import SendMessages.SendMessages;
import MembersNode.MembersNode;

import java.util.Scanner;

public class Manager //管理员类
{
    private static String []code; //管理员密码
    private static int codeNum; //管理员数量
    public static String[] function = {"一周总结", "菜品信息变动", "会员信息变动", "管理员信息变动", "切换到下一天", "退出KFC", "返回"}; //管理员七大功能

    public static void managerInit() //管理员初始化
    {
        code = new String[10];
        code[0] = "123456";
        codeNum = 1;
    }

    public static boolean trueCode(String pCode) //判断管理员密码是否正确
    {
        for(int i = 0; i < codeNum; ++i)
        {
            if(pCode.equals(code[i]))
            {
                return true;
            }
        }
        return false;
    }

    public static void showCode() //管理员介绍
    {
        System.out.printf("本店的管理员密码目前有%d个\n", codeNum);
        for(int i = 0; i < codeNum; ++i)
        {
            System.out.printf("%d. %s\n", i+1, code[i]);
        }
    }

    public static void showManageFunction() //管理员功能菜单
    {
        System.out.printf("尊敬的管理员，请输入你要选择的功能的序号\n");
        for(int i = 0; i < 7; ++i)
        {
            System.out.printf("%d. %s\n", i+1, function[i]);
        }
    }

    public static void chooseFunction(int order) //管理员功能菜单选择(和顾客函数类似)
    {
        switch (order)
        {
            case 1:
            {
                showReport();
                break;
            }
            case 2:
            {
                while(true)
                {
                    System.out.printf("请输入您要更改的是套餐还是餐点\n");
                    Scanner input = new Scanner(System.in);
                    String option = input.nextLine();
                    if(option.equals("套餐"))
                    {
                        changeClassicMeals();
                        break;
                    }
                    else if(option.equals("餐点"))
                    {
                        changeAffordableMeals();
                        break;
                    }
                    else
                    {
                        System.out.printf("输入格式有误，请重新输入\n");
                    }
                }
                break;
            }
            case 3:
            {
                changeMembers();
                break;
            }
            case 4:
            {
                showCode();
                changeCode();
                break;
            }
            case 5:
            {
                addDate();
                break;
            }
            case 6:
            {
                finishKFC();
                break;
            }
            default:
            {
                break;
            }
        }
    }

    public static void showReport() //KFC一周总结
    {
        int notSpicy = 0;
        int slightlySpicy = 0;
        int muchSpicy = 0;
        int totalClassicMeals = 0;
        int totalAffordableMeals = 0;

        System.out.printf("本店本周套餐的销售情况是：\n");
        for(int i = 0; i < ClassicMeals.mealsLen; ++i)
        {
            ClassicMealsNode pClassMealsNode = ClassicMeals.Meals.pNode;
            for(int j = 0; j < i; ++j)
            {
                pClassMealsNode = pClassMealsNode.pNode;
            }
            totalClassicMeals = totalClassicMeals + pClassMealsNode.num;
            switch (pClassMealsNode.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pClassMealsNode.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pClassMealsNode.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pClassMealsNode.num;
                    break;
                }
                default:
                    System.out.printf("error\n");
            }

            System.out.printf("%d. %s\n", i+1, pClassMealsNode.name);
            System.out.printf("本周共售出%d份，共计金额%d元\n", pClassMealsNode.num, pClassMealsNode.num*pClassMealsNode.price);
        }

        System.out.printf("本周的餐点销售情况是：\n");
        System.out.printf("精美小吃板块\n");
        for(int i = 0; i < AffordableMeals.snackLen; ++i)
        {
            AffordableMealsNode pSnack = AffordableMeals.snack.pNode;
            for(int j = 0; j < i; ++j)
            {
                pSnack = pSnack.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pSnack.num;
            switch (pSnack.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pSnack.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pSnack.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pSnack.num;
                    break;
                }
                default:
                    System.out.printf("error\n");
            }
            System.out.printf("%d, %s", i+1, pSnack.meal);
            System.out.printf("本周共售出%d份，共计金额%d元\n", pSnack.num, pSnack.num*pSnack.price);
        }
        System.out.printf("超值主食板块\n");
        for(int i = 0; i < AffordableMeals.stapleLen; ++i)
        {
            AffordableMealsNode pStaple = AffordableMeals.staple.pNode;
            for(int j = 0; j < i; ++j)
            {
                pStaple = pStaple.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pStaple.num;
            switch (pStaple.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pStaple.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pStaple.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pStaple.num;
                    break;
                }
                default:
                    System.out.print("error\n");
            }
            System.out.printf("%d, %s", i+1, pStaple.meal);
            System.out.printf("本周共售出%d份，共计金额%d元\n", pStaple.num, pStaple.num*pStaple.price);
        }
        System.out.printf("冰霜饮品板块\n");
        for(int i = 0; i < AffordableMeals.drinkLen; ++i)
        {
            AffordableMealsNode pDrink = AffordableMeals.drink.pNode;
            for(int j = 0; j < i; ++j)
            {
                pDrink = pDrink.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pDrink.num;
            switch (pDrink.spiciness) {
                case "不辣" -> {
                    notSpicy += pDrink.num;
                }
                case "微辣" -> {
                    slightlySpicy += pDrink.num;
                }
                case "麻辣" -> {
                    muchSpicy += pDrink.num;
                }
                default -> System.out.print("error\n");
            }
            System.out.printf("%d, %s", i+1, pDrink.meal);
            System.out.printf("本周共售出%d份，共计金额%d元\n", pDrink.num, pDrink.num*pDrink.price);
        }
        System.out.print("\n");
        System.out.printf("综上, 本店共售出套餐%d份，餐点%d份\n", totalClassicMeals, totalAffordableMeals);
        System.out.printf("本周共有%d位顾客光临，不辣食物共售出%d份，微辣食物共售出%d份，麻辣食物共售出%d份，\n", Customer.weekCustomerNum, notSpicy, slightlySpicy, muchSpicy);
        String []temSpicy = new String[3];
        int temNum = 0;
        if(notSpicy >= slightlySpicy && notSpicy >= muchSpicy)
        {
            temSpicy[temNum] = "不辣";
            temNum++;
        }
        if(slightlySpicy >= notSpicy && slightlySpicy >= muchSpicy)
        {
            temSpicy[temNum] = "微辣";
            temNum++;
        }
        if(muchSpicy >= notSpicy && muchSpicy >= slightlySpicy)
        {
            temSpicy[temNum] = "麻辣";
            temNum++;
        }

        if(temNum == 1)
            System.out.printf("由此可初步得出，客人喜欢吃%s的食物\n", temSpicy[0]);
        else if(temNum == 2)
            System.out.printf("由此可初步得出，客人喜欢吃%s和%s的食物\n", temSpicy[0], temSpicy[1]);
        else
            System.out.printf("由此可初步得出，客人三种辣度的食物都喜欢\n");
    }

    public static String weekShowMemberString() //用户版本的KFC一周总结，保存在一个由字符串数组转换成的字符串，并返回它
    {
        String [] weekShowMember = new String[200];
        int notSpicy = 0;
        int slightlySpicy = 0;
        int muchSpicy = 0;
        int totalClassicMeals = 0;
        int totalAffordableMeals = 0;

        weekShowMember[0] = "本店本周套餐的销售情况是：\n";
        int i1;
        for(i1 = 0; i1 < ClassicMeals.mealsLen; ++i1)
        {
            ClassicMealsNode pClassMealsNode = ClassicMeals.Meals.pNode;
            for(int j = 0; j < i1; ++j)
            {
                pClassMealsNode = pClassMealsNode.pNode;
            }
            totalClassicMeals = totalClassicMeals + pClassMealsNode.num;
            switch (pClassMealsNode.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pClassMealsNode.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pClassMealsNode.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pClassMealsNode.num;
                    break;
                }
                default:
                    break;
            }

            weekShowMember[1+2*i1] = i1+1 + ". " + pClassMealsNode.name + " \n";
            weekShowMember[2+2*i1] = "本周共售出" + pClassMealsNode.num + "份，共计金额" + pClassMealsNode.num*pClassMealsNode.price + "元\n";
        }

        weekShowMember[1+2*i1] = "本周的餐点销售情况是：\n";
        weekShowMember[1+2*i1+1] = "精美小吃板块\n";
        int i2;
        for(i2 = 0; i2 < AffordableMeals.snackLen; ++i2)
        {
            AffordableMealsNode pSnack = AffordableMeals.snack.pNode;
            for(int j = 0; j < i2; ++j)
            {
                pSnack = pSnack.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pSnack.num;
            switch (pSnack.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pSnack.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pSnack.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pSnack.num;
                    break;
                }
                default:
                    System.out.printf("error\n");
            }
            weekShowMember[1+2*i1+1+1+2*i2] = i2+1 + ", " + pSnack.meal + " \n";
            weekShowMember[1+2*i1+1+1+2*i2+1] = "本周共售出" + pSnack.num + "份，共计金额" + pSnack.num*pSnack.price + "元\n";
        }
        weekShowMember[1+2*i1+1+1+2*i2] = "超值主食板块\n";
        int i3;
        for(i3 = 0; i3 < AffordableMeals.stapleLen; ++i3)
        {
            AffordableMealsNode pStaple = AffordableMeals.staple.pNode;
            for(int j = 0; j < i3; ++j)
            {
                pStaple = pStaple.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pStaple.num;
            switch (pStaple.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pStaple.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pStaple.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pStaple.num;
                    break;
                }
                default:
                    System.out.printf("error\n");
            }
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3] = i3+1 + ", " + pStaple.meal + " \n";
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1] = "本周共售出" + pStaple.num + "份，共计金额" + pStaple.num*pStaple.price + "元\n";
        }
        weekShowMember[1+2*i1+1+1+2*i2+1+2*i3] = "冰霜饮品板块\n";
        int i4;
        for(i4 = 0; i4 < AffordableMeals.drinkLen; ++i4)
        {
            AffordableMealsNode pDrink = AffordableMeals.drink.pNode;
            for(int j = 0; j < i4; ++j)
            {
                pDrink = pDrink.pNode;
            }
            totalAffordableMeals = totalAffordableMeals + pDrink.num;
            switch (pDrink.spiciness)
            {
                case "不辣":
                {
                    notSpicy+=pDrink.num;
                    break;
                }
                case "微辣":
                {
                    slightlySpicy+=pDrink.num;
                    break;
                }
                case "麻辣":
                {
                    muchSpicy+=pDrink.num;
                    break;
                }
                default:
                    System.out.printf("error\n");
            }
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2] = i4+1 + ", " + pDrink.meal + " \n";
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1] = "本周共售出" + pDrink.num + "份，共计金额" + pDrink.num*pDrink.price + "元\n";
        }
        weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2] = " \n";
        weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1] = "综上, 本店共售出套餐" + totalClassicMeals + "份，餐点" + totalAffordableMeals + "份\n";
        weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1+1] = "本周共有"+Customer.weekCustomerNum+"位顾客光临，不辣食物共售出"+notSpicy +"份，微辣食物共售出"+slightlySpicy+"份，麻辣食物共售出"+muchSpicy+"份，\n";
        String []temSpicy = new String[3];
        int temNum = 0;
        if(notSpicy >= slightlySpicy && notSpicy >= muchSpicy)
        {
            temSpicy[temNum] = "不辣";
            temNum++;
        }
        if(slightlySpicy >= notSpicy && slightlySpicy >= muchSpicy)
        {
            temSpicy[temNum] = "微辣";
            temNum++;
        }
        if(muchSpicy >= notSpicy && muchSpicy >= slightlySpicy)
        {
            temSpicy[temNum] = "麻辣";
            temNum++;
        }

        if(temNum == 1)
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1+1+1] = "由此可初步得出，客人喜欢吃" + temSpicy[0] + "的食物\n";
        else if(temNum == 2)
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1+1+1] = "由此可初步得出，客人喜欢吃" + temSpicy[1] + "的食物\n";
        else
            weekShowMember[1+2*i1+1+1+2*i2+1+2*i3+1+i4*2+1+1+1] = "由此可初步得出，客人三种辣度的食物都喜欢\n";

        int j = 0;
        String temLast = "你好！我是KFC管理员\n";
        while(weekShowMember[j] != null)
        {
            temLast = temLast.concat(weekShowMember[j]);
            j++;
        }
        return temLast;
    }

    public static void addDate() //按星期增加一天
    {
        InitScreen.changeWeek();
        Customer.weekCustomerNum += Customer.customerNum;
        Customer.customerNum = 1;
        if(InitScreen.week == 1)
        {
            for(int i = 0; i < Member.memberNum; ++i)
            {
                MembersNode p = Member.member.pNode;
                for(int j = 0; j < i; ++j)
                {
                    p = p.pNode;
                }
                if(p.statue == 1)
                {
                    try
                    {
                        SendMessages.sendMail(p.number);
                    }
                    catch(Exception e)
                    {
                        System.out.printf("error");
                    }
                    System.out.printf("尊敬的%s的邮件已成功发送，请注意查收！\n", p.number);
                }
            }
        }
    }

    public static void changeCode() //更改管理员信息函数
    {
        while(true)
        {
            System.out.printf("尊敬的管理员，请问您是想增加管理员还是删除管理员还是返回\n");
            Scanner input = new Scanner(System.in);
            String temInput  = input.nextLine();
            if(temInput.equals("返回"))
            {
                showManageFunction();
                return;
            }
            else if(temInput.equals("增加管理员"))
            {
                System.out.printf("请输入新管理员的密码\n");
                String pNum = input.nextLine();
                code[codeNum] = pNum;
                codeNum++;
                return;
            }
            else if(temInput.equals("删除管理员"))
            {
                while(true)
                {
                    int temOrder = input.nextInt();
                    if(temOrder > codeNum || temOrder <= 0)
                    {
                        System.out.printf("您输入格式有误，请重新输入\n");
                    }
                    else
                    {
                        codeNum--;
                        String []temCode = new String[codeNum];
                        for(int i = 0; i < temOrder-1; ++i)
                        {
                            temCode[i] = code[i];
                        }
                        for(int i = temOrder; i < codeNum+1; ++i)
                        {
                            temCode[i-1] = code[i];
                        }
                        code = temCode;
                        return;
                    }
                }
            }

            else
            {
                System.out.printf("你输入的选项不符合格式，请重新输入\n");
            }
        }

    }

    public static void changeAffordableMeals() //更改餐点函数
    {
        while(true)
        {
            System.out.printf("请输入您需要增加餐点，删除餐点还是修改餐点价格\n");
            Scanner input = new Scanner(System.in);
            String type = input.nextLine();
            if(type.equals("增加餐点"))
            {
                AffordableMeals.showAffordableMeals(1);
                AffordableMeals.addAffordableMeals();
                break;
            }
            else if(type.equals("删除餐点"))
            {
                AffordableMeals.showAffordableMeals(1);
                AffordableMeals.deleteAffordableMeals();
                break;
            }
            else if(type.equals("修改餐点价格"))
            {
                AffordableMeals.showAffordableMeals(1);
                AffordableMeals.modifyPrice();
                break;
            }
            else
            {
                System.out.printf("您输入的功能不符合格式，请重新输入\n");
            }
        }
    }

    public static void changeClassicMeals() //更改套餐函数
    {
        while(true)
        {
            System.out.printf("请输入您需要增加套餐，删除套餐还是修改套餐价格\n");
            Scanner input = new Scanner(System.in);
            String type = input.nextLine();
            if(type.equals("增加套餐"))
            {
                ClassicMeals.classicMealsShow(1);
                ClassicMeals.addMeals();
                break;
            }
            else if(type.equals("删除餐点"))
            {
                ClassicMeals.classicMealsShow(1);
                ClassicMeals.deleteClassicMeals();
                break;
            }
            else if(type.equals("修改餐点价格"))
            {
                ClassicMeals.classicMealsShow(1);
                ClassicMeals.modifyPrice();
                break;
            }
            else
            {
                System.out.printf("您输入的功能不符合格式，请重新输入\n");
            }
        }
    }

    public static void changeMembers() //更改会员信息函数
    {
        Member.showReport();
        while(true)
        {
            System.out.printf("请输入你要选择的功能：增加会员，删除会员还是修改会员折扣\n");
            Scanner input = new Scanner(System.in);
            String type = input.nextLine();
            if(type.equals("增加会员"))
            {
                System.out.printf("请输入会员的邮箱，密码和姓名\n");
                String temEmail = input.nextLine();
                String temCode = input.nextLine();
                String temName = input.nextLine();
                Member.addMember(temEmail, temCode, temName);
                Member.showReport();
                break;
            }
            else if(type.equals("删除餐点"))
            {
                System.out.printf("请输入要删除会员的序号\n");
                int temOrder = input.nextInt();
                Member.deleteMember(temOrder);
                Member.showReport();
                break;
            }
            else if(type.equals("修改会员折扣"))
            {
                System.out.printf("请输入新的会员折扣\n");
                Member.discount = input.nextDouble();
                break;
            }
            else
            {
                System.out.printf("您输入的功能不符合格式，请重新输入\n");
            }
        }
    }

    public static void finishKFC() //退出KFC
    {
        System.out.printf("KFC已运行结束！欢迎下次使用\n");
        System.exit(0);
    }
}

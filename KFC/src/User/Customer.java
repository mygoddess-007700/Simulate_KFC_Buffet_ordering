package User;

import Meals.AffordableMeals;
import Meals.ClassicMeals;
import MembersNode.MembersNode;
import Order.Order;

import java.util.Scanner;

public class Customer //顾客类
{
    public static int customerNum = 1; //顾客数量
    public static int weekCustomerNum = 0; //本周顾客数量

    public static void addCustomer() //增加一个顾客数量
    {
        ++customerNum;
    }

    public void choose() //让顾客选择选择菜单的选项，并按照选项选择要运行的代码
    {
        Scanner input = new Scanner(System.in);
        int p;
        while(true)
        {
            p = input.nextInt();
            if(p < 1 || p > 7)
            {
                System.out.printf("您输入的数字不符合格式，请重新输入：\n");
            }
            else
            {
                break;
            }
        }
        switch(p)
        {
            case 1:
            {
                ClassicMeals.classicMealsShow(0);
                break;
            }
            case 2:
            {
                AffordableMeals.showAffordableMeals(0);
                break;
            }
            case 3:
            {
                Order.showOrder();
                break;
            }
            case 4:
            {
                System.out.printf("请依次输入您的电子邮箱或者是电话、密码和姓名\n");
                Scanner inputMem = new Scanner(System.in);
                String temNum = inputMem.nextLine();
                String temPassword = inputMem.nextLine();
                String temName = inputMem.nextLine();
                Member.addMember(temNum, temPassword, temName);
                if(!Member.whetherFindNumber(temNum))
                {
                    System.out.printf("与已有会员重复，录入失败，如需返回菜单，请输入esc，你可以继续使用其他功能\n");
                }
                else
                {
                    System.out.printf("录入成功，如需返回菜单，请输入esc，你可以继续使用其他功能\n");
                }
                input.nextLine();
                while(true)
                {
                    String temS = input.nextLine();
                    if(temS.equals("esc"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.printf("您输入的内容不符合格式，请重新输入：\n");
                    }
                }
                break;
            }
            case 5:
            {
                System.out.printf("欢迎来到会员天地，请输入您的会员号和密码\n");
                MembersNode pNum = Member.showMemberFunction(); //该函数可以判断是否为会员，如果是返回会员的用户名
                while(true)
                {
                    System.out.printf("请输入您想要使用的功能或者输入返回\n");
                    Scanner inputF = new Scanner(System.in);
                    String function = inputF.nextLine();
                    if(function.equals("返回"))
                    {
                        break;
                    }
                    if(function.equals("会员信息"))
                    {
                        Member.showMember(pNum);
                        System.out.printf("如需返回会员天地请输入返回\n");
                        while(true)
                        {
                            Scanner inputR = new Scanner(System.in);
                            String re = inputR.nextLine();
                            if(!re.equals("返回"))
                            {
                                System.out.printf("您的输入有误，请重新输入\n");
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                    else if(function.equals("修改密码"))
                    {
                        System.out.printf("请输入新密码\n");
                        Member.changeKey(pNum, inputF.nextLine());
                        System.out.printf("修改密码成功，如需返回会员天地请输入返回\n");
                        while(true)
                        {
                            Scanner inputR = new Scanner(System.in);
                            String re = inputR.nextLine();
                            if(!re.equals("返回"))
                            {
                                System.out.printf("您的输入有误，请重新输入\n");
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                    else if(function.equals("一周总结"))
                    {
                        System.out.printf("请问您是否要开启一周总结(该总结周一结束后会自动发到您的邮箱里面)\n");
                        while(true)
                        {
                            Scanner inputM = new Scanner(System.in);
                            String whe = inputM.nextLine();
                            if(whe.equals("是"))
                            {
                                pNum.statue = 1;
                                break;
                            }
                            else if(whe.equals("不是"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.printf("您的输入有误，请重新输入\n");
                            }
                        }
                        System.out.printf("如需返回会员天地请输入返回\n");
                        while(true)
                        {
                            Scanner inputR = new Scanner(System.in);
                            String re = inputR.nextLine();
                            if(!re.equals("返回"))
                            {
                                System.out.printf("您输入的格式有误，请重新输入\n");
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.printf("您的输入有误，请重新输入\n");
                    }
                }
                break;
            }
            case 6:
            {
                System.out.printf("请输入管理员密码\n");
                Scanner inputCode = new Scanner(System.in);

                while(true)
                {
                    String temCode = inputCode.nextLine();
                    if(Manager.trueCode(temCode))
                    {
                        while(true)
                        {
                            int i;
                            Manager.showManageFunction();
                            while(true)
                            {
                                i = input.nextInt();
                                if(i > 0 && i < 7)
                                {
                                    Manager.chooseFunction(i);
                                    break;
                                }
                                else
                                {
                                    if(i == 7)
                                    {
                                        break;
                                    }
                                    System.out.printf("输入数字有误，请重新输入\n");
                                }
                            }
                            if (i == 7)
                            {
                                break;
                            }
                            System.out.printf("如需返回，请输入esc\n");
                            Scanner inputC = new Scanner(System.in);
                            while(true)
                            {
                                String whether = inputC.nextLine();
                                if(whether.equals("esc"))
                                {

                                    break;
                                }
                                else
                                {
                                    System.out.printf("您输入的格式有误，请重新输入\n");
                                }
                            }
                        }
                        break;
                    }
                    else
                    {
                        System.out.printf("密码错误，请重新输入\n");
                    }
                }
                break;
            }
            case 7:
            {
                Customer.addCustomer();
            }
            default:
            {
                break;
            }
        }
    }

    public void showCustomer() //说明这是第几天第几个顾客
    {
        System.out.printf("您好，尊敬的本日第%d位顾客，请问您有什么需要？\n", customerNum);
    }
}

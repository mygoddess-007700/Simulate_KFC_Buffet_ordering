//注：nextInt();后面如果要使用nextLine();记得再加一个NextLine();
/*
这是我用Java完成的第二个较为满意的程序。它的功能是用控制台模拟一个KFC点餐窗口的运行，功能主要有：
展示套餐和餐点、注册会员、向会员邮箱发送一周总结邮件、以会员身份或顾客身份点餐、
管理员管理（包括：一周总结、改动餐品、改动会员等）。
制作这个程序用了一周左右的时间，说实话，代码写的一般，有很多重复的代码块却无法用循环实现，或许只能用函数实现。
缺点很明显：代码冗长，可读性较差，性能仍需提升等。
优点也是优点：1.用链表构造菜品，会员，顾客和管理员，使增加和删除更为便捷。
2.学会了使用idea调用其他人写的jar包。使得发邮箱得以实现。
3.了解了Java的优势，例如没有野指针。
4.实现了避免用户输入错误的情况，不过用的是循环，感觉效果不是很好，或许下次可以试试别的方法。
*/
package main;

import Init.InitScreen;
import Meals.AffordableMeals;
import Meals.ClassicMeals;
import User.Customer;
import User.Manager;
import User.Member;

public class KFC
{
    public static void main(String[] args)//这是四个静态方法类，取代构造函数使用初始化函数
    {
        AffordableMeals.initAffordableMeals(); //餐点小吃类初始化(例：最初的餐点种类与价格)
        ClassicMeals.InitClassicMeals(); //套餐类初始化(例：最初的套餐种类与价格)
        Manager.managerInit(); //管理员类初始化(例：最初的管理员密码)
        Member.initMember(); //会员类初始化(例：生成一个不含任何信息的会员头结点)

        Customer customer = new Customer(); //生成一个顾客对象，为了在下面的循环里可以调用顾客类的方法(在这里，顾客泛指顾客、会员和管理员)
        while(true) //循环使得管理员不停止程序，程序就不会停止
        {
            InitScreen.showInitScreen(); //初始化用户选择菜单
            customer.showCustomer(); //说明这是第几天第几个顾客
            customer.choose(); //让顾客选择选择菜单的选项，并按照选项选择要运行的代码
        }

            //testA //ok
//            AffordableMeals.addAffordableMeals();
//            AffordableMeals.deleteAffordableMeals();
//            AffordableMeals.modifyPrice();
//            AffordableMeals.showAffordableMeals(1);

            //testC //ok
//            ClassicMeals.addMeals();
//            ClassicMeals.deleteClassicMeals();
//            ClassicMeals.modifyPrice();
//            ClassicMeals.classicMealsShow(1);

            //testLast //ok
//             String x = Manager.weekShowMemberString();
//             System.out.printf("%s", x);
    }

}
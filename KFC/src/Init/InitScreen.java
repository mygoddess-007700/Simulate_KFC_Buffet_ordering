package Init;

import User.Customer;

public class InitScreen //初始化界面类
{
    public static int week = 0; //今天是星期几？
    public static String[] Week = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"}; //和上一个数据域搭配
    public static String[] function = {"经典套餐", "实惠餐点", "开始点餐", "注册会员", "会员天地", "管理员管理", "离开"}; //初始化界面功能

    public static void changeWeek() //加一天
    {
        ++week;
        if(week > 7)
        {
            week-=7;
        }
        if(week == 2)
        {
            Customer.weekCustomerNum = 0;
        }
    }

    public static void showInitScreen() //初始化界面函数
    {
        System.out.printf("今天是%s\n", Week[week]);
        System.out.printf("本KFC产品有以下八大功能：\n");
        for(int i = 0; i < 7; ++i)
        {
            System.out.printf("%d.%s\n",i+1, function[i]);
        }
    }
}

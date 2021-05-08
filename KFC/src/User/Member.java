package User;

import MembersNode.MembersNode;

import java.util.Scanner;

public class Member //会员类
{
    public static MembersNode member; //会员头结点
    public static int memberNum; //会员个数
    public static double discount; //会员折扣数

    public static void initMember() //初始化会员数据域
    {
        member = new MembersNode(null, null, null);
        memberNum = 0;
        discount = 0.85;
    }

    public static void addMember(String number, String password, String name) //在会员头结点存在的链表上增加一个会员
    {
        MembersNode p = member;
        while(p.pNode != null)
        {
            p = p.pNode;
        }
        p.pNode = new MembersNode(number, password, name);
        memberNum++;
    }

    public static void deleteMember(int pos) //在会员头结点存在的链表上删除一个会员
    {
        MembersNode p = member;
        for(int i = 0; i < pos-1; ++i)
        {
            p = p.pNode;
        }
        p.pNode = p.pNode.pNode;
        memberNum--;
    }

    public static void showReport() //展示会员信息函数
    {
        System.out.printf("本店的会员共有%d个\n", memberNum);
        int i = 1;
        MembersNode p = member.pNode;
        while(p != null)
        {
            System.out.printf("%d. %s\n", i, p.name);
            System.out.printf("会员号：%s\n", p.number);
            System.out.printf("密码：%s\n", p.password);
            p = p.pNode;
        }
    }

    public static boolean whetherFindNumber(String num) //判断该账号是否存在于会员中
    {
        MembersNode p = member.pNode;
        for(int i = 0; i < memberNum; ++i)
        {
            for(int j = 0; j < i; ++i)
            {
                p = p.pNode;
            }
            if(p.number.equals(num))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean whetherFindMember(String num, String key) //判断该账号和密码是否完全符合已有会员
    {
        MembersNode p = member.pNode;
        for(int i = 0; i < memberNum; ++i)
        {
            for(int j = 0; j < i; ++i)
            {
                p = p.pNode;
            }
            if(p.number.equals(num))
            {
                if(p.password.equals(key))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static MembersNode findMember(String Num) //在已确定该会员存在于链表中时，通过会员账号返回该会员结点
    {
            MembersNode p = member.pNode;
            for(int i = 0; i < memberNum; ++i)
            {
                for(int j = 0; j < i; ++i)
                {
                    p = p.pNode;
                }
                if(p.number.equals(Num))
                {
                    return p;
                }
            }
            return p;
        }

        public static void showMember(MembersNode mem) //展示单个会员信息
        {
            System.out.printf("您的用户名是：%s\n", mem.number);
            System.out.printf("您的密码是：%s\n", mem.password);
            System.out.printf("您的剩余积分是：%f\n", mem.point);
            System.out.printf("您的会员折扣是：%%%f\n", discount*100);
        }

        public static MembersNode showMemberFunction() //输出会员功能
        {
            while(true)
            {
                Scanner inputTM = new Scanner(System.in);
                String pNum = inputTM.nextLine();
                String pKey = inputTM.nextLine();
                if (whetherFindMember(pNum, pKey))
                {
                    System.out.printf("您好，尊敬的会员，会员天地共有三大功能，如下：\n");
                    System.out.printf("会员信息\n");
                    System.out.printf("修改密码\n");
                    System.out.printf("一周总结\n");
                    return findMember(pNum);
                }
                else
                {
                    System.out.printf("您输入的会员号或密码有误，请重新输入\n");
                }
            }
        }

        public static void changeKey(MembersNode mem, String key)
        {
            mem.password = key;
        } //更改会员密码
    }


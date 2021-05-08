package MembersNode;

public class MembersNode //会员结点类
{
    public String number;
    public String password;
    public String name;
    public int consume;
    public double point;
    public MembersNode pNode;
    public int statue; //0表示一周总结未开启，1表示一周总结已开启
    
    public MembersNode(String number, String password, String name)
    {
        this.number = number;
        this.password = password;
        this.name = name;
        this.pNode = null;
        this.consume = 0;
        this.point = 100;
        statue = 0;
    }
}

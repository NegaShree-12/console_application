package LoanManagementSystem.src.model;

public abstract class User {
    protected int  userId; //protected bcause only the class that inherits need this properties(Encapsulation)
    protected String name;

    public User(int userId,String name) //child class in their constructor must call super(int id,string name)
    {
        this.userId=userId;
        this.name=name;
    }

    public void getUserId()
    {
        return userId;
    }

    public void getName()
    {
        return name;
    }
}

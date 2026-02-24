package LoanManagementSystem.src.model;

public class Admin extends User {
    private String role;

    public Admin(int userId,String name,String role)
    {
        super(userId,name);
        this.role=role;
    }

    public String getRole()
    {
        return role;
    }

    public void approveLoan(Loan loan)
    {
        loan.approve();
    }

    public void rejectLoan(Loan loan)
    {
        loan.reject();
    }

    public void viewAllLoans()
    {
        //implenetied via service/repository
    }
}

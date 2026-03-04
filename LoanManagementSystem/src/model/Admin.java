package LoanManagementSystem.src.model;

public class Admin extends User {
    private String role;

    public Admin(int userId,String name,String role)
    {
        super(userId,name);
        this.role=role;
    }

    public void reviewLoan(Loan loan,Customer customer)
    {
        if(loan.getLoanStatus()!=LoanStatus.PENDING)
        {
            System.out.println("Loan is not pending for review");
            return;
        }
        if(customer.getCreditScore()>=700)
        {
            loan.approve();
            System.out.println("Loan approved");
        }
        else
        {
            loan.reject();
            System.out.println("Loan rejected");
        }
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

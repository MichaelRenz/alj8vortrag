/**
 * Created by frank.vogel on 17.06.2015.
 */
public class CreditNote {
    private int year;
    private CreditNoteStatus status;
    private double amount;

    public CreditNote() {
    }
    public CreditNote(int year, double amount, CreditNoteStatus status) {
        this.status = status;
        this.amount = amount;
        this.year = year;
    }

    public CreditNoteStatus getStatus() {
        return status;
    }

    public void setStatus(CreditNoteStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\t\n|___CreditNote{" +
                "\n\t|___year=" + year +
                "\n\t|___status=" + status +
                "\n\t|___amount=" + amount +
                '}';
    }
}

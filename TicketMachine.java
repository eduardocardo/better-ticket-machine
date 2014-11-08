/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //Modificador del precio del ticket
    private boolean discount;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
        discount = false;
    }

    /*
     * Metodo para activar el descuento del billete
     */
     public void giveDiscount()   
    {
        discount = !discount;               
    }    
    /**Metodo que devuelve el precio del billete
     * Si hay descuento devuelve el nuevo precio
     * 
     */
    public int getPrice()
    {             
      if(discount == false)
      {
           return price;
           
      }
      else
      {
           int newPrice;
           newPrice = price - (price*10/100);
           return newPrice;
           
      }                 
                      
    }
    
    
    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {                
         if (balance>=price)
        {
            
             // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;        
        }    
        else    
        {
            int amountLeftToPay;
            amountLeftToPay = (price - balance);
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                    
        }
    }
    
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    /**Devuelve el dinero que hace falta meter
     * para poder imprimir un ticket
     * 
     */
    public int getAmountLeftToPay()   
    {
        int amountLeftToPay;
        amountLeftToPay=(price-balance);
        return amountLeftToPay;
    }
    /**Metodo para vaciar de dinero la maquina
     * y devuelva la cantida de dinero en maquina
     * 
     */
    public int emptyMachine()
    {
        int amountToRefund;
        amountToRefund = total;
        total = 0 ;
        return amountToRefund;
    }  
}



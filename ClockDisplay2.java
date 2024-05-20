
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay2
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private boolean AM;
    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay2()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        updateDisplay();
        AM = true; 
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay2(int hour, int minute, boolean am)
    {
        if(hour >= 12 && am == true){
            throw new IllegalArgumentException("Si la hora es mayor igual a 12, no puede ser am");
        }
        if(hour<0 && hour>=13){
            throw new IllegalArgumentException("La hora esta fuera del rango");
        }
        if(minute<0 && minute>=60){
            throw new IllegalArgumentException("Los minutos estan fuera del rango");
        }
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
        AM = am;
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
    minutes.incrementV2();
    if(minutes.getValue2() == 0){
        hours.increment();
    }
        if(hours.getValue() == 0){
            hours.setValue(1);
    }
            if(hours.getValue() >= 12){
                AM = !AM;
    }
    updateDisplay();
    }
            
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue2(minute);
        updateDisplay();
    }

    public String getTime()
    {
        if(AM == true){
          return (displayString + " am");
        }else{
          return (displayString + " pm");  
         }  
    }

    private void updateDisplay()
    {
     displayString = hours.getDisplayValue() + ":" + 
                     minutes.getDisplayValue2();
    
    }
}

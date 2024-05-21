
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    private int value2;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 11;
        value2 = 0;
        assert repOK();
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }
    
    public int getValue2()
    {
        return value2;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "" + value;
        }
        else {
            return "" + value;
        }
    }
    
    public String getDisplayValue2()
    {
        if(value2 < 10){
            return "0" + value2;
        }
        else{
            return "" + value2;
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }
    
    public void setValue2(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value2 = replacementValue;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {
        value = (value + 1) % limit;
    }
    
    public void increment2()
    {
        value = value + 1;
        if(value>=limit){
            value = 0;
        }
    }
    
    public void incrementV2()
    {
        value2 = value2 + 1;
        if(value2>=limit){
            value2 = 0;
        }
    }
    
    public boolean repOK()
    {
    if(limit < 0){
        throw new IllegalStateException("El limite no puede ser menor a 0");
    }
    if(value >= limit){
        throw new IllegalStateException("El valor no puede ser mayor o igual al limite");
    }
    if(value2 >= limit){
        throw new IllegalStateException("El valor 2 no puede ser mayor o igual al limite");
    }
    return true;
    }
    }
    



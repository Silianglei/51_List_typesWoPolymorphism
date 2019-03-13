/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements = new int[INITIAL_CAPACITY];
        doubleElements = new double[INITIAL_CAPACITY];
        stringElements = new String[INITIAL_CAPACITY];
        typeOfElements = new int[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String representation = "[";
        for(int element = 0; element < filledElements; element++) {
            if(typeOfElements[element] == 0) {
                representation += intElements[element];
            }
            else if (typeOfElements[element] == 1) {
                representation += doubleElements[element];
            }
            else {
                representation += stringElements[element];
            }
                representation += ",";
        }
        representation += "]";
        return representation;
    }


    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
        if (filledElements == typeOfElements.length) expand();
        if (type == 0) {
            intElements[filledElements] = intValue;
            typeOfElements[filledElements++] = type;
        }
        if (type == 1) {
            doubleElements[filledElements] = doubleValue;
            typeOfElements[filledElements++] = type;
        }
        if (type == 2) {
            stringElements[filledElements] = stringValue;
            typeOfElements[filledElements++] = type;
        }
        return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        int[] newInt = new int[intElements.length * 2];
        double[] newDouble = new double[doubleElements.length * 2];
        String[] newString = new String[stringElements.length * 2];
        int[] newType = new int[typeOfElements.length * 2];
        for(int index = 0; index < filledElements; index++) {
            newInt[index] = intElements[index];
            newDouble[index] = doubleElements[index];
            newString[index] = stringElements[index];
            newType[index] = typeOfElements[index];
        }
        intElements = newInt;
        doubleElements = newDouble;
        stringElements = newString;
        typeOfElements = newType;
     }

     public Element get(int index) {
         int type = typeOfElements[index];
         Element element = new Element(type);
         return element;
     }
}

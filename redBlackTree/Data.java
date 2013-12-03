
public class Data<K extends Comparable<? super K>, E>{
   // fields
   K key;      // its key
   E element;  // element in node

   // constructor
   Data( K theKey, E theElement )
   {
      key = theKey;
      element = theElement;
   }

   @Override
   public String toString( )
   {
      return "[" + element.toString() +", key=" + key.toString() + "]";
   }
}

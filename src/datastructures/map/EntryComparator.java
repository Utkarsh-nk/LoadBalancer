package datastructures.map;

import java.util.Comparator;
import java.util.Map.Entry;

public class EntryComparator <k extends Comparable,v extends Comparable> implements Comparator<Entry<k,v>>{
		
		private boolean order;
		
		public EntryComparator(boolean order){
			this.order=order;
		}

		@Override
		public int compare(Entry<k,v> o1, Entry<k,v> o2) {
			/*Entry a1= (Entry)o1;
			Entry a2= (Entry)o2;*/
			if (order)
            {
                return ((k)o1.getValue()).compareTo(o2.getValue());
            }
            else
            {
                return ((v)o2.getValue()).compareTo(o1.getValue());

            }
		}
    

}

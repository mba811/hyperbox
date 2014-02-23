package org.altherian.hboxd.exception.store;

@SuppressWarnings("serial")
public class StoreNotOpenException extends StoreException {
   
   public StoreNotOpenException() {
      super("Store is not open");
   }

}
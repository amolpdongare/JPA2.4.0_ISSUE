demo to reproduce performace issue with openJPA 2.4.0.
It has following class  

1. com/jpa/Z_University.java -  This is a JPA class
 
2. com/jpa/Z_University_.java -  This is static metamodel class

3. com/test/InsertJPA.java  - This class is to insert 1000 records in Z_University table

4. com/test/MainTest.java -  Finally run this class. This call fires a query.getResultList()




query.getResultList() ultimately calls equlas() method from JPA class to get distinct result. I observed for 1000 records equals method is called for 498501 times. 



DistinctResultList(...) is called by query.getResultList().  I believe there is something wrong in calculating the ResultList<E> list size when we set distinct(true); 



 public DistinctResultList(ResultList<E> list, RuntimeExceptionTranslator trans)
 
  {
  
    this._del = new ArrayList();
    
    this._trans = trans;
    
    for (Iterator i$ = list.iterator(); i$.hasNext(); ) { Object e = i$.next();
    
      if (!this._del.contains(e))
      
        this._del.add(e); }
        
  }
  
  
  




  
 . 
 
 
 
 
  
  

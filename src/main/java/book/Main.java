package book;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

public class Main {

    public static void main(String[] args){
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator bookGenerator = new BookGenerator();

        for(int i = 0; i < 1000; i++)
            bookDao.persist(bookGenerator.generate());

        bookDao.findAll().stream().forEach(System.out::println);
    }
}

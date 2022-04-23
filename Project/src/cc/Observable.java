package cc;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable  {
    private List<Observer> observerList;

    public Observable() {
        this.observerList = new ArrayList<Observer>();
    }
    public void attach(Observer observer)
    {
        observerList.add(observer);
    }
    public void detach(Observer observer)
    {
        observerList.remove(observer);
    }
    public void haberVer()
    {
        for (Observer observer : observerList)
        {
            observer.update(this);
        }
    }
}

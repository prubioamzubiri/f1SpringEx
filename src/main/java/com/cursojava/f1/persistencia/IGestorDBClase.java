package com.cursojava.f1.persistencia;

import java.util.List;

public interface IGestorDBClase<T> {   

    public List<T> getElements();

    public T getElement(String id);

    public void addElement(T element);

    public void removeElement(String id);

    public void updateElement(T element);

    public void insertData();

}

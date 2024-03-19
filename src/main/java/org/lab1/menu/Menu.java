package org.lab1.menu;

import java.util.Scanner;
import org.lab1.storage.IList;

public class Menu implements IMenu{
  private IList list;

  public Menu(IList other){
    list = other;
  }

  @Override
  public void addElem() {

  }

  @Override
  public void removeElem() {

  }

  @Override
  public void getElem() {

  }

  @Override
  public void showAll() {

  }

  @Override
  public boolean startMenu() {

    System.out.println("1.Добавить элемент");
    System.out.println("2.Удалить элемент");
    System.out.println("3.Получить элемент");
    System.out.println("4.Вывести все элементы");
    System.out.println("5.Завершить");

    return false;
  }

  private int enterNumber(){
    Scanner scanner = new Scanner(System.in);
    int num = 0;
    do{
      num = scanner.nextInt();
    }while(num<1 || num>5);
    return num;
  }

}

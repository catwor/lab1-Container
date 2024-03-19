package org.lab1;

import org.lab1.menu.IMenu;
import org.lab1.menu.Menu;
import org.lab1.storage.List;

public class Main {
  public static void main(String[] args) {
    IMenu menu = new Menu(new List());

    while(menu.startMenu()){
      try {

      }catch (Exception e){
        System.out.println(e.getMessage());
      }
    }
  }
}
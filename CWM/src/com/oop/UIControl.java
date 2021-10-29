package com.oop;

public class UIControl {
    private boolean isEnable = true;

//    public UIControl(boolean isEnable) {
//        this.isEnable = isEnable;
//        System.out.println("UIControl");
//    }

    public void render (){

    }

    public void enable (){
        isEnable = true;
    }
    public void disable (){
        isEnable = false;
    }

    public boolean isEnable(){
        return isEnable;
    }


}

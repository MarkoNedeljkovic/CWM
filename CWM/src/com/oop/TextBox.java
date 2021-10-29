package com.oop;

public class TextBox extends UIControl {
    private String text = ""; // Field

//    public TextBox() {
//        super(true);
//    }


    @Override
    public void render() {
        System.out.println("Render TextBox");
    }

    public void setText(String text){

        this.text = text;
    }

    public void clear () {

        text = "";
    }

    @Override
    public String toString(){
        return text;
    }



}

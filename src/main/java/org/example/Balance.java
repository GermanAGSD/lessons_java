package org.example;

public class Balance {

    int n1;
    int n2;

    public void addRight(int n){
        this.n1 = n;
    }

    public void addLeft(int n){
        this.n2 = n;
    }

    public boolean getSituation(){
        if(this.n1 > this.n2){
            return false;
        }else if(this.n1 < this.n2){
            return false;
        }else {
            return true;
        }
    }
}

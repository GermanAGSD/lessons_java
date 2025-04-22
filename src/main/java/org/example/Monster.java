package org.example;

abstract class Monster {
    //Fix this class
    private String name;
    private int force;
    private int hp = 15;
    private boolean destroyed = false;

    protected boolean damage(int dhp){
        return true;
    }

    public void attack(){
        System.out.println("Attacking Monster");
    }

    public Monster(String name, int force) {
        this.name = name;
        this.force = force;
        System.out.println("Monster " + name + " was created");
    }

    protected int getForce(){
        return force;
    }

}
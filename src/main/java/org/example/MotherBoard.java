package org.example;

public class MotherBoard {

    USB usb = new USB(2, 3);
    static class USB {

         public static String wikilink = "https://en.wikipedia.org/wiki/USB";
         int usb2;
         int usb3;


        int getTotalPorts(){
            return usb2 + usb3;
        }

        USB(int usb2, int usb3){
            this.usb2 = usb2;
            this.usb3 = usb3;
        }
     }
}

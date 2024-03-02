package io.codeforall.bootcamp.filhosdamain;

public class Guest {

    private final String guestName;
    private int key;
    private Hotel hotel;
    private boolean isCheckedIn;

    public Guest(String guestName, Hotel hotel){ // Method contrutor recebe os argumentos de guestName do tipo String, hotel do Tipo Hotel
        this.guestName = guestName; // variavel do tipo guestName recebido como argumento é atribuido a variavel em guest
        this.hotel = hotel;// same as previous line
    }

    public int getKey() { // metodo getKey , onde vai armazenar a propriedade key do guest
        return key; // retorna key
    }

    public void setKey(int key) { //metodo setKey recebe o argumento key
        this.key = key; // atribui a variavel key local o valor de key recebido as argument
    }

    public void checkIn(){// metodo chekIn
        if (isCheckedIn) {//caso ja tenha feito o chekin
            System.out.println("You are already checked in.");
        } else {
            setKey(hotel.assignRoom()); // metodo setKey  recebe o valor que foi atribuito a variavel do tipo Hotel atraves do metodo assignRoom()
            isCheckedIn = !isCheckedIn; // muda a variavel isCheckedIn to true.
        }
    }

    public void checkOut(){ //Metodo check out
        isCheckedIn = !isCheckedIn; // change it back to too false
        hotel.dissociateRoom(getKey()); //para a variavel hotel atribuido no checkin ,
    }
}

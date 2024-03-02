package io.codeforall.bootcamp.filhosdamain;

public class Hotel {

    private int occupiedRooms;
    private String name;
    private Room[] rooms;

    // Criando novo Hotel


    public Hotel(String name, int numOfRooms) { //Recebe o nome e o numero de rooms.
        this.name = name; // Atribui a propriedade name a variavel name do hotel
        if (numOfRooms < 0) { // Erro se o numero introduzido for menor que 0
            System.out.println("The hotel can't have negative rooms."); // imprime linha
            System.exit(0); // o que faz Exit? same as Break?
        } else {
        rooms = new Room[numOfRooms]; // cria uma nova instancia do obejto Room
        }
        for (int i = 0; i < rooms.length; i++) { // após criar uma instancia do objeto room, percorre um loop (counter , inicia 0, enquanto room length, soma uma oa counter)
            rooms[i] = new Room(i); // arrays de rooms recebe um novo room por array , ( duas vezes declarado new room ?)
        }
    }


    // CheckIn method

    public int assignRoom() {

        if (occupiedRooms == rooms.length) {  // Se variavel occupiedRooms for igual ao numero de length ,rooms not available
            System.out.println("No rooms available.");
            return -1; //porque menos 1 ?
        }

        for (int i = 0; i < rooms.length; i++) { // objeto room, percorre um loop (counter , inicia 0, enquanto room length, soma uma oa counter)
            if (!rooms[i].isAvailable()) { // se o room for diferente que falso,
                rooms[i].changeStatus(); // rooms com a posicao do array executa o metodo changeStatus
                occupiedRooms++; // numero de occupied romm aumenta
                System.out.println("Your assigned room is: " + i); // imprime na tela o numero do quarto
                return rooms[i].getKey(); // quarto numero i executa metodo getKey
            }
        }
        return -1;
    }

    //checkOut

    public void dissociateRoom(int key) { // Metodo dissaciateRoom recebe o argumento chave ( atribuido anteriormente pelo assignRoom metodo.
        rooms[key].changeStatus(); // room key numero executa  no change Status e passa a ser falso.
        occupiedRooms--; // numero de quartos cupados decrease
        System.out.println("The guest did a check out."); // imprime string na tela
    }
}

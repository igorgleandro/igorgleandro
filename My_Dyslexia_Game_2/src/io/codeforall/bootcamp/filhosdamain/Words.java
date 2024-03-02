package io.codeforall.bootcamp.filhosdamain;

import java.util.Random;

public class Words {

    private String choosedWord;
    private int choosedTheme;

    public String getWord(int choosedTheme) {

        this.choosedTheme = choosedTheme;

        switch (choosedTheme) {

            case 1:
                choosedWord = (wordsAnimals.values()[(int) (Math.random() * wordsAnimals.values().length)]).toString();
                break;
            case 2:
                choosedWord = (wordsMovie.values()[(int) (Math.random() * wordsMovie.values().length)]).toString();
                break;
            case 3:
                choosedWord = (wordsIT.values()[(int) (Math.random() * wordsIT.values().length)]).toString();
                break;
        }
        return choosedWord;


        //public String shuffleWord() {
        ////return "everwhat";
        //}
    }

    public enum wordsAnimals {
        DOG,
        CAT,
        ELEPHANT,
        LION,
        TIGER,
        BEAR,
        FOX,
        WOLF,
        RABBIT,
        DEER,
        HORSE,
        COW,
        SHEEP,
        GOAT,
        PIG,
        MONKEY,
        HIPPO,
        ZEBRA,
        GIRAFFE,
        KANGAROO,
        PENGUIN,
        DOLPHIN,
        WHALE,
        SHARK,
        OCTOPUS,
        MOUSE,
        EAGLE,
        OWL,
        PARROT,
        SWAN,
        CRAB,
        LOBSTER,
        FROG,
        TOAD,
        SNAKE,
        SNAIL,
        ANT,
        BEE,
        BUTTERFLY
    }

    public enum wordsMovie {
        INCEPTION,
        TITANIC,
        AVATAR,
        MATRIX,
        GLADIATOR,
        ALIEN,
        JAWS,
        CASABLANCA,
        GREASE,
        PLATOON,
        ROCKY,
        GHOST,
        SPEED,
        TOPGUN,
        SHREK,
        GODZILLA,
        GREMLINS,
        JUMANJI,
        SCARFACE,
        TWISTER,
        PREDATOR,
        TAKEN,
        FROZEN,
        GRAVITY,
        ZOOTOPIA,
        ALADDIN,
        DUMBO,
        TARZAN,
        VERTIGO
    }


    public enum wordsIT {
        ALGORITHM,
        DATABASE,
        FIREWALL,
        ROUTER,
        SERVER,
        PROTOCOL,
        COMPILER,
        DEBUGGER,
        FRAMEWORK,
        INTERFACE,
        API,
        CACHE,
        KERNEL,
        FIRMWARE,
        BINARY,
        BYTECODE,
        IDE,
        SDK,
        CPU,
        GPU,
        RAM,
        ETHERNET,
        WIFI,
        BLUETOOTH,
        HTML,
        CSS,
        JAVASCRIPT,
        PYTHON,
        JAVA,
        RUBY,
        CSHARP,
        PHP,
        SQL,
        XML,
        JSON,
        REST,
        SOAP,
        AJAX,
        DOM,
        DNS,
        DHCP,
        TCP,
        UDP,
        IP,
        HTTP,
        HTTPS,
        FTP,
        SSH,
        SSL,
        TLS,
        ARP,
        ICMP,
        NAT,
        VPN,
        LAN,
        WAN,
        MAN,
        RAID
    }

}




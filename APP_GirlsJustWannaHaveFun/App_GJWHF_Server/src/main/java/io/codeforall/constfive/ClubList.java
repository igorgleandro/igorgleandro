package io.codeforall.constfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClubList {

    public final static Club[] CLUB_LIST ={
            new Club("Eskada", "Rua da Alegria 611", Type.NIGHTCLUB, City.PORTO, Genre.POP,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/02/b4/15/getlstd-property-photo.jpg?w=1200&h=-1&s=1","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.013041120392!2d-8.605119923804944!3d41.15606677133024!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464f726a3cccd%3A0xefd544d034697293!2sEskada%20Porto!5e0!3m2!1sen!2spt!4v1713394237430!5m2!1sen!2spt"),
            new Club("Griffon's", "R. do Conde de Vizela 95", Type.NIGHTCLUB, City.PORTO, Genre.POP, "https://cms.infoportugal.info/thumb/resize/350x/media/pois/final/128/JRN.BS.406-128527.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.4352322831387!2d-8.613624300000021!3d41.1468534!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464e2fc053e4d%3A0x3230ed319e112575!2sGriffon&#39;s!5e0!3m2!1sen!2spt!4v1713394534327!5m2!1sen!2spt"),
            new Club("Moreclub. Lda", "R. da Alegria de Paris 68", Type.NIGHTCLUB, City.PORTO, Genre.POP, "https://uploads.wikinight.eu//establishments/cover/be590bc2e758276832d5f1533180de2a189e2c575abfdf5ba7245918489e3eb7.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.4178986904203!2d-8.614257199999983!3d41.147231699999985!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464e2ee5fb469%3A0xfacb6453b4ee788b!2sMoreclub%2C%20Lda.!5e0!3m2!1sen!2spt!4v1713394607287!5m2!1sen!2spt"),
            new Club("Rendez Vous", "R. Cândido dos Reis 77", Type.NIGHTCLUB, City.PORTO, Genre.POP, "https://fastly.4sqi.net/img/general/width960/59267386_zuJpjGDQnqx0ubgFL8ZStRKhcmdIGaM7vaiW4Yi_6e8.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24035.424712061504!2d-8.65006848916016!3d41.14700930000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464e2faac59a3%3A0xe41cf74711a44582!2sRendez%20Vous%20-%20Discoteca!5e0!3m2!1sen!2spt!4v1713395707981!5m2!1sen!2sp"),

            new Club("Indústria", "Av. do Brasil 843", Type.NIGHTCLUB, City.PORTO, Genre.TECHNO, "https://media-cdn.tripadvisor.com/media/photo-s/16/45/52/92/industria-club.jpg", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3003.8649645296855!2d-8.687683546792861!3d41.15929780796484!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd246f0ca27917e9%3A0x7a8645d1cf237e8c!2sInd%C3%BAstria!5e0!3m2!1sen!2spt!4v1713395767809!5m2!1sen!2spt"),
            new Club("Tendinha dos Clérigos", "R. do Conde de Vizela 80", Type.NIGHTCLUB, City.PORTO, Genre.TECHNO, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgCa6dM1mHj7iTEUMMyHmfarm5HjhxgjKp96b1d1iGiw&s","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.431907096622!2d-8.616016928877624!3d41.14692597133131!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464e2e1f8f829%3A0xe06bf2ae678972f0!2sTendinha%20Dos%20Cl%C3%A9rigos!5e0!3m2!1sen!2spt!4v1713395845290!5m2!1sen!2spt"),

            new Club("Ferro Bar", "r. da Madeira 84", Type.BAR, City.PORTO, Genre.TECHNO, "https://lifecooler.com/files/registos/imagens/519377/415136.jpg", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.48208816693!2d-8.6110174288778!3d41.14583077133147!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd246532d1331b59%3A0x1f66ce3e4f6fa916!2sFERRO%20BAR!5e0!3m2!1sen!2spt!4v1713395917474!5m2!1sen!2spt"),

            new Club("Maus Hábitos", "R. de Passos Manuel 178 4º Piso", Type.BAR, City.PORTO, Genre.MISC, "https://img.bndlyr.com/slstbe4votfbw7yg/_assets/nvjkiagtoquina3ltlx8buxl.jpg?fit=cover&w=500","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.48208816693!2d-8.6110174288778!3d41.14583077133147!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd246532d1331b59%3A0x1f66ce3e4f6fa916!2sFERRO%20BAR!5e0!3m2!1sen!2spt!4v1713395917474!5m2!1sen!2spt"),
            new Club("PlanoB", "R. Cãndido dos Reis 30", Type.BAR, City.PORTO, Genre.MISC,"https://bordalo.observador.pt/v2/rs:fill:900/c:770:433:nowe:0:0/q:86/plain/https://s3.observador.pt/wp-content/uploads/2016/12/09010416/img_2226-3_770x433_acf_cropped.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.4491718546174!2d-8.616430328877703!3d41.146549171331344!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464e340499ca5%3A0x86de5dd42c7baf8!2sPlano%20B!5e0!3m2!1sen!2spt!4v1713396169203!5m2!1sen!2spt"),

            new Club("Barracuda Rock Club", "R. da Madeira 1866", Type.BAR, City.PORTO, Genre.ROCK,"https://welcomeporto.com/wp-content/uploads/2021/01/Barracuda2.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.472337949936!2d-8.612222328877756!3d41.1460435713314!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2465d52ddf8ea3%3A0xb56986522b741354!2sBarracuda%20Rock%20Club!5e0!3m2!1sen!2spt!4v1713398839308!5m2!1sen!2spt"),
            new Club("Hard Club", "Mercado Ferreira Borges", Type.BAR, City.PORTO, Genre.ROCK,"https://www.hardclubporto.com/imagens/galeria/fitei_59f89cb769e44.png", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.661529661211!2d-8.61746112887826!3d41.14191427133199!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd246518c50af2e1%3A0xe6b342cc547ffc85!2sHard%20Club!5e0!3m2!1sen!2spt!4v1713398889794!5m2!1sen!2spt"),
            new Club("Woodstock69 Rock Bar", "R. São Roque da Lameira 1212", Type.BAR, City.PORTO, Genre.ROCK, "https://www.spirit-of-metal.com/salle/Woodstock%2069%20Rock%20Bar%20_b8e.jpeg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3003.7974454320197!2d-8.582444746791817!3d41.16077100796419!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2464874c7188f3%3A0x61ffab2167d080b7!2sWoodstock69%20Rock%20Bar!5e0!3m2!1sen!2spt!4v1713398956545!5m2!1sen!2spt"),
            new Club("Castle Rock Pub & Hotel", "R. do Conde de Vizela 114", Type.BAR, City.PORTO, Genre.ROCK, "https://lh5.googleusercontent.com/p/AF1QipMcU087-kvwIvWrMr4Z6u0X_QSy4ChGQYceAoup=w426-h240-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.4182436530427!2d-8.616029328877604!3d41.147224171331295!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd24653709daa35f%3A0x369792482f760054!2sCastle%20Rock%20Pub%20%26%20Hotel!5e0!3m2!1sen!2spt!4v1713399031828!5m2!1sen!2spt"),

            new Club("Voyager 1", "Rua da Picaria 19", Type.BAR, City.PORTO, Genre.JAZZ,"https://lh5.googleusercontent.com/p/AF1QipOpQUCFEZpDVoYdM2V2rL6-SYNomViAee_W8IT9=w408-h306-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.3450527335453!2d-8.617653246800412!3d41.14882150796945!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2465f82fd31491%3A0x141135ef8208bcd5!2sVoyager%201%20Bar!5e0!3m2!1sen!2spt!4v1713399081709!5m2!1sen!2spt"),
            new Club("Mirajazz", "Escadas do Caminho Novo 11", Type.BAR, City.PORTO, Genre.JAZZ,"https://lh5.googleusercontent.com/p/AF1QipPKth_mKiBe3jwiUv2YNMGZbYGhj20c1_qelvD4=w408-h544-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.6760667168446!2d-8.620663928878306!3d41.14159697133203!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd24651e4fc80ac3%3A0x70de56b1cc13f557!2sMirajazz!5e0!3m2!1sen!2spt!4v1713399242582!5m2!1sen!2spt"),
            new Club("Porta-Jazz", "Praça da Républica 156", Type.BAR, City.PORTO, Genre.JAZZ,"https://lh5.googleusercontent.com/p/AF1QipOv0HximtQ1Qxn6i5lVjtdaZEmUq7pq5Y-CJcih=w408-h306-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3004.071603921967!2d-8.614437928876654!3d41.15478887133024!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd246590e9de502f%3A0x9b430a2fc5a6f5a0!2sPorta-Jazz!5e0!3m2!1sen!2spt!4v1713399358868!5m2!1sen!2spt"),

//LISBON
            new Club("LuxFrágil", "Av. Infante D. Henrique a Sta Apolónia Cais da Pedra", Type.NIGHTCLUB, City.LISBON, Genre.POP,"https://lh5.googleusercontent.com/p/AF1QipOx-TAVdd6SGoQ5AIlJDeJkE4rP5JTcZphS4_WP=w408-h270-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.1235158761833!2d-9.120662900000001!3d38.7149731!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19340a8fcfe389%3A0xbe7d463d131784a4!2sLuxFr%C3%A1gil!5e0!3m2!1sen!2spt!4v1713399481886!5m2!1sen!2spt"),
            new Club("Plateau", "Escadinhas da Praia 7", Type.NIGHTCLUB, City.LISBON, Genre.POP,"https://lh5.googleusercontent.com/p/AF1QipNvCdJJky0bcZSLHWFmmazY53meLwoGEua5x62v=w408-h544-k-no", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.4973520979315!2d-9.1600749291763!3d38.706388871765355!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19349b5a11a907%3A0xdde15d62294a507e!2sPlateau!5e0!3m2!1sen!2spt!4v1713399546203!5m2!1sen!2spt"),
            new Club("Dock's Club", "Rua da Cintura do Porto de Lisboa 226", Type.NIGHTCLUB, City.LISBON, Genre.POP,"https://activitiesinportugal.com/wp-content/uploads/docks-nightclub-1.webp","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.6383729538984!2d-9.169628829920626!3d38.70315025815163!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd1934a30f0a70fb%3A0x2adc9d1433e27aa7!2sDock&#39;s%20Club!5e0!3m2!1sen!2spt!4v1713399677654!5m2!1sen!2spt"),

            new Club("Monkey Mash", "Praça da Alegria 66 B", Type.BAR, City.LISBON, Genre.POP,"https://lh5.googleusercontent.com/p/AF1QipMmtt45S48WQaFbQ9jRWff2iiar6v6tVRHSOnkV=w408-h544-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3112.9833845558765!2d-9.147287529918712!3d38.71819045726768!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19334b9e861635%3A0x8dd72210fb0fe273!2sMonkey%20Mash!5e0!3m2!1sen!2spt!4v1713399721153!5m2!1sen!2spt"),

            new Club("Club Noir", "R. António Patrício 13b", Type.BAR, City.LISBON, Genre.ROCK,"https://lh5.googleusercontent.com/p/AF1QipN-yjKPuZ_vVRDMdE2kwyxUDC27k2NeSmgvoAmF=w408-h302-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3111.6204688860557!2d-9.150156552169571!3d38.74947069303815!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd193479cca09b55%3A0xa942ce0fb7506f41!2sClub%20Noir!5e0!3m2!1sen!2spt!4v1713399769635!5m2!1sen!2spt"),
            new Club("RCA Club", "R. João Saraiva 18", Type.BAR, City.LISBON, Genre.ROCK, "https://lh5.googleusercontent.com/p/AF1QipMRqYG1v0deB58gTtFdLqruzStcLgj60aJ76iJR=w408-h306-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3111.2979214848497!2d-9.144670129913925!3d38.75687035499303!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd193254fae7c083%3A0x9228ddf5c4d1cb80!2sRCA%20Club!5e0!3m2!1sen!2spt!4v1713399811254!5m2!1sen!2spt"),
            new Club("Eclipse Rock Bar", "R. do Diário de Notícias 3", Type.BAR, City.LISBON, Genre.ROCK,"https://lh5.googleusercontent.com/p/AF1QipMeA8RjpHY5O9_0FA3Bd7yRmpTkfHnjDnqiQ2Cd=w408-h306-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.293492893643!2d-9.148784652197588!3d38.71107019531467!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19347fb811c1cd%3A0x71549bde26e45cc5!2sEclipse%20Rock%20Bar!5e0!3m2!1sen!2spt!4v1713399880671!5m2!1sen!2spt"),


            new Club("Páginas Tantas", "R. do Dirário de Notícias 85", Type.BAR, City.LISBON, Genre.JAZZ,"https://lh5.googleusercontent.com/p/AF1QipPcbjEs5krDqeZUGW1OeMeis6RmANyrWo3TZP8x=w426-h240-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.232977147196!2d-9.146787729919396!3d38.71245975760453!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19347f8d323669%3A0x93ba7e222cb010e8!2sP%C3%A1ginas%20Tantas!5e0!3m2!1sen!2spt!4v1713399913022!5m2!1sen!2spt"),
            new Club("Nisa's Lounge", "R. da Madalena 11", Type.BAR, City.LISBON, Genre.JAZZ,"https://lh5.googleusercontent.com/p/AF1QipMUzmwuzLwXqM8ItO876xVKH5zIke2HHZb5vGp6=w408-h544-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.3117050340234!2d-9.140024511145018!3d38.71065199999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd1ecbbdc01f6795%3A0xeefa4af528f29f0f!2sNisa&#39;s%20Lounge!5e0!3m2!1sen!2spt!4v1713400171371!5m2!1sen!2spt"),
            new Club("O Bom O Mau e O Vilão", "R. do Alecrim 21", Type.BAR, City.LISBON, Genre.JAZZ, "https://lh5.googleusercontent.com/p/AF1QipMe0nejOG5Unqx2qHqrkFdYQevXGEza9JrjY-tW=w408-h510-k-no", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.4550465278026!2d-9.148146752200228!3d38.70736039553452!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19347dd08b4b7b%3A0xad39357670dac500!2sO%20Bom%20O%20Mau%20e%20O%20Vil%C3%A3o!5e0!3m2!1sen!2spt!4v1713400244906!5m2!1sen!2spt"),


            new Club("Rive Rouge", "Praça Dom Luís I", Type.NIGHTCLUB, City.LISBON, Genre.TECHNO, "https://lh5.googleusercontent.com/p/AF1QipP26ZETo0GIUY8J25eQT594iayaZyUXoRYSwxah=w408-h272-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.452492012133!2d-9.148707129920105!3d38.707419057900786!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd193487518be84b%3A0x41c6f99b711dbc84!2sRive%20Rouge!5e0!3m2!1sen!2spt!4v1713400295057!5m2!1sen!2spt"),
            new Club("Ministerium Club", "Praça do Comércio 72", Type.NIGHTCLUB, City.LISBON, Genre.TECHNO, "https://images.xceed.me/clubs/covers/ministerium-club-club-lisboa-xceed-b49a.jpg","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24907.556692367943!2d-9.1356073!3d38.7076006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19347a299ee955%3A0xe5dd067531a938ee!2sMinisterium%20Club!5e0!3m2!1sen!2spt!4v1713400401822!5m2!1sen!2spt"),
            new Club("Construction", "R. Cecílio de Sousa de 70", Type.NIGHTCLUB, City.LISBON, Genre.TECHNO,"https://lh5.googleusercontent.com/p/AF1QipMKiGbyouZoFZJd19TONzcCj5IOFCbKqbmYclAf=w408-h306-k-no","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3113.0602599712247!2d-9.152470029918955!3d38.716425457371415!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19337ec70dd8a1%3A0x3017a0a87d0706da!2sConstruction%20Lisbon!5e0!3m2!1sen!2spt!4v1713400445276!5m2!1sen!2spt")
    };

    public static Club getClub(Type type, City city, Genre genre) {
        List<Club> clubs = getClubListByType(type);
        clubs = getClubListByCity(city, clubs);
        clubs = getClubListByGenre(genre, clubs);

        if(clubs.isEmpty()){
            return getClub(null, city, genre);
        }
        return clubRndomizer(clubs);
    }

    private static List<Club> getClubListByType(Type type) {

        if(type == null){
            return List.of(CLUB_LIST);
        }
        List<Club> clubsByType = Arrays.stream(CLUB_LIST)
                .filter(club -> club.getType().equals(type))
                .collect(Collectors.toList());

        return clubsByType;
    }
    private static List<Club> getClubListByCity(City city, List<Club> clubs) {

        if(city == null){
            return clubs;
        }

        List<Club> clubsByCity = clubs.stream()
                .filter(club -> club.getCity().equals(city))
                .collect(Collectors.toList());

        return clubsByCity;
    }

    private static List<Club> getClubListByGenre(Genre genre, List<Club> clubs) {

        if(genre == null){
            return clubs;
        }
        List<Club> clubsByGenre = clubs.stream()
                .filter(club -> club.getGenre().equals(genre))
                .collect(Collectors.toList());

        return clubsByGenre;
    }

    private static Club clubRndomizer(List<Club> clubs) {

        int size = clubs.size();

        int rnd = (int) (Math.random() * size);

        return clubs.get(rnd);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Valentin
 */
public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> usedMonsters = new ArrayList<>();
    private ArrayList<Monster> unusedMonsters = new ArrayList<>();
    private ArrayList<Treasure> usedTreasures = new ArrayList<>();
    private ArrayList<Treasure> unusedTreasures = new ArrayList<>();
    private ArrayList<Cultist> unusedCultist = new ArrayList<>();
    private ArrayList<Cultist> usedCultist = new ArrayList<>();

    private CardDealer() {

    }

    private void initTreasureCardDeck() {
        Treasure tesoro = new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de investigacion", 3, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("A prueba de balas", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Casco minero", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Fez alopodo", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Insecticida", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrotelecom", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Porra prenatural", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);
    }

    private void initMonsterCardDeck() {
        //3 Byakhees de bonanza
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

        //Chibithulhu
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        //El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

        //Ángeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));

        //El gorron en el umbral
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, badConsequence, prize));

        //H.P. Munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));

        //Bichgooth
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));

        //El rey de rosa
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));

        //La que redacta en las tinieblas
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        //Los hondos
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

        //Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        //Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        //Pollipolipo volante
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));

        //Yskhtihyssg-Goth
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        //Familia feliz
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

        //Roboggoth
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        //El espia
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));

        //El lenguas
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize));

        //Bicefalo
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicefalo", 20, badConsequence, prize));
        
        /**
         * Monstruos con sectarios
         */
        
        //El mal indecible impronunciable
        badConsequence = new SpecificBadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize,-2));
        
        //Testigos Oculares
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize,2));
        
        //El gran cthulhu
        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres", true);
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        //Serpiente Politico
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence, prize, -2));
        
        //Felpuggoth
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
        
        //Shoggoth
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        //Lolitagooth
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
    }
    
    private void initCultistCardDeck() {
        Cultist c = new Cultist("Sectario",1);
        for(int i=0; i<4; i++){
            this.unusedCultist.add(c);
        }
        c = new Cultist("Sectario",2);
        for(int i=0; i<2; i++){
            this.unusedCultist.add(c);
        }
    }

    private void shuffleTreasures() {
        /* 
        Si no vamos a usar concurrencias, o Java < 1.7, se puede usar tambien Random asi:
        long seed = System.nanoTime();
        Collections.shuffle(this.unusedTreasures, new Random(seed));
        */
        Collections.shuffle(this.unusedTreasures, ThreadLocalRandom.current());
    }

    private void shuffleMonsters() {
        Collections.shuffle(this.unusedMonsters, ThreadLocalRandom.current());
    }
    
    private void shuffleCultists() {
        Collections.shuffle(this.unusedCultist, ThreadLocalRandom.current());
    }

    public static CardDealer getInstance() {
        return instance;
    }

    public Treasure nextTreasure() {
        int position = this.unusedTreasures.size()-1;
        if(position < 0) {
            this.unusedTreasures = new ArrayList<>(this.usedTreasures);
            this.shuffleTreasures();
            this.usedTreasures.clear();
        }
        Treasure t = this.unusedTreasures.get(position);
        this.unusedTreasures.remove(position);
        this.usedTreasures.add(t);
        return t;
    }

    public Monster nextMonster() {
        int position = this.unusedMonsters.size()-1;
        if(position < 0) {
            this.unusedMonsters = new ArrayList<>(this.usedMonsters);
            this.shuffleMonsters();
            this.usedMonsters.clear();
        }
        Monster m = this.unusedMonsters.get(position);
        this.unusedMonsters.remove(position);
        this.usedMonsters.add(m);
        return m;
    }
    
    public Cultist nextCultist() {
        int position = this.unusedCultist.size()-1;
        if(position < 0) {
            this.unusedCultist = new ArrayList<>(this.usedCultist);
            this.shuffleCultists();
            this.usedCultist.clear();
        }
        Cultist c = this.unusedCultist.get(position);
        this.unusedCultist.remove(position);
        this.usedCultist.add(c);
        return c;
    }

    public void giveTreasureBack(Treasure t) {
        if(unusedTreasures.indexOf(t) != -1){
            this.usedTreasures.add(t);
            this.unusedTreasures.remove(t);
        }
    }

    public void giveMonsterBack(Monster m) {
        if(unusedMonsters.indexOf(m) != -1){
            this.usedMonsters.add(m);
            this.unusedMonsters.remove(m);
        }
    }

    public void initCards() {
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
        this.shuffleMonsters();
        this.shuffleTreasures();
        this.shuffleCultists();
    }

}

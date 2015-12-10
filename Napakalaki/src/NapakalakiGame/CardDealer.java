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

    private CardDealer() {

    }

    private void initTreasureCardDeck() {
        Treasure tesoro = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de investigación", 3, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("A prueba de balas", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Casco minero", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Clavo de raíl ferroviario", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Fez alópodo", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Insecticida", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Garabato místico", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrotelecom", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Porra prenatural", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);
    }

    private void initMonsterCardDeck() {
        //3 Byakhees de bonanza
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

        //Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        //El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

        //Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));

        //El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El górron en el umbral", 10, badConsequence, prize));

        //H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));

        //Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));

        //El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));

        //La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        //Los hondos
        badConsequence = new BadConsequence("Estos unUsedMonsters resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        //Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        //Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        //Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        //El espía
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía", 5, badConsequence, prize));

        //El lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize));

        //Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    }

    private void shuffleTreasures() {
        /* 
        Si no vamos a usar concurrencias, o Java < 1.7, se puede usar también Random así:
        long seed = System.nanoTime();
        Collections.shuffle(this.unusedTreasures, new Random(seed));
        */
        Collections.shuffle(this.unusedTreasures, ThreadLocalRandom.current());
    }

    private void shuffleMonsters() {
        Collections.shuffle(this.unusedMonsters, ThreadLocalRandom.current());
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
            this.shuffleTreasures();
            this.usedMonsters.clear();
        }
        Monster m = this.unusedMonsters.get(position);
        this.unusedMonsters.remove(position);
        this.usedMonsters.add(m);
        return m;
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
        this.shuffleMonsters();
        this.shuffleTreasures();
    }

}

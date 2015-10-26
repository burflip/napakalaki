/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author valentin
 */
public class PruebaNapakalaki {
    
    public static ArrayList<Monster> getCombatLevelHigherThan(ArrayList<Monster> monstruos, int combatLevel)
    {
        ArrayList<Monster> monstruosConNivelSuperior = new ArrayList();
        for (Monster monstruo: monstruos) {
            if(monstruo.getCombatLevel() > combatLevel){
                monstruosConNivelSuperior.add(monstruo);
            }
        }
        
        return monstruosConNivelSuperior;
    }
    
    public static ArrayList<Monster> getBadConsequenceOnlyLostLevels(ArrayList<Monster> monstruos)
    {
        ArrayList<Monster> monstruosPerdidaNiveles = new ArrayList();
        for (Monster monstruo: monstruos) {
            BadConsequence currentMonsterBC = monstruo.getBadConsequence();
            if(currentMonsterBC.getLevels() > 0 && currentMonsterBC.getSpecificHiddenTreasures().isEmpty() && currentMonsterBC.getSpecificVisibleTreasures().isEmpty() && currentMonsterBC.getnHiddenTreasures() == 0 && currentMonsterBC.getnVisibleTreasures() == 0){
                monstruosPerdidaNiveles.add(monstruo);
            }
        }
        
        return monstruosPerdidaNiveles;
    }
    
    public static ArrayList<Monster> prizeLevelsHigherThan(ArrayList<Monster> monstruos, int prizeLevel)
    {
        ArrayList<Monster> monstruosConGananciaSuperior = new ArrayList();
        for (Monster monstruo: monstruos) {
            if(monstruo.getPrize().getLevel() > prizeLevel){
                monstruosConGananciaSuperior.add(monstruo);
            }
        }
        
        return monstruosConGananciaSuperior;
    }
    
    public static ArrayList<Monster> lostSpecificTreasures(ArrayList<Monster> monstruos)
    {
        ArrayList<Monster> monstruosPerdidaTesoros = new ArrayList();
        for (Monster monstruo: monstruos) {
            BadConsequence currentMonsterBC = monstruo.getBadConsequence();
            if(currentMonsterBC.getSpecificVisibleTreasures().size() > 0 || currentMonsterBC.getSpecificHiddenTreasures().size() > 0){
                monstruosPerdidaTesoros.add(monstruo);
            }
        }
        
        return monstruosPerdidaTesoros;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Monster> monstruos = new ArrayList();
        
        //3 Byakhees de bonanza
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
              
        //Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        //El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
        
        //El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 10, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El górron en el umbral", 10, badConsequence, prize));
        
        //H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        //El rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));    
        
        //La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        //Los hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", 10, 0, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        //Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        //Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", 10, 0, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
    
        //Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto", 10, 0, 0);
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //El espía
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espía", 5, badConsequence, prize));
    
        //El lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El lenguas", 20, badConsequence, prize));
        
        //Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        
        //MENU
        
        int opcion = 1;
        while(opcion != 5) {
            System.out.println("¿Qué monstruos desea mostrar? \n "
                + "1.- Nivel de combate superior a un número. \n "
                + "2.- Mal rollo que implique solo perdidas de nivel. \n "
                + "3.- Su buen rollo indique una ganancia de niveles superior a un número. \n "
                + "4.- Su mal rollo suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. \n "
                + "5.- Salir del menu. \n");
        
            Scanner in = new Scanner(System.in);
            String entrada = in.nextLine();

            opcion = Integer.parseInt(entrada);
            switch (opcion) {
            case 1:
                
                System.out.println("¿A qué nivel tiene que ser superior el monstruo?");
                entrada = in.nextLine();
                System.out.println(getCombatLevelHigherThan(monstruos,Integer.parseInt(entrada)));
                break;
            case 2: 
                System.out.println(getBadConsequenceOnlyLostLevels(monstruos));
                break;
            case 3:
                System.out.println("¿Con cuántos niveles debe premiar el buen rollo?");
                entrada = in.nextLine();
                System.out.println(prizeLevelsHigherThan(monstruos,Integer.parseInt(entrada)));
                break;
            case 4:
                System.out.println(lostSpecificTreasures(monstruos));
                break;
            case 5:
                return ;
            }
        }
        
    }
    
}

#encoding: utf-8
require 'singleton'

module NapakalakiGame
  class CardDealer
    
    include Singleton
    
    def initialize
      @unusedTreasures = Array.new
      @usedTreasures = Array.new
      @unusedMonsters = Array.new
      @usedMonsters = Array.new
    end
    
    def initTreasureCardDeck
      @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("Botas de investigación", 3, [TreasureKind::SHOES])
      @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("A prueba de balas", 2, [TreasureKind::ARMOR])
      @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Casco minero", 2, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, [TreasureKind::ARMOR])
      @unusedTreasures << Treasure.new("Clavo de raíl ferroviario", 3, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Fez alópodo", 3, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("Hacha prehistórica", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, [TreasureKind::ARMOR])
      @unusedTreasures << Treasure.new("Gaita", 4, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Insecticida", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Garabato místico", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("La rebeca metálica", 2, [TreasureKind::ARMOR])
      @unusedTreasures << Treasure.new("Lanzallamas", 4, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Necrocomicón", 1, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Necronomicón", 5, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Necrognomicón", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Necrotelecom", 2, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Necroplayboycón", 3, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Porra prenatural", 2, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Shogulador", 1, [TreasureKind::BOTHHANDS])
      @unusedTreasures << Treasure.new("Varita de atizamiento", 3, [TreasureKind::ONEHAND])
      @unusedTreasures << Treasure.new("Tentáculo de pega", 2, [TreasureKind::HELMET])
      @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, [TreasureKind::SHOES])
    end

    def initMonsterCardDeck
      #3 Byakhees de bonanza
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("3 Byakhees de bonanza", 8, badConsequence, prize)

      #Chibithulhu
      badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Chibithulhu", 2, badConsequence, prize)

      #El sopor de Dunwich
      badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El sopor de Dunwich", 2, badConsequence, prize)

      #Ángeles de la noche ibicenca
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y descarta 1 oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      prize = Prize.new(4, 1)
      @unusedMonsters << Monster.new("Angeles de la noche ibicenca", 14, badConsequence, prize)

      #El gorrón en el umbral
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0)
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("El górron en el umbral", 10, badConsequence, prize)

      #H.P. Munchcraft
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("H.P. Munchcraft", 6, badConsequence, prize)

      #Bichgooth
      badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bichgooth", 2, badConsequence, prize)

      #El rey de rosa
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
      prize = Prize.new(4, 2)
      @unusedMonsters << Monster.new("El rey de rosa", 13, badConsequence, prize)

      #La que redacta en las tinieblas
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("La que redacta en las tinieblas", 2, badConsequence, prize)

      #Los hondos
      badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Los hondos", 8, badConsequence, prize)

      #Semillas Cthulhu
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Semillas Cthulhu", 4, badConsequence, prize)

      #Dameargo
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Dameargo", 1, badConsequence, prize)

      #Pollipólipo volante
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Pollipólipo volante", 3, badConsequence, prize)

      #Yskhtihyssg-Goth
      badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("Yskhtihyssg-Goth", 12, badConsequence, prize)

      #Familia feliz
      badConsequence = BadConsequence.newDeath("La familia te atrapa. Estas muerto")
      prize = Prize.new(4, 1)
      @unusedMonsters << Monster.new("Familia feliz", 1, badConsequence, prize)

      #Roboggoth
      badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS], [])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Roboggoth", 8, badConsequence, prize)

      #El espía
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El espía", 5, badConsequence, prize)

      #El lenguas
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El lenguas", 20, badConsequence, prize)

      #Bicéfalo
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bicéfalo", 20, badConsequence, prize)

    end

    def shuffleTreasures
      @unusedTreasures.shuffle!
    end

    def shuffleMonsters
      @unusedMonsters.shuffle!
    end

    def nextTreasure
      if @unusedTreasures.empty?
        for i in 0 .. @unusedTreasures.size
          @unusedTreasures.push(@usedTreasures.at(i))
        end
        shuffleTreasures
      end
      
      @usedTreasures.clear
      @usedTreasures.push(@unusedTreasures.pop)
      @usedTreasures.last
    end

    def nextMonster
      if @unusedMonsters.empty?
          for i in 0 .. @unusedMonsters.size
            @unusedMonsters.push(@usedMonsters.at(i))
          end
          shuffleMonsters
        end
        
      @usedMonsters.clear
      @usedMonsters.push(@unusedMonsters.pop)
      @usedMonsters.last 
    end

    def giveTreasureBack(t)
      if(!@unusedTreasures.index(t).nil?)
        @usedTreasures << t
        @unusedTreasures.delete(t)
      end
    end
    
    def giveMonsterBack(t)
      if(!@unusedMonsters.index(t).nil?)
        @usedMonsters << t
        @unusedMonsters.delete(t)
      end
    end

    def initCards
      initTreasureCardDeck
      initMonsterCardDeck
      shuffleTreasures
      shuffleMonsters
    end
    
    private :initTreasureCardDeck, :initMonsterCardDeck, :shuffleTreasures, :shuffleMonsters
    
  end
end

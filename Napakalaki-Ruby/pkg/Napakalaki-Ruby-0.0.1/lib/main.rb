#encoding: utf-8
require_relative 'monster.rb'
require_relative 'bad_consequence.rb'
require_relative 'prize.rb'
require_relative 'treasure_kind.rb'

module NapakalakiGame

  def getCombatLevelHigherThan(monstruos, combatLevel)
    monstruosConNivelSuperior = Array.new
    monstruos.each do |monstruo| 
      if(monstruo.level > combatLevel)
        monstruosConNivelSuperior.push(monstruo)
      end
    end
    monstruosConNivelSuperior
  end

  def getBadConsequenceOnlyLostLevels(monstruos)
    monstruosPerdidaNiveles = Array.new
    monstruos.each do |monstruo|
    
      currentMonsterBC = monstruo.badConsequence
      if(currentMonsterBC.levels > 0 && currentMonsterBC.specificHiddenTreasures.empty? && currentMonsterBC.specificVisibleTreasures.empty? && currentMonsterBC.nHiddenTreasures == 0 && currentMonsterBC.nVisibleTreasures == 0)
        monstruosPerdidaNiveles.push(monstruo)
      end
    end
    monstruosPerdidaNiveles
  end

  def prizeLevelsHigherThan(monstruos, prizeLevel)
    monstruosConGananciaSuperior = Array.new
    monstruos.each do |monstruo| 
      if(monstruo.prize.level > prizeLevel)
        monstruosConGananciaSuperior.push(monstruo)
      end
    end
    monstruosConGananciaSuperior
  end

  def lostSpecificTreasures(monstruos)
    monstruosPerdidaTesoros = Array.new
    monstruos.each do |monstruo|
      currentMonsterBC = monstruo.badConsequence
      if(!currentMonsterBC.specificHiddenTreasures.empty? || currentMonsterBC.specificVisibleTreasures.empty?)
        monstruosPerdidaTesoros.push(monstruo)
      end
    end
    monstruosPerdidaTesoros
  end

  opcion = 1
  while(opcion)
    puts "¿Qué monstruos desea mostrar? \n 
1.- Nivel de combate superior a un número. \n
2.- Mal rollo que implique solo perdidas de nivel. \n
3.- Su buen rollo indique una ganancia de niveles superior a un número. \n
4.- Su mal rollo suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. \n
5.- Salir del programa. \n
6.- Contar monstruos con nivel superior a 15 \n"
  
    entrada = gets.chomp
    opcion = entrada
    case opcion
    when "1"
      puts "¿A qué nivel tiene que ser superior el monstruo?"
      entrada = gets.chomp
      puts getCombatLevelHigherThan(monsters, entrada.to_i)
      
    when "2"
      puts getBadConsequenceOnlyLostLevels(monsters)
      
    when "3"
      puts "¿Con cuántos niveles debe premiar el buen rollo?"
      entrada = gets.chomp
      puts prizeLevelsHigherThan(monsters, entrada.to_i)
      
    when "4"
      puts lostSpecificTreasures(monsters)
      
    when "5"
      puts "Adiós!"
      exit
      
    else
      puts "Por favor, elige un número del 1 al 6"
      
    end
  end
end
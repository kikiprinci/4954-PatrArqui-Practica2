# 4954-Patrones y arquitectura software-Practica2

## Diseño y calidad del Software 
### Practica 2
* Fecha de entrega: 21/10/2019
* Integrante:
  * Fran Arboleya
  
## Branchs
* Master: 
    * informacion en el readme
    * implementación de Modelo-Vista-Presentador con vista pasiva
   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://liveuml.com/generated/a17d605899eec4c0.png">
</p>

### PlantUML
 
 ```PlantUML
@startuml


class Mastermind{
# Mastermind()
# play():void
+ main():void
}


note left 
public void play(){ controllers.get(session.getValue()).control(); } 
end note 

Mastermind *-down-> Session 
Mastermind *-down-> StartController 
Mastermind *-down-> ProposalController 
Mastermind *-down-> ResumeController 
abstract class Controller{ 
# Session:Session
+{abstract} void control() 
} 
Controller --> Session 
Controller <|-down- StartController 
Controller <|-down- ProposalController 
Controller <|-down- ResumeController 
class StartController { 
+ StartController(Session:Session)
+ control():void 
} 
note right 
public void control(){ new GameView().showTitle(); session.next(); } 
end note 
class ProposalController { 
+ ProposalController(Session:Session)
+ control():void 
} 
class ResumeController { 
+ ResumeController(Session:Session)
+ control():void 
}

StartController --> StartView
StartController --> SecretCombinationView
ProposalController --> ProposedCombinationView
ProposalController --> GameView

class Session {
 - game:Game
 - state:State
 + Session()
 + resume():void
 + next():void
 + getValueState():StateValue
 + getWidth():int
 + addProposedCombination(colors:List<Color>):void
 + isLooser():boolean
 + isWinner():boolean
 + getAttempts():int
 + getColors(position:int):List<Color>
 + getBlacks(position:int):int
 + getWhites(position:int):int 
 + clear():void
 + getResults():List<Result>
 + getProposedCombinations():List<ProposedCombination>
}
Session *-down-> State 
Session *-down-> Game 

class State{
 + State()
 + next():void
 + reset():void
 + getValueState():StateValue
}

class Game{
- {static}MAX_LONG:int
- secretCombination:SecretCombination;
- proposedCombinations:List<ProposedCombination> 
- results:List<Result>
- attempts:int
 + clear():void
 + addProposedCombination(Colors:List<Color>):void
 + isLooser():boolean
 + isWinner():boolean
 + getAttempts():int
 + getColors(position:int):List<Color>
 + getBlacks(position:int):int
 + getWhites(position:int):int
 + getWidth():int
 + getResults():List<Result>
}

class ProposedCombinationView{
 + ProposedCombinationView()
 + write(position:int,session:Session ):void
 + read():List<Color> 
 - readColors():List<Color> 
}

ProposedCombinationView --> Combination
ProposedCombinationView --> ErrorView

class Combination{
 - WIDTH:int
 # colors:List<Color>
 # Combination()
 + {static} getWidth():int 
}

class ErrorView{
+ {static} MESSAGES:String[] 
# error:Error
+ ErrorView(error:Error)
+ getMessage():String
}

class GameView{
+ GameView()
+ write():void
}

class StartView{
+ StartView()
+ write(session:Session):void
+ checkResult(session:Session):void
}

class SecretCombinationView{
+ SecretCombinationView()
+ write(width:int):void
}

class AttemptsView{
+ AttemptsView()
+ writeln(attempts:int):void
}

class ResultView{
+ ResultView()
+ write(result:Result):void
+ write(message:string):void
}

GameView --> AttemptsView
GameView --> SecretCombinationView
GameView --> ProposedCombinationView
GameView --> ResultView

@enduml
```

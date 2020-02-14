import Animals
import ZooKeeper

def main():
    zoo = [
            Animals.Hippo("Harry"),
            Animals.Elephant("Elenor"),
            Animals.Wolf("Wolfgang"),
            Animals.Dog("Dain"),
            Animals.Fox("Ferris"),
            Animals.Tiger("Tony"),
            Animals.Lion("Lenny"),
            Animals.ElephantLionChimera("Chris"), # Chris the Chimera?
            Animals.Cat("Curtis"),
          ]
    
    zeke = ZooKeeper.ZooKeeper("Zeke", zoo)
    zain = ZooKeeper.ZooAnnoucer("Zain", zeke)
    zeke.attach(zain)
    zeke.wakeUpAnimals()
    zeke.rollCall()
    zeke.feedTheAnimals()
    zeke.exersizeTheAnimals()
    zeke.goToSleep()
    zeke.detach(zain)
    
    # Not necesary in python, but still possible!
    del zeke
    del zain
    del zoo


if __name__ == "__main__":
    main()
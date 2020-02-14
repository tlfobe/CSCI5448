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
    zeke.wakeUpAnimals()
    zeke.rollCall()
    zeke.feedTheAnimals()
    zeke.exersizeTheAnimals()
    zeke.goToSleep()


if __name__ == "__main__":
    main()
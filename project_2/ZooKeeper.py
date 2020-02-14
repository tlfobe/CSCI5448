from abc import ABC
from abc import abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, subject: Subject):
        pass

class Subject(ABC):
    @abstractmethod
    def attach(self, observer: Observer) -> None:
        pass

    @abstractmethod
    def detach(self, observer: Observer) -> None:
        pass

    @abstractmethod
    def notify(self) -> None:
        pass



class ZooKeeper(Subject):
    def __init__(self, name, zoo):
        self.name = name
        self.zoo = zoo

    def wakeUpAnimals(self):
        for animal in self.zoo:
            print(self.name + " wakes up " + animal._name + " the " + animal._type + ".")

    def rollCall(self):
        print("-----  ROLL CALL  -----")
        for animal in self.zoo:
            animal.makeNoise()
    
    def feedTheAnimals(self):
        print("-----  FEEDING TIME  -----")
        for animal in self.zoo:
            print(self.name + " feeds " + animal._name +  " the " + animal._type  + ".")
            animal.eatFood()
    
    def exersizeTheAnimals(self):
        for animal in self.zoo:
            print(self.name + " exercises " + animal._name + " the " + animal._type + ".")
            animal.roam()

    def goToSleep(self):
        for animal in self.zoo:
            print(self.name + " puts " + animal._name + " the " + animal._type + " to sleep.")
            animal.sleep()


class ZooAnnoucer(Observer):
    pass    
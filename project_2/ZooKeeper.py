from abc import ABC
from abc import abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, subject):
        pass

class Subject(ABC):
    def __init__(self):
        self._observers = []
        self._observable = None

    @abstractmethod
    def attach(self, observer: Observer):
        pass

    @abstractmethod
    def detach(self, observer: Observer):
        pass

    @abstractmethod
    def notify(self):
        pass

class ZooKeeper(Subject):
    def __init__(self, name, zoo):
        super(ZooKeeper, self).__init__()
        self.name = name
        self.zoo = zoo
    
    def attach(self, observer: Observer):
        self._observers.append(observer)

    def detach(self, observer: Observer):
        self._observers.remove(observer)

    def notify(self):
        for ob in self._observers:
            ob.update(self)

    def setState(self, state: str):
        self._observable = state
        self.notify()

    def getState(self):
        return(self._observable)

    def wakeUpAnimals(self):
        self.setState("waking the animals")
        for animal in self.zoo:
            print(self.name + " wakes up " + animal._name + " the " + animal._type + ".")

    def rollCall(self):
        self.setState("doing rollcall")
        print("-----  ROLL CALL  -----")
        for animal in self.zoo:
            animal.makeNoise()
    
    def feedTheAnimals(self):
        self.setState("feeding the animals")
        print("-----  FEEDING TIME  -----")
        for animal in self.zoo:
            print(self.name + " feeds " + animal._name +  " the " + animal._type  + ".")
            animal.eatFood()
    
    def exersizeTheAnimals(self):
        self.setState("exersizing the animals")
        for animal in self.zoo:
            print(self.name + " exercises " + animal._name + " the " + animal._type + ".")
            animal.roam()

    def goToSleep(self):
        self.setState("putting the animals to bed")
        for animal in self.zoo:
            print(self.name + " puts " + animal._name + " the " + animal._type + " to sleep.")
            animal.sleep()
class ZooAnnoucer(Observer):
    def __init__(self, name: str, zookeeper: ZooKeeper):
        self.name = name
        self.subject = zookeeper

    def update(self, subject: Subject):
        self.announce(subject._observable)

    def announce(self, action: str):
        print(self.name + ": Attention everyone!")
        print(self.name + ": Please direct your attention to " + self.subject.name + " the zookeeper!")
        print(self.name + ": " + self.subject.name + " is " + action + "!")
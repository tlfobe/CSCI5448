from abc import ABC
import AnimalBehaviors as ab
import numpy as np

class Animal(ABC):
    def __init__(self, name):

        # we'll consider _ to be protected and __ to be private
        self._name = name
        self._type = None
        self._sleepBehavior = ab.DefaultSleepBehavior(self)
        self._eatFoodBehavior = None
        self._makeNoiseBehavior = None
        self._roamBehavior = None

    def _setSleepBehavior(self, sleep_behavior):
        self._sleepBehavior = sleep_behavior

    def _setEatFoodBehavior(self, eat_behavior):
        self._eatFoodBehavior = eat_behavior

    def _setMakeNoiseBehavior(self, noise_behavior):
        self._makeNoiseBehavior = noise_behavior

    def _setRoamBehavior(self, roam_behavior):
        self._roamBehavior = roam_behavior

    def sleep(self):
        self._sleepBehavior.sleep()

    def roam(self):
        self._roamBehavior.roam()

    def makeNoise(self):
        self._makeNoiseBehavior.makeNoise()

    def eatFood(self, food = None):
        if food == None:
            self._eatFoodBehavior.eatFood()
        else:
            self._eatFoodBehavior.eatFood(food)

class Feline(Animal):
    def __init__(self, name):
        super(Feline, self).__init__(name)
        self._setRoamBehavior(ab.PaddingRoamBehavior(self))
        

class Pachyderm(Animal):
    def __init__(self, name):
        super(Pachyderm, self).__init__(name)
        self._setRoamBehavior(ab.WaddlesRoamBehavior(self))

class Canine(Animal):
    def __init__(self, name):
        super(Canine, self).__init__(name)
        self._setRoamBehavior(ab.RunRoamBehavior(self))

class Dog(Canine):
    def __init__(self, name):
        super(Dog, self).__init__(name)
        self._type = "Dog"
        self._setMakeNoiseBehavior(ab.barkBehavior(self))
        self._setEatFoodBehavior(ab.DomesticatedMessyEatFoodBehavior(self))
    
class Wolf(Canine):
    def __init__(self, name):
        super(Wolf, self).__init__(name)
        self._type = "Wolf"
        self._setMakeNoiseBehavior(ab.HowlBehavior(self))
        self._setEatFoodBehavior(ab.WildMessyEatFoodBehavior(self))

class Fox(Canine):
    def __init__(self, name):
        super(Fox, self).__init__(name)
        self._type = "Fox"
        self._setMakeNoiseBehavior(ab.HowlBehavior(self))
        self._setEatFoodBehavior(ab.WildNeatEatFoodBehavior(self))

    
class Hippo(Pachyderm):
    def __init__(self, name):
        super(Hippo, self).__init__(name)
        self._type = "Hippo"
        self._setMakeNoiseBehavior(ab.HuffMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.BigMouthEatFoodBehavior(self))

class Elephant(Pachyderm):
    def __init__(self, name):
        super(Elephant, self).__init__(name)
        self._type = "Elephant"
        self._setMakeNoiseBehavior(ab.TrunkTootMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.TrunkEatFoodBehavior(self))


class Tiger(Feline):
    def __init__(self, name):
        super(Tiger,self).__init__(name)
        self._type = "Tiger"
        self._setMakeNoiseBehavior(ab.RoarMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.StickyPawsEatFoodBehavior(self))

class Lion(Feline):
    def __init__(self, name):
        super(Lion, self).__init__(name)
        self._type = "Lion"
        self._setMakeNoiseBehavior(ab.RoarMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.StickyManeEatFoodBehavior(self))

class ElephantLionChimera(Pachyderm, Feline): # Inherits Pachyderm methods before Feline methods
    def __init__(self, name):
        super(ElephantLionChimera, self).__init__(name)
        self._type = "Elephant Lion Chimera"
        self._setMakeNoiseBehavior(ab.TrunkTootMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.StickyManeEatFoodBehavior(self))


class Cat(Feline):
    def __init__(self, name):
        super(Cat, self).__init__(name)
        self._type = "Cat"
        self._setMakeNoiseBehavior(ab.MeowMakeNoiseBehavior(self))
        self._setEatFoodBehavior(ab.DomesticatedNeatEatFoodBehavior(self))
        self._hissMakeNoiseBehavior = ab.HissMakeNoiseBehavior(self)
        self._actions = [
                        self._sleep,
                        self._eatFood,
                        self._roam,
                        self._hiss,
                        self._makeNoise,
                       ]

    def _shouldI(self, action_i):
        rand_action = np.random.randint(5)
        while rand_action != action_i:
            self._actions[rand_action]()
            rand_action = np.random.randint(5)

    def _sleep(self):
        self._sleepBehavior.sleep()

    def _roam(self):
        self._roamBehavior.roam()

    def _makeNoise(self):
        self._makeNoiseBehavior.makeNoise()

    def _eatFood(self, food = None):
        self._eatFoodBehavior.eatFood()

    def _hiss(self):
        self._hissMakeNoiseBehavior.makeNoise()

    def sleep(self):
        self._shouldI(0)
        self._sleep()

    def roam(self):
        self._shouldI(2)
        self._roam()

    def makeNoise(self):
        self._shouldI(4)
        self._makeNoise()

    def eatFood(self, food = None):
        self._shouldI(1)
        self.eatFood(food)

if __name__ == "__main__":
    f = Feline("asdf")
    f.sleep()



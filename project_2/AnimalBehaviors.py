from abc import ABC
from abc import abstractmethod

# All behavior classes have a class object back to the animal to
# get animal names and types

class Behavior(ABC):
    def __init__(self, animal):
        self._animal = animal

class RoamBehavior(Behavior):
    @abstractmethod
    def roam(self):
        pass

class makeNoiseBehavior(Behavior):
    @abstractmethod
    def makeNoise(self):
        pass

class eatFoodBehavior(Behavior):
    @abstractmethod
    def eatFood(self):
        pass

class sleepBehavior(Behavior):
    @abstractmethod
    def sleep(self):
        pass

# SleepBehaviors

class DefaultSleepBehavior(sleepBehavior):
    def sleep(self):
        print(f"{self._animal._name} the {self._animal._type}: ZZZZZZZzzzzzzzz")

# RoamBehaviors

class PaddingRoamBehavior(RoamBehavior):
    def roam(self):
        print(f"{self._animal._name} the {self._animal._type}: lazily pads around the den.")

class WaddlesRoamBehavior(RoamBehavior):
    def roam(self):
        print(f"{self._animal._name} the {self._animal._type}:  slowly waddles aroudn the field.")

class RunRoamBehavior(RoamBehavior):
    def roam(self):
        print(f"{self._animal._name} the {self._animal._type}: excitedly runs around the yard.")

# MakeNoiseBehaviors

class BarkMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Woof!")

class HowlMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Awoooo!")

class HuffMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Huff Huff Huff!")

class TrunkTootMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Twoot Twoooooot!")

class RoarMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Roaar Roaar!")

class MeowMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Meeeeeeoooow!")

class HissMakeNoiseBehavior(makeNoiseBehavior):
    def makeNoise(self):
        print(f"{self._animal._name} the {self._animal._type}: Hissssssss!")

# EatBehaviors

class DomesticatedMessyEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='kibble'):
        print(f"{self._animal._name} the {self._animal._type}: Nom Nom Nom ")
        print(f"Pieces of {food} are littered all over the floor!")

class DomesticatedNeatEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='kibble'):
        print(f"{self._animal._name} the {self._animal._type}: Nom Nom Nom ")
        print(f"Pieces of {food} are littered all over the floor!")

class WildMessyEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='lamb'):
        print(f"{self._animal._name} the {self._animal._type}: Chomp Chomp Chomp")
        print(f"Shredded morsels of {food} are scatted all over the place!")

class WildNeatEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='kibble'):
        print(f"{self._animal._name} the {self._animal._type}: Chomp Chomp Chomp")
        print(f"Tiny shreds of " + {food} + " are sprinkled all over the floor!")

class BigMouthEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food = "watermelon"):
        print(f"{self._animal._name} the {self._animal._type}: Flap Flap Flap")
        print(f"{self._animal._name} the {self._animal._type} powerfully crushes the {food} in one bite!")

class TrunkEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='peanuts'):
        print(f"{self._animal._name} the {self._animal._type}: Crunch Crunch Crunch")
        print(f"{self._animal._name} the {self._animal._type} gingerly eats the {food} with its trunk")

class StickyPawsEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='deer'):
        print(f"{self._animal._name} the {self._animal._type}: Crunch Crunch")
        print(f"Pieces of {food} cling to {self._animal._name}'s paws!'")

class StickyManeEatFoodBehavior(eatFoodBehavior):
    def eatFood(self, food='gazelle'):
        print(f"{self._animal._name} the {self._animal._type}: Crunch Crunch")
        print(f"Pinces of {food} cling to {self._animal._name}'s mane!'")


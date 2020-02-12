from abc import ABC

class Animal(ABC):
    def __init__(self, name):

        # we'll consider _ to be protected and __ to be private
        self._name = name
        self._type = None

    def sleep(self):
        print(f"{self._name} the {self._type}: ZZZZzzzzzzzz")
    
    def roam(self):
        raise NotImplementedError

    def makeNoise(self):
        raise NotImplementedError

    def eatFood(self, food):
        raise NotImplementedError


class Feline(Animal):
    def __init__(self, name):
        super(Feline, self).__init__(name)

    def roam(self):
        print(f"{self._name} the {self._type} lazily pads around the den.")    


class Pachyderm(Animal):
    def __init__(self, name):
        super(Pachyderm, self).__init__(name)

    def roam(self):
        print(f"{self._name} the {self._type} slowly waddles aroudn the field.")

class Canine(Animal):
    def __init__(self, name):
        super(Canine, self).__init__(name)

    def roam(self):
        print(f"{self._name} the {self._type} excitedly runs around the yard.")


class Dog(Canine):
    def __init__(self, name):
        super(Dog, self).__init__(name)
        self._type = "Dog"
    
    def makeNoise(self):
        print(f"{self._name} the {self._type}: Woof!")
    
    def eatFood(self, food='kibble'):
        print(f"{self._name} the {self._type}: Nom Nom Nom ")
        print(f"Pieces of {food} are littered all over the floor!")

class Wolf(Canine):
    def __init__(self, name):
        super(Dog, self).__init__(name)
        self._type = "Wolf"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Awoooo!")

    def eatFood(self, food='lamb'):
        print(f"{self.name} the {self._type}: Chomp Chomp Chomp")
        print(f"Shredded morsels of {food} are scatted all over the place!")

class Fox(Canine):
    def __init__(self, name):
        super(Fox, self).__init__(name)
        self._type = "Fox"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Awoooo!")

    def eatFood(self, food='kibble'):
        print(f"{self._name} the {self._type}: Chomp Chomp Chomp")
        print(f"Tiny shreds of " + {food} + " are sprinkled all over the floor!")
    
class Hippo(Pachyderm):
    def __init__(self, name):
        super(Hippo, self).__init__(name)
        self._type = "Hippo"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Huff Huff Huff!")

    def eatFood(self, food='fish'):
        print(f"{self._name} the {self._type}: Flap Flap Flap")
        print(f"{self._name} the {self._type} powerfully crushes the {food} in one bite!")

class Elephant(Pachyderm):
    def __init__(self, name):
        super(Elephant, self).__init__(name)
        self._type = "Elephant"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Twoot Twoooooot!")

    def eatFood(self, food='peanuts'):
        print(f"{self._name} the {self._type}: Crunch Crunch Crunch")
        print(f"{self._name} the {self._type} gingerly eats the {food} with its trunk")


class Tiger(Feline):
    def __init__(self, name):
        super(Tiger,self).__init__(name)
        self._type = "Tiger"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Roaar Roaar!")

    def eatFood(self, food='deer')
        print(f"{self._name} the {self._type}: Crunch Crunch")
        print(f"Pieces of {food} cling to {self._name}'s paws!'")

class Lion(Feline):
    def __init__(self, name):
        super(Lion, self).__init__(name)
        self._type = "Lion"

    def makeNoise(self):
        print(f"{self._name} the {self._type}: Roaaar Roaar!")
        print(f"Pinces of {food} cling to {self._name}'s mane!'")

class Cat(Feline):
    def __init__(self, name):
        raise NotImplementedError

if __name__ == "__main__":
    f = Feline("asdf")
    f.sleep()


